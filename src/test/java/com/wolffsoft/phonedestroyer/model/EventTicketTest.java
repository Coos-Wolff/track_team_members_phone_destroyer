package com.wolffsoft.phonedestroyer.model;

import com.wolffsoft.phonedestroyer.model.event.EventTicket;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EventTicketTest {

    private static final String TEAM_MEMBER_NAME = "Team Member Name 1";
    private static final int AMOUNT_EVENT_TICKETS = 230;

    private EventTicket testEventTicket;

    @Before
    public void setup() {
        testEventTicket = EventTicket.builder()
                .memberName(TEAM_MEMBER_NAME)
                .amountEventTickets(AMOUNT_EVENT_TICKETS)
                .build();
    }

    @Test
    public void testEventTicket() {
        EventTicket eventTicket = EventTicket.builder()
                .memberName(TEAM_MEMBER_NAME)
                .amountEventTickets(AMOUNT_EVENT_TICKETS)
                .build();

        assertThat(eventTicket).isEqualTo(testEventTicket);
    }
}
