package com.wolffsoft.phonedestroyer.model;

import lombok.Builder;
import lombok.Value;

import static com.wolffsoft.phonedestroyer.model.InstantNowToString.instantToString;

@Value
@Builder
public class TeamMember {

    private int id;
    @Builder.Default
    private String joinedTeam = instantToString();
    private String name;
    private int ticketsCollectedCurrentEvent;
}
