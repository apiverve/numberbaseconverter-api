// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     NumberBaseConverterData data = Converter.fromJsonString(jsonString);

package com.apiverve.numberbaseconverter.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static NumberBaseConverterData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(NumberBaseConverterData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(NumberBaseConverterData.class);
        writer = mapper.writerFor(NumberBaseConverterData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// NumberBaseConverterData.java

package com.apiverve.numberbaseconverter.data;

import com.fasterxml.jackson.annotation.*;

public class NumberBaseConverterData {
    private String inputValue;
    private long inputBase;
    private String inputBaseName;
    private long decimalValue;
    private String outputValue;
    private long outputBase;
    private String outputBaseName;

    @JsonProperty("input_value")
    public String getInputValue() { return inputValue; }
    @JsonProperty("input_value")
    public void setInputValue(String value) { this.inputValue = value; }

    @JsonProperty("input_base")
    public long getInputBase() { return inputBase; }
    @JsonProperty("input_base")
    public void setInputBase(long value) { this.inputBase = value; }

    @JsonProperty("input_base_name")
    public String getInputBaseName() { return inputBaseName; }
    @JsonProperty("input_base_name")
    public void setInputBaseName(String value) { this.inputBaseName = value; }

    @JsonProperty("decimal_value")
    public long getDecimalValue() { return decimalValue; }
    @JsonProperty("decimal_value")
    public void setDecimalValue(long value) { this.decimalValue = value; }

    @JsonProperty("output_value")
    public String getOutputValue() { return outputValue; }
    @JsonProperty("output_value")
    public void setOutputValue(String value) { this.outputValue = value; }

    @JsonProperty("output_base")
    public long getOutputBase() { return outputBase; }
    @JsonProperty("output_base")
    public void setOutputBase(long value) { this.outputBase = value; }

    @JsonProperty("output_base_name")
    public String getOutputBaseName() { return outputBaseName; }
    @JsonProperty("output_base_name")
    public void setOutputBaseName(String value) { this.outputBaseName = value; }
}