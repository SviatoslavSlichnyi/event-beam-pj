package cloud.dataflow.city.transform;

import cloud.dataflow.city.entity.EventStatistic;
import org.apache.beam.sdk.transforms.PTransform;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.PDone;

public class WriteIntoAvro extends PTransform<PCollection<KV<String, EventStatistic>>, PDone> {
    @Override
    public PDone expand(PCollection<KV<String, EventStatistic>> input) {


        return null;
    }
}
