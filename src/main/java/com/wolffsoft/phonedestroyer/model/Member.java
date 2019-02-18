package com.wolffsoft.phonedestroyer.model;

import lombok.Builder;
import lombok.Value;

import static com.wolffsoft.phonedestroyer.model.InstantNow.formatInstantToString;
import static com.wolffsoft.phonedestroyer.model.InstantNow.instantNow;

@Value
@Builder
public class Member {

    private int id;
    @Builder.Default
    private String joinedTeam = formatInstantToString(instantNow());
    private String name;
    private int ticketsCollectedCurrentEvent;
}
