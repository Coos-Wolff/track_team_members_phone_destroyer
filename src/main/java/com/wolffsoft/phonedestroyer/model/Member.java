package com.wolffsoft.phonedestroyer.model;

import lombok.Builder;
import lombok.Value;

import static com.wolffsoft.phonedestroyer.model.InstantNow.formatInstantToString;

@Value
@Builder
public class Member {

    private int id;

    @Builder.Default
    private String joinedTeam = formatInstantToString();

    @Builder.Default
    private String role = "Member";

    private String name;
    private int ticketsCollectedCurrentEvent;
    private int pointsCollectedCurrentEvent;
}
