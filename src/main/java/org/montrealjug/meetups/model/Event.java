package org.montrealjug.meetups.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Event{
    @JsonProperty("time") Instant instant;
    String name;
    Venue venue;

    public Event(Instant instant, String name, Venue venue) {
        this.instant = instant;
        this.name = name;
        this.venue = venue;
    }

    public Event() {
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(instant, event.instant) && Objects.equals(name, event.name) && Objects.equals(venue, event.venue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instant, name, venue);
    }

    @Override
    public String toString() {
        return "Event{" +
                "instant=" + instant +
                ", name='" + name + '\'' +
                ", venue=" + venue +
                '}';
    }
}
