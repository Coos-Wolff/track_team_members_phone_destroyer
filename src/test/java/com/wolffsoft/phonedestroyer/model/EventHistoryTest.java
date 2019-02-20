package com.wolffsoft.phonedestroyer.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EventHistoryTest {

    private static final String EVENT_NAME = "Test Event Name";
    private static final String MEMBER_NAME = "Test Member Name";
    private static final int TEAM_MEMBER_ID = 1;
    private static final int EVENT_ID = 1;
    private static final int EVENT_TICKETS_COLLECTED = 550;

    private EventHistory testEventHistory;

    @Before
    public void setup() {
        testEventHistory = EventHistory.builder()
                .eventName(EVENT_NAME)
                .memberName(MEMBER_NAME)
                .eventId(EVENT_ID)
                .memberId(TEAM_MEMBER_ID)
                .eventTicketsCollected(EVENT_TICKETS_COLLECTED)
                .build();
    }

    @Test
    public void testEventHistory() {
        EventHistory eventHistory = EventHistory.builder()
                .eventName(EVENT_NAME)
                .memberName(MEMBER_NAME)
                .eventId(EVENT_ID)
                .memberId(TEAM_MEMBER_ID)
                .eventTicketsCollected(EVENT_TICKETS_COLLECTED)
                .build();

        assertThat(eventHistory).isEqualTo(testEventHistory);
    }
}
