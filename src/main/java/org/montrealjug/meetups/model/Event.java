package org.montrealjug.meetups.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Event(@JsonProperty("time") Instant instant, String name, Venue venue){}
