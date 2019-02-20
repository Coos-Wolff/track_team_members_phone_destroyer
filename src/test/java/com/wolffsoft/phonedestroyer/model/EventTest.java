package com.wolffsoft.phonedestroyer.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.wolffsoft.phonedestroyer.helperclass.model.MemberTestObject.getTestTeamMembers;
import static org.assertj.core.api.Assertions.assertThat;

public class EventTest {

    private static final String EVENT_NAME = "TestEvent";
    private static final List<Member> testMembers = getTestTeamMembers();
    private Event testCurrentEvent;
    private Event testEndedEvent;

    @Before
    public void setup() {
        testCurrentEvent = Event.builder()
                .id(1)
                .name(EVENT_NAME)
                .members(testMembers)
                .eventHasEnded(false)
                .eventType("Tickets")
                .build();

        testEndedEvent = Event.builder()
                .id(1)
                .members(testMembers)
                .name(EVENT_NAME)
                .eventHasEnded(true)
                .eventType("Points")
                .build();
    }

    @Test
    public void testCurrentEvent() {
        Event event = Event.builder()
                .id(1)
                .name(EVENT_NAME)
                .members(testMembers)
                .eventHasEnded(false)
                .eventType("Tickets")
                .build();

        assertThat(event).isEqualTo(testCurrentEvent);
    }

    @Test
    public void testEndedEvent() {
        Event event = Event.builder()
                .id(1)
                .name(EVENT_NAME)
                .members(testMembers)
                .eventType("Points")
                .eventHasEnded(true)
                .build();

        assertThat(event).isEqualTo(testEndedEvent);
    }
}
