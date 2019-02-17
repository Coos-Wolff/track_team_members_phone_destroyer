package com.wolffsoft.phonedestroyer.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EventHistory {

    private String eventName;
    private int id;
    private int teamMemberId;
    private int eventId;
    private int eventTicketsCollected;
}
