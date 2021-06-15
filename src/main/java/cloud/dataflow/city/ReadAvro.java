package cloud.dataflow.city;

import cloud.dataflow.city.entity.EventStatistic;
import cloud.dataflow.city.option.CityAnalyzerOptions;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.AvroIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;

public class ReadAvro {
    public static void main(String[] args) {
        CityAnalyzerOptions options =
                PipelineOptionsFactory.fromArgs(args).withValidation().as(CityAnalyzerOptions.class);
        Pipeline p = Pipeline.create(options);

        PCollection<EventStatistic> apply = p.apply(AvroIO.read(EventStatistic.class).from("src/main/resources/output/Kyiv-00000-of-00003.avro"));
        apply.apply(ParDo.of(new DoFn<EventStatistic,
                String>() {

            @ProcessElement
            public void sout(@Element EventStatistic event, OutputReceiver<String> receiver) {
                System.out.println(event);
                receiver.output(event.toString());
            }
        }));

        p.run().waitUntilFinish();
    }
}
