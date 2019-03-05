package com.wolffsoft.phonedestroyer.model.event;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EventTicket {

    private String memberName;
    private int amountEventTickets;
}
