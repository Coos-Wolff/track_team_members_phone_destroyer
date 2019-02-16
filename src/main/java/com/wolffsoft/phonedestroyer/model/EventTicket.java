package com.wolffsoft.phonedestroyer.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EventTicket {

    private String teamMemberName;
    private int amountEventTickets;
}
