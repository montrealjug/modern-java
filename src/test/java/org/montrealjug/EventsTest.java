package org.montrealjug;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.montrealjug.meetups.model.Event;

import java.io.IOException;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventsTest {

    private final ObjectMapper objectMapper;

    public EventsTest() {
        objectMapper = new ObjectMapper().findAndRegisterModules().configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false);
    }

    @Test
    public void testEvents() throws IOException {

        String sampleEvents = "" +
                "                [\n" +
                "                  {\n" +
                "                    \"name\": \"Java 17 (LTS): C'est aujourd'hui! - Henri Tremblay\",\n" +
                "                    \"time\": 1631635200000\n" +
                "                  },\n" +
                "                  {\n" +
                "                    \"name\": \"JHipster, LE générateur Yeoman à la mode.\",\n" +
                "                    \"time\": 1413495000000\n" +
                "                  }\n" +
                "                ]";

//        var resourceAsStream = this.getClass().getResourceAsStream("/events.json");
//        String text = new String(resourceAsStream.readAllBytes(), StandardCharsets.UTF_8);
//        System.out.println(text);
        ObjectMapper objectMapper = new ObjectMapper();
        assertEquals("Java 17 (LTS): C'est aujourd'hui! - Henri Tremblay", objectMapper.readTree(sampleEvents).get(0).get("name").asText());


    }

    @Test
    public void testEventsJson() throws IOException {


        var resourceAsStream = this.getClass().getResourceAsStream("/allevents.json");
        List<Event> events = objectMapper.readValue(resourceAsStream, new TypeReference<>() {
        });
        DateTimeFormatter formatter =
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                        .withLocale(Locale.CANADA_FRENCH)
                        .withZone(ZoneId.systemDefault());
        events.stream().filter(event -> event.getVenue() != null).forEach(event -> {
            var venueName = event.getVenue().getName();
            String result = null;
            switch (venueName) {
                case "Ulule" : {
                     result = "Pizza";
                }
                case "Oracle Canada" : {
                    result = "Pizza";
                }
                case "Adaptive Inc" : {
                    result = "Pizza and beer";
                }
                case "Desjardins Digital" : {
                    result = "Pizza and beer";
                }
                case "Tour Intact" : {
                    result = "Pizza and beer";
                }
                default : result = "No pizza nor beer:-(";
            };
            System.out.println(event.getName() + "on the " + formatter.format(event.getInstant().atZone(ZoneId.of("America/Montreal"))) + " at " + event.getVenue().getName() + " had this : " + result);

        });


    }

}
