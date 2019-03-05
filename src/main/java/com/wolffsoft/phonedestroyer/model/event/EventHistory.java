package com.wolffsoft.phonedestroyer.model.event;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class EventHistory {

    private String eventName;
    private String memberName;
    private String role;
    private LocalDate eventDate;
    private LocalDate dateJoinedTeam;
    private int id;
    private int memberId;
    private int eventId;
    private int eventTicketsCollected;
    private int pointsCollected;
}
