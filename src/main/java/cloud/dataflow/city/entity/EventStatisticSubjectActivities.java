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
import org.apache.beam.sdk.coders.AvroCoder;
import org.apache.beam.sdk.coders.DefaultCoder;

@DefaultCoder(AvroCoder.class)
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class EventStatisticSubjectActivities extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 147509867747091487L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EventStatisticSubjectActivities\",\"namespace\":\"cloud.dataflow.city.entity\",\"fields\":[{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"past7daysCount\",\"type\":\"int\"},{\"name\":\"past7daysUniqueCount\",\"type\":\"int\"},{\"name\":\"past30daysCount\",\"type\":\"int\"},{\"name\":\"past30daysUniqueCount\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<EventStatisticSubjectActivities> ENCODER =
      new BinaryMessageEncoder<EventStatisticSubjectActivities>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<EventStatisticSubjectActivities> DECODER =
      new BinaryMessageDecoder<EventStatisticSubjectActivities>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<EventStatisticSubjectActivities> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<EventStatisticSubjectActivities> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<EventStatisticSubjectActivities>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this EventStatisticSubjectActivities to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a EventStatisticSubjectActivities from a ByteBuffer. */
  public static EventStatisticSubjectActivities fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence type;
  @Deprecated public int past7daysCount;
  @Deprecated public int past7daysUniqueCount;
  @Deprecated public int past30daysCount;
  @Deprecated public int past30daysUniqueCount;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public EventStatisticSubjectActivities() {}

  /**
   * All-args constructor.
   * @param type The new value for type
   * @param past7daysCount The new value for past7daysCount
   * @param past7daysUniqueCount The new value for past7daysUniqueCount
   * @param past30daysCount The new value for past30daysCount
   * @param past30daysUniqueCount The new value for past30daysUniqueCount
   */
  public EventStatisticSubjectActivities(java.lang.CharSequence type, java.lang.Integer past7daysCount, java.lang.Integer past7daysUniqueCount, java.lang.Integer past30daysCount, java.lang.Integer past30daysUniqueCount) {
    this.type = type;
    this.past7daysCount = past7daysCount;
    this.past7daysUniqueCount = past7daysUniqueCount;
    this.past30daysCount = past30daysCount;
    this.past30daysUniqueCount = past30daysUniqueCount;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return type;
    case 1: return past7daysCount;
    case 2: return past7daysUniqueCount;
    case 3: return past30daysCount;
    case 4: return past30daysUniqueCount;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: type = (java.lang.CharSequence)value$; break;
    case 1: past7daysCount = (java.lang.Integer)value$; break;
    case 2: past7daysUniqueCount = (java.lang.Integer)value$; break;
    case 3: past30daysCount = (java.lang.Integer)value$; break;
    case 4: past30daysUniqueCount = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'type' field.
   * @return The value of the 'type' field.
   */
  public java.lang.CharSequence getType() {
    return type;
  }

  /**
   * Sets the value of the 'type' field.
   * @param value the value to set.
   */
  public void setType(java.lang.CharSequence value) {
    this.type = value;
  }

  /**
   * Gets the value of the 'past7daysCount' field.
   * @return The value of the 'past7daysCount' field.
   */
  public java.lang.Integer getPast7daysCount() {
    return past7daysCount;
  }

  /**
   * Sets the value of the 'past7daysCount' field.
   * @param value the value to set.
   */
  public void setPast7daysCount(java.lang.Integer value) {
    this.past7daysCount = value;
  }

  /**
   * Gets the value of the 'past7daysUniqueCount' field.
   * @return The value of the 'past7daysUniqueCount' field.
   */
  public java.lang.Integer getPast7daysUniqueCount() {
    return past7daysUniqueCount;
  }

  /**
   * Sets the value of the 'past7daysUniqueCount' field.
   * @param value the value to set.
   */
  public void setPast7daysUniqueCount(java.lang.Integer value) {
    this.past7daysUniqueCount = value;
  }

  /**
   * Gets the value of the 'past30daysCount' field.
   * @return The value of the 'past30daysCount' field.
   */
  public java.lang.Integer getPast30daysCount() {
    return past30daysCount;
  }

  /**
   * Sets the value of the 'past30daysCount' field.
   * @param value the value to set.
   */
  public void setPast30daysCount(java.lang.Integer value) {
    this.past30daysCount = value;
  }

  /**
   * Gets the value of the 'past30daysUniqueCount' field.
   * @return The value of the 'past30daysUniqueCount' field.
   */
  public java.lang.Integer getPast30daysUniqueCount() {
    return past30daysUniqueCount;
  }

  /**
   * Sets the value of the 'past30daysUniqueCount' field.
   * @param value the value to set.
   */
  public void setPast30daysUniqueCount(java.lang.Integer value) {
    this.past30daysUniqueCount = value;
  }

  /**
   * Creates a new EventStatisticSubjectActivities RecordBuilder.
   * @return A new EventStatisticSubjectActivities RecordBuilder
   */
  public static cloud.dataflow.city.entity.EventStatisticSubjectActivities.Builder newBuilder() {
    return new cloud.dataflow.city.entity.EventStatisticSubjectActivities.Builder();
  }

  /**
   * Creates a new EventStatisticSubjectActivities RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new EventStatisticSubjectActivities RecordBuilder
   */
  public static cloud.dataflow.city.entity.EventStatisticSubjectActivities.Builder newBuilder(cloud.dataflow.city.entity.EventStatisticSubjectActivities.Builder other) {
    return new cloud.dataflow.city.entity.EventStatisticSubjectActivities.Builder(other);
  }

  /**
   * Creates a new EventStatisticSubjectActivities RecordBuilder by copying an existing EventStatisticSubjectActivities instance.
   * @param other The existing instance to copy.
   * @return A new EventStatisticSubjectActivities RecordBuilder
   */
  public static cloud.dataflow.city.entity.EventStatisticSubjectActivities.Builder newBuilder(cloud.dataflow.city.entity.EventStatisticSubjectActivities other) {
    return new cloud.dataflow.city.entity.EventStatisticSubjectActivities.Builder(other);
  }

  /**
   * RecordBuilder for EventStatisticSubjectActivities instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EventStatisticSubjectActivities>
    implements org.apache.avro.data.RecordBuilder<EventStatisticSubjectActivities> {

    private java.lang.CharSequence type;
    private int past7daysCount;
    private int past7daysUniqueCount;
    private int past30daysCount;
    private int past30daysUniqueCount;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(cloud.dataflow.city.entity.EventStatisticSubjectActivities.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.type)) {
        this.type = data().deepCopy(fields()[0].schema(), other.type);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.past7daysCount)) {
        this.past7daysCount = data().deepCopy(fields()[1].schema(), other.past7daysCount);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.past7daysUniqueCount)) {
        this.past7daysUniqueCount = data().deepCopy(fields()[2].schema(), other.past7daysUniqueCount);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.past30daysCount)) {
        this.past30daysCount = data().deepCopy(fields()[3].schema(), other.past30daysCount);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.past30daysUniqueCount)) {
        this.past30daysUniqueCount = data().deepCopy(fields()[4].schema(), other.past30daysUniqueCount);
        fieldSetFlags()[4] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing EventStatisticSubjectActivities instance
     * @param other The existing instance to copy.
     */
    private Builder(cloud.dataflow.city.entity.EventStatisticSubjectActivities other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.type)) {
        this.type = data().deepCopy(fields()[0].schema(), other.type);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.past7daysCount)) {
        this.past7daysCount = data().deepCopy(fields()[1].schema(), other.past7daysCount);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.past7daysUniqueCount)) {
        this.past7daysUniqueCount = data().deepCopy(fields()[2].schema(), other.past7daysUniqueCount);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.past30daysCount)) {
        this.past30daysCount = data().deepCopy(fields()[3].schema(), other.past30daysCount);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.past30daysUniqueCount)) {
        this.past30daysUniqueCount = data().deepCopy(fields()[4].schema(), other.past30daysUniqueCount);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'type' field.
      * @return The value.
      */
    public java.lang.CharSequence getType() {
      return type;
    }

    /**
      * Sets the value of the 'type' field.
      * @param value The value of 'type'.
      * @return This builder.
      */
    public cloud.dataflow.city.entity.EventStatisticSubjectActivities.Builder setType(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.type = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'type' field has been set.
      * @return True if the 'type' field has been set, false otherwise.
      */
    public boolean hasType() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'type' field.
      * @return This builder.
      */
    public cloud.dataflow.city.entity.EventStatisticSubjectActivities.Builder clearType() {
      type = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'past7daysCount' field.
      * @return The value.
      */
    public java.lang.Integer getPast7daysCount() {
      return past7daysCount;
    }

    /**
      * Sets the value of the 'past7daysCount' field.
      * @param value The value of 'past7daysCount'.
      * @return This builder.
      */
    public cloud.dataflow.city.entity.EventStatisticSubjectActivities.Builder setPast7daysCount(int value) {
      validate(fields()[1], value);
      this.past7daysCount = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'past7daysCount' field has been set.
      * @return True if the 'past7daysCount' field has been set, false otherwise.
      */
    public boolean hasPast7daysCount() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'past7daysCount' field.
      * @return This builder.
      */
    public cloud.dataflow.city.entity.EventStatisticSubjectActivities.Builder clearPast7daysCount() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'past7daysUniqueCount' field.
      * @return The value.
      */
    public java.lang.Integer getPast7daysUniqueCount() {
      return past7daysUniqueCount;
    }

    /**
      * Sets the value of the 'past7daysUniqueCount' field.
      * @param value The value of 'past7daysUniqueCount'.
      * @return This builder.
      */
    public cloud.dataflow.city.entity.EventStatisticSubjectActivities.Builder setPast7daysUniqueCount(int value) {
      validate(fields()[2], value);
      this.past7daysUniqueCount = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'past7daysUniqueCount' field has been set.
      * @return True if the 'past7daysUniqueCount' field has been set, false otherwise.
      */
    public boolean hasPast7daysUniqueCount() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'past7daysUniqueCount' field.
      * @return This builder.
      */
    public cloud.dataflow.city.entity.EventStatisticSubjectActivities.Builder clearPast7daysUniqueCount() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'past30daysCount' field.
      * @return The value.
      */
    public java.lang.Integer getPast30daysCount() {
      return past30daysCount;
    }

    /**
      * Sets the value of the 'past30daysCount' field.
      * @param value The value of 'past30daysCount'.
      * @return This builder.
      */
    public cloud.dataflow.city.entity.EventStatisticSubjectActivities.Builder setPast30daysCount(int value) {
      validate(fields()[3], value);
      this.past30daysCount = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'past30daysCount' field has been set.
      * @return True if the 'past30daysCount' field has been set, false otherwise.
      */
    public boolean hasPast30daysCount() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'past30daysCount' field.
      * @return This builder.
      */
    public cloud.dataflow.city.entity.EventStatisticSubjectActivities.Builder clearPast30daysCount() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'past30daysUniqueCount' field.
      * @return The value.
      */
    public java.lang.Integer getPast30daysUniqueCount() {
      return past30daysUniqueCount;
    }

    /**
      * Sets the value of the 'past30daysUniqueCount' field.
      * @param value The value of 'past30daysUniqueCount'.
      * @return This builder.
      */
    public cloud.dataflow.city.entity.EventStatisticSubjectActivities.Builder setPast30daysUniqueCount(int value) {
      validate(fields()[4], value);
      this.past30daysUniqueCount = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'past30daysUniqueCount' field has been set.
      * @return True if the 'past30daysUniqueCount' field has been set, false otherwise.
      */
    public boolean hasPast30daysUniqueCount() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'past30daysUniqueCount' field.
      * @return This builder.
      */
    public cloud.dataflow.city.entity.EventStatisticSubjectActivities.Builder clearPast30daysUniqueCount() {
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public EventStatisticSubjectActivities build() {
      try {
        EventStatisticSubjectActivities record = new EventStatisticSubjectActivities();
        record.type = fieldSetFlags()[0] ? this.type : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.past7daysCount = fieldSetFlags()[1] ? this.past7daysCount : (java.lang.Integer) defaultValue(fields()[1]);
        record.past7daysUniqueCount = fieldSetFlags()[2] ? this.past7daysUniqueCount : (java.lang.Integer) defaultValue(fields()[2]);
        record.past30daysCount = fieldSetFlags()[3] ? this.past30daysCount : (java.lang.Integer) defaultValue(fields()[3]);
        record.past30daysUniqueCount = fieldSetFlags()[4] ? this.past30daysUniqueCount : (java.lang.Integer) defaultValue(fields()[4]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<EventStatisticSubjectActivities>
    WRITER$ = (org.apache.avro.io.DatumWriter<EventStatisticSubjectActivities>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<EventStatisticSubjectActivities>
    READER$ = (org.apache.avro.io.DatumReader<EventStatisticSubjectActivities>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
