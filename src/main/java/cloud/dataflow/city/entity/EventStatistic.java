/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package cloud.dataflow.city.entity;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class EventStatistic extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1038725805875182908L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EventStatistic\",\"namespace\":\"cloud.dataflow.city.entity\",\"fields\":[{\"name\":\"subjects\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"EventStatisticSubject\",\"fields\":[{\"name\":\"id\",\"type\":\"long\"},{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"activities\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"EventStatisticSubjectActivities\",\"fields\":[{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"past7daysCount\",\"type\":\"int\"},{\"name\":\"past7daysUniqueCount\",\"type\":\"int\"},{\"name\":\"past30daysCount\",\"type\":\"int\"},{\"name\":\"past30daysUniqueCount\",\"type\":\"int\"}]}}}]}}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<EventStatistic> ENCODER =
      new BinaryMessageEncoder<EventStatistic>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<EventStatistic> DECODER =
      new BinaryMessageDecoder<EventStatistic>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<EventStatistic> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<EventStatistic> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<EventStatistic>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this EventStatistic to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a EventStatistic from a ByteBuffer. */
  public static EventStatistic fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.util.List<cloud.dataflow.city.entity.EventStatisticSubject> subjects;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public EventStatistic() {}

  /**
   * All-args constructor.
   * @param subjects The new value for subjects
   */
  public EventStatistic(java.util.List<cloud.dataflow.city.entity.EventStatisticSubject> subjects) {
    this.subjects = subjects;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return subjects;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: subjects = (java.util.List<cloud.dataflow.city.entity.EventStatisticSubject>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'subjects' field.
   * @return The value of the 'subjects' field.
   */
  public java.util.List<cloud.dataflow.city.entity.EventStatisticSubject> getSubjects() {
    return subjects;
  }

  /**
   * Sets the value of the 'subjects' field.
   * @param value the value to set.
   */
  public void setSubjects(java.util.List<cloud.dataflow.city.entity.EventStatisticSubject> value) {
    this.subjects = value;
  }

  /**
   * Creates a new EventStatistic RecordBuilder.
   * @return A new EventStatistic RecordBuilder
   */
  public static cloud.dataflow.city.entity.EventStatistic.Builder newBuilder() {
    return new cloud.dataflow.city.entity.EventStatistic.Builder();
  }

  /**
   * Creates a new EventStatistic RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new EventStatistic RecordBuilder
   */
  public static cloud.dataflow.city.entity.EventStatistic.Builder newBuilder(cloud.dataflow.city.entity.EventStatistic.Builder other) {
    return new cloud.dataflow.city.entity.EventStatistic.Builder(other);
  }

  /**
   * Creates a new EventStatistic RecordBuilder by copying an existing EventStatistic instance.
   * @param other The existing instance to copy.
   * @return A new EventStatistic RecordBuilder
   */
  public static cloud.dataflow.city.entity.EventStatistic.Builder newBuilder(cloud.dataflow.city.entity.EventStatistic other) {
    return new cloud.dataflow.city.entity.EventStatistic.Builder(other);
  }

  /**
   * RecordBuilder for EventStatistic instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EventStatistic>
    implements org.apache.avro.data.RecordBuilder<EventStatistic> {

    private java.util.List<cloud.dataflow.city.entity.EventStatisticSubject> subjects;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(cloud.dataflow.city.entity.EventStatistic.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.subjects)) {
        this.subjects = data().deepCopy(fields()[0].schema(), other.subjects);
        fieldSetFlags()[0] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing EventStatistic instance
     * @param other The existing instance to copy.
     */
    private Builder(cloud.dataflow.city.entity.EventStatistic other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.subjects)) {
        this.subjects = data().deepCopy(fields()[0].schema(), other.subjects);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'subjects' field.
      * @return The value.
      */
    public java.util.List<cloud.dataflow.city.entity.EventStatisticSubject> getSubjects() {
      return subjects;
    }

    /**
      * Sets the value of the 'subjects' field.
      * @param value The value of 'subjects'.
      * @return This builder.
      */
    public cloud.dataflow.city.entity.EventStatistic.Builder setSubjects(java.util.List<cloud.dataflow.city.entity.EventStatisticSubject> value) {
      validate(fields()[0], value);
      this.subjects = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'subjects' field has been set.
      * @return True if the 'subjects' field has been set, false otherwise.
      */
    public boolean hasSubjects() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'subjects' field.
      * @return This builder.
      */
    public cloud.dataflow.city.entity.EventStatistic.Builder clearSubjects() {
      subjects = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public EventStatistic build() {
      try {
        EventStatistic record = new EventStatistic();
        record.subjects = fieldSetFlags()[0] ? this.subjects : (java.util.List<cloud.dataflow.city.entity.EventStatisticSubject>) defaultValue(fields()[0]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<EventStatistic>
    WRITER$ = (org.apache.avro.io.DatumWriter<EventStatistic>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<EventStatistic>
    READER$ = (org.apache.avro.io.DatumReader<EventStatistic>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}