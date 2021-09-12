package org.montrealjug.meetups.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.Instant;
import java.util.Objects;

@JsonDeserialize(using = EventDeserializer.class)
public class Event{
    Instant instant;
    String name;
    String venueName;

    public Event() {
    }

    public Event(Instant instant, String name, String venueName) {
        this.instant = instant;
        this.name = name;
        this.venueName = venueName;
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

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(instant, event.instant) && Objects.equals(name, event.name) && Objects.equals(venueName, event.venueName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instant, name, venueName);
    }

    @Override
    public String toString() {
        return "Event{" +
                "instant=" + instant +
                ", name='" + name + '\'' +
                ", venueName='" + venueName + '\'' +
                '}';
    }
}
