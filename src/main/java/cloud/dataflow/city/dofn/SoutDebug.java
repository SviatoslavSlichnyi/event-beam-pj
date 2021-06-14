package cloud.dataflow.city.dofn;

import org.apache.beam.sdk.transforms.DoFn;

public class SoutDebug extends DoFn<String, String> {

    @ProcessElement
    public void processElement(@Element String input, OutputReceiver<String> outputReceiver) {
        System.out.println("Text-line: " + input);

        outputReceiver.output(input);
    }

}
