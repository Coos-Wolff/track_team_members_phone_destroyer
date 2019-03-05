package com.wolffsoft.phonedestroyer.model;

import com.wolffsoft.phonedestroyer.model.event.EventHistory;
import org.junit.Before;
import org.junit.Test;

import static com.wolffsoft.phonedestroyer.model.InstantNow.localDateNow;
import static org.assertj.core.api.Assertions.assertThat;

public class EventHistoryTest {

    private static final String EVENT_NAME = "Test Event Name";
    private static final String MEMBER_NAME = "Test Member Name";
    public final static String ROLE_MEMBER = "Member";
    private static final int TEAM_MEMBER_ID = 1;
    private static final int EVENT_ID = 1;
    private static final int EVENT_TICKETS_COLLECTED = 550;
    private static final int POINTS_COLLECTED = 19;

    private EventHistory testEventHistory;

    @Before
    public void setup() {
        testEventHistory = EventHistory.builder()
                .id(1)
                .eventId(EVENT_ID)
                .eventName(EVENT_NAME)
                .eventDate(localDateNow())
                .memberId(TEAM_MEMBER_ID)
                .memberName(MEMBER_NAME)
                .role(ROLE_MEMBER)
                .eventTicketsCollected(EVENT_TICKETS_COLLECTED)
                .pointsCollected(POINTS_COLLECTED)
                .build();
    }

    @Test
    public void testEventHistory() {
        EventHistory eventHistory = EventHistory.builder()
                .id(1)
                .eventId(EVENT_ID)
                .eventName(EVENT_NAME)
                .eventDate(localDateNow())
                .memberId(TEAM_MEMBER_ID)
                .memberName(MEMBER_NAME)
                .role(ROLE_MEMBER)
                .eventTicketsCollected(EVENT_TICKETS_COLLECTED)
                .pointsCollected(POINTS_COLLECTED)
                .build();

        assertThat(eventHistory).isEqualTo(testEventHistory);
    }
}
