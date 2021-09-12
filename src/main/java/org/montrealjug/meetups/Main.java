package org.montrealjug.meetups;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import javax.inject.Inject;

@QuarkusMain
public class Main {

    public static void main(String... args) {
        Quarkus.run(MyApp.class, args);
    }

    public static class MyApp implements QuarkusApplication {

        @Inject
        MeetupService meetupService;

        @Override
        public int run(String... args) {

            meetupService.retrieveAllPastJugsEvents().forEach(System.out::println);

            Quarkus.waitForExit();
            return 0;
        }
    }
}