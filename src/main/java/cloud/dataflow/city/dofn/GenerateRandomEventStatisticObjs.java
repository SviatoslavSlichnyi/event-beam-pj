package cloud.dataflow.city.dofn;

import cloud.dataflow.city.entity.Event;
import cloud.dataflow.city.entity.EventStatistic;
import cloud.dataflow.city.entity.EventStatisticSubject;
import cloud.dataflow.city.entity.EventStatisticSubjectActivities;
import org.apache.beam.sdk.transforms.DoFn;

import java.util.Arrays;
import java.util.Random;

public class GenerateRandomEventStatisticObjs extends DoFn<Event, EventStatistic> {

    @ProcessElement
    public void processElement(@Element Event event, OutputReceiver<EventStatistic> receiver) {
        System.out.println("Parsed-Object: " + event);

        // generate random EventStatistic for now
        // only for avro writing check
        EventStatistic eventStatistic = new EventStatistic(Arrays.asList(
                new EventStatisticSubject(
                        randLong(), "article", Arrays.asList(genRandAct(), genRandAct(), genRandAct())),
                new EventStatisticSubject(
                        randLong(), "article", Arrays.asList(genRandAct(), genRandAct(), genRandAct()))
        ));

        receiver.output(eventStatistic);
    }

    public static int randInt() {
        return new Random().nextInt(100);
    }

    public static long randLong() {
        return new Random().nextLong();
    }

    public static EventStatisticSubjectActivities genRandAct() {
        return new EventStatisticSubjectActivities("click", randInt(), randInt(), randInt(), randInt());
    }
}
