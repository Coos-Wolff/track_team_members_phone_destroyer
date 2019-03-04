package com.wolffsoft.phonedestroyer.model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

import static com.wolffsoft.phonedestroyer.model.InstantNow.localDateNow;

@Value
@Builder
public class Member {

    private int id;

    @Builder.Default
    private LocalDate dateJoinedTeam = localDateNow();

    @Builder.Default
    private String role = "Member";

    private String name;
    private int ticketsCollectedCurrentEvent;
    private int pointsCollectedCurrentEvent;
}
