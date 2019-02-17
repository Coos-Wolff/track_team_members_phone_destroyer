package com.wolffsoft.phonedestroyer.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EventTest {

    private static final String EVENT_NAME = "TestEvent";

    private Event testEvent;

    @Before
    public void setup() {
        testEvent = Event.builder()
                .name("TestEvent")
                .build();
    }

    @Test
    public void testEvent() {
        Event event = Event.builder()
                .name(EVENT_NAME)
                .build();

        assertThat(event).isEqualTo(testEvent);
    }
}
