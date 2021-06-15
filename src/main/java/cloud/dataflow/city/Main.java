package cloud.dataflow.city;

import cloud.dataflow.city.entity.*;
import cloud.dataflow.city.option.CityAnalyzerOptions;
import cloud.dataflow.city.transform.DebugSoutTransform;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.*;
import org.apache.beam.sdk.extensions.jackson.ParseJsons;
import org.apache.beam.sdk.io.AvroIO;
import org.apache.beam.sdk.io.FileIO;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.*;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Main {
    public static void main(String[] args) {
        CityAnalyzerOptions options =
                PipelineOptionsFactory.fromArgs(args).withValidation().as(CityAnalyzerOptions.class);

        runCityAnalyzer(options);
    }

    private static void runCityAnalyzer(CityAnalyzerOptions options) {
        Pipeline p = Pipeline.create(options);

        // read lines from all files in "resource/input" folder
        PCollection<String> lines = p.apply("Reading JSONl", TextIO.read().from(options.getInputFiles()));

        // debug: verify if all lines were read
        lines.apply(new DebugSoutTransform());

        // Parse line into Event object
        PCollection<Event> events = lines.apply(ParseJsons.of(Event.class)).setCoder(SerializableCoder.of(Event.class));

        // map PCollection<Event> => KV<String, Event> (key - "city", value - Event obj)
        PCollection<KV<String, Event>> eventsKV = events.apply(WithKeys.of(Event::getCity))
                .setCoder(KvCoder.of(StringDelegateCoder.of(String.class), SerializableCoder.of(Event.class)));

        // group eventsKV to something like map where key - "city" and value - List<Event>
        // KV<String, Event> => KV<String, Iterable<Event>>
        PCollection<KV<String, Iterable<Event>>> eventsMap = eventsKV
                .apply(GroupByKey.create())
                .setCoder(KvCoder.of(StringDelegateCoder.of(String.class), IterableCoder.of(SerializableCoder.of(Event.class))));

        // KV<String, List<Event>> => KV<String, EventStatistic>
        // main goal to process List<Event> -> EventStatistic
        // use ParDo.of(new calculateStatistic)
        PCollection<KV<String, EventStatistic>> result = eventsMap.apply(ParDo.of(new DoFn<KV<String, Iterable<Event>>, KV<String, EventStatistic>>() {
            @ProcessElement
            public void processElement(@Element KV<String, Iterable<Event>> cityEvent, OutputReceiver<KV<String, EventStatistic>> receiver) {
                // events which are grouped by EventSubject
                Map<EventSubject, List<Event>> eventSubjectListMap = StreamSupport
                        .stream(Objects.requireNonNull(cityEvent.getValue()).spliterator(), false)
                        .collect(Collectors.groupingBy(Event::getEventSubject));

                // map list of statistics of events
                List<EventStatisticSubject> citiesSubjects = eventSubjectListMap.keySet().stream()
                        .map(eventSubject -> {
                            // get event for current event subject
                            List<Event> eventWithCurrentSubjectList = eventSubjectListMap.get(eventSubject);

                            // get events grouped by event type from list of event which belongs to current subject
                            Map<String, List<Event>> eventActivityByEventType = eventWithCurrentSubjectList.stream()
                                    .collect(Collectors.groupingBy(Event::getEventType));

                            // mapping event to statistic event with calculations
                            // creation of "activities" list
                            List<EventStatisticSubjectActivities> activities = eventActivityByEventType.entrySet().stream()
                                    .map(event -> {
                                        String eventType = event.getKey();
                                        int past7daysCount = (int) event.getValue().stream()
                                                .filter(evt -> evt.getTimestamp().toInstant().isBefore(Instant.now().plus(7, ChronoUnit.DAYS)))
                                                .count();
                                        int past7daysUniqueCount = (int) event.getValue().stream()
                                                .filter(evt -> evt.getTimestamp().toInstant().isBefore(Instant.now().plus(7, ChronoUnit.DAYS)))
                                                .filter(evt -> eventActivityByEventType.get(evt.getEventType()).size() == 1)
                                                .count();
                                        int past30daysCount = (int) event.getValue().stream()
                                                .filter(evt -> evt.getTimestamp().toInstant().isBefore(Instant.now().plus(30, ChronoUnit.DAYS)))
                                                .count();
                                        int past30daysUniqueCount = (int) event.getValue().stream()
                                                .filter(evt -> evt.getTimestamp().toInstant().isBefore(Instant.now().plus(30, ChronoUnit.DAYS)))
                                                .filter(evt -> eventActivityByEventType.get(evt.getEventType()).size() == 1)
                                                .count();

                                        return new EventStatisticSubjectActivities(eventType, past7daysCount,
                                                past7daysUniqueCount, past30daysCount, past30daysUniqueCount);
                                    }).collect(Collectors.toList());

                            return new EventStatisticSubject(eventSubject.getId(), eventSubject.getType(), activities);
                        })
                        .collect(Collectors.toList());

                String cityName = cityEvent.getKey();
                EventStatistic eventStatistic = new EventStatistic(citiesSubjects);
                receiver.output(KV.of(cityName, eventStatistic));
            }
        })).setCoder(KvCoder.of(StringDelegateCoder.of(String.class), AvroCoder.of(EventStatistic.class)));

        // debug: print result
        result.apply(ParDo.of(new DoFn<KV<String, EventStatistic>, KV<String, EventStatistic>>() {
            @ProcessElement public void debug(@Element KV<String, EventStatistic> element, OutputReceiver<KV<String, EventStatistic>> outputReceiver) {
                System.out.println(element.getKey() + ": " + element.getValue());
            }
        }));


        // write into avro format results where 'key' is file name and 'values' is body for file.
        result.apply("Write Analyzing results", FileIO.<String, KV<String, EventStatistic>>writeDynamic()
                .withDestinationCoder(StringDelegateCoder.of(String.class))
                .by(KV::getKey)
                .via(Contextful.fn((SerializableFunction<KV<String, EventStatistic>, EventStatistic>) KV::getValue), AvroIO.sink(EventStatistic.class))
                .to(options.getOutput())
                .withNaming((SerializableFunction<String, FileIO.Write.FileNaming>) key -> FileIO.Write.defaultNaming(key, ".avro"))
        );

        p.run().waitUntilFinish();
    }
}
