package org.montrealjug.meetups.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.Instant;
import java.util.Objects;

@JsonDeserialize(using = EventDeserializer.class)
public record Event(Instant instant, String name, String venueName){}
