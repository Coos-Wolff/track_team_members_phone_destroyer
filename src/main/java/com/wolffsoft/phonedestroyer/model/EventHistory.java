package com.wolffsoft.phonedestroyer.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EventHistory {

    private String eventName;
    private String memberName;
    private int id;
    private int memberId;
    private int eventId;
    private int eventTicketsCollected;
    private int pointsCollected;
}
