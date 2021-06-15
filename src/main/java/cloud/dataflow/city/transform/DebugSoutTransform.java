package cloud.dataflow.city.transform;

import cloud.dataflow.city.dofn.SoutDebug;
import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;

public class DebugSoutTransform extends PTransform<PCollection<String>, PCollection<String>> {

    @Override
    public PCollection<String> expand(PCollection<String> input) {
        return input.apply(ParDo.of(new SoutDebug()));
    }
}
