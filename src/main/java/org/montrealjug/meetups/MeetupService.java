package org.montrealjug.meetups;

import org.montrealjug.meetups.model.Event;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class MeetupService {


    private final Client client;
    private final String MEETUP_API_BASE_URL = "https://api.meetup.com";

    public MeetupService() {
        client = ClientBuilder.newClient();
    }

    public List<Event> retrieveAllPastJugsEvents() {
        WebTarget target = client.target(MEETUP_API_BASE_URL + "/montreal-jug/events?status=past");
        Response response = target
                .request(MediaType.APPLICATION_JSON)
                .get();
        return response.readEntity(new GenericType<>() {
        });
    }
}
