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

        String sampleEvents = """
                [
                  {
                    "name": "Java 17 (LTS): C'est aujourd'hui! - Henri Tremblay",
                    "time": 1631635200000
                  },
                  {
                    "name": "JHipster, LE générateur Yeoman à la mode.",
                    "time": 1413495000000
                  }
                ]

                """;

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
        events.stream().filter(event -> event.venueName() != null).forEach(event -> {
            var venueName = event.venueName();
            var result = switch (venueName) {
                case "Ulule", "Oracle Canada" -> "Pizza";
                case "Adaptive Inc", "Desjardins Digital", "Tour Intact" -> "Pizza and beer";
                default -> "No pizza nor beer:-(";
            };
            System.out.println(event.name() + "on the " + formatter.format(event.instant().atZone(ZoneId.of("America/Montreal"))) + " at " + venueName + " had this : " + result);

        });

    }

}
