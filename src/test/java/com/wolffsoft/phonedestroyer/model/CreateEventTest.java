package com.wolffsoft.phonedestroyer.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateEventTest {

    private static final String EVENT_NAME = "New Created Event Name";
    private static final String EVENT_TYPE_TICKETS = "Tickets";
    private static final String EVENT_TYPE_POINTS = "Points";
    private CreateEvent testCreateTicketEvent;
    private CreateEvent testCreatePointsEvent;

    @Before
    public void setup() {
        testCreateTicketEvent = CreateEvent.builder()
                .name(EVENT_NAME)
                .eventType(EVENT_TYPE_TICKETS)
                .build();

        testCreatePointsEvent = CreateEvent.create(EVENT_NAME, EVENT_TYPE_POINTS);
    }

    @Test
    public void testCreateEvent() {
        CreateEvent createEvent = CreateEvent.builder()
                .name(EVENT_NAME)
                .eventType(EVENT_TYPE_TICKETS)
                .build();

        assertThat(createEvent).isEqualTo(testCreateTicketEvent);
    }

    @Test
    public void testCreateMethod() {
        CreateEvent createEvent = CreateEvent.create(EVENT_NAME, EVENT_TYPE_POINTS);

        assertThat(createEvent).isEqualTo(testCreatePointsEvent);
    }
}
