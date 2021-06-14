package cloud.dataflow.city;

import cloud.dataflow.city.dofn.GenerateRandomEventStatisticObjs;
import cloud.dataflow.city.entity.Event;
import cloud.dataflow.city.entity.EventStatistic;
import cloud.dataflow.city.option.CityAnalyzerOptions;
import cloud.dataflow.city.transform.DebugSoutTransform;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.SerializableCoder;
import org.apache.beam.sdk.extensions.jackson.ParseJsons;
import org.apache.beam.sdk.io.AvroIO;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CityAnalyzerOptions options =
                PipelineOptionsFactory.fromArgs(args).withValidation().as(CityAnalyzerOptions.class);

        runCityAnalyzer(options);
    }

    private static void runCityAnalyzer(CityAnalyzerOptions options) throws IOException {
        Pipeline p = Pipeline.create(options);

        // read lines from all files in "resource/input" folder
        PCollection<String> lines = p.apply("Reading JSONl", TextIO.read().from(options.getInputFiles()));

        // debug: verify if all lines were read
        lines.apply(new DebugSoutTransform());

        // Parse line into Event object
        PCollection<Event> events = lines.apply(ParseJsons.of(Event.class)).setCoder(SerializableCoder.of(Event.class));

        // todo: process data in some way
        PCollection<EventStatistic> eventStatistics = events.apply(ParDo.of(new GenerateRandomEventStatisticObjs()));

        // write into avro format results
        eventStatistics.apply("Write Analyzing results", AvroIO.write(EventStatistic.class)
                .to(options.getOutput()).withSuffix(".avro")
        );

        p.run().waitUntilFinish();
    }
}
