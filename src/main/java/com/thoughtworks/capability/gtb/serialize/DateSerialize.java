package com.thoughtworks.capability.gtb.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.util.Date;

public class DateSerialize extends StdSerializer<Date> {
    protected DateSerialize() {
        super(Date.class);
    }

    @Override
    public void serialize(Date time, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeNumber(time.getTime());
    }
}
