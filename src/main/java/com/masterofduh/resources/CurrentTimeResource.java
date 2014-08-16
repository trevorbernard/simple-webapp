package com.masterofduh.resources;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Path("/current-time")
@Produces(MediaType.APPLICATION_JSON)
public class CurrentTimeResource {
    @GET
    @JsonSerialize(using = CustomDateSerializer.class)
    public DateTime getCurrentTime() {
        return new DateTime();
    }

    private static class CustomDateSerializer extends JsonSerializer<DateTime> {
        private static DateTimeFormatter formatter = DateTimeFormat
                .forPattern("dd-MM-yyyy");

        @Override
        public void serialize(DateTime value, JsonGenerator gen,
                SerializerProvider arg2) throws IOException,
                JsonProcessingException {

            gen.writeString(formatter.print(value));
        }
    }
}
