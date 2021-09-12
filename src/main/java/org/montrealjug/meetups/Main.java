package org.montrealjug.meetups;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.ZoneId;

@QuarkusMain
public class Main {

    public static void main(String... args) {
        Quarkus.run(MyApp.class, args);
    }

    public static class MyApp implements QuarkusApplication {
        public static final ZoneId MONTREAL_ZONE_ID = ZoneId.of("America/Montreal");

        @Inject
        MeetupService meetupService;

        @Override
        public int run(String... args) {

            meetupService.retrieveAllPastJugsEvents().forEach(event -> {
                System.out.println(LocalDate.ofInstant(event.instant(), MONTREAL_ZONE_ID));
                System.out.println((event.name() + ", at " + event.venueName()).indent(4));
            });

            Quarkus.waitForExit();
            return 0;
        }
    }
}