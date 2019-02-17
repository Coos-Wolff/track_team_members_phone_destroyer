package com.wolffsoft.phonedestroyer.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateEventTest {

    private static final String EVENT_NAME = "New Created Event Name";
    private CreateEvent testCreateEvent;

    @Before
    public void setup() {
        testCreateEvent = CreateEvent.builder()
                .name(EVENT_NAME)
                .build();
    }

    @Test
    public void testCreateEvent() {
        CreateEvent createEvent = CreateEvent.builder()
                .name(EVENT_NAME)
                .build();

        assertThat(createEvent).isEqualTo(testCreateEvent);
    }
}
