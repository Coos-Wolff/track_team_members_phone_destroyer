package com.wolffsoft.phonedestroyer.model.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

import static com.wolffsoft.phonedestroyer.model.InstantNow.localDateNow;

@Value
@Builder
@AllArgsConstructor
public class Member {

    @Builder.Default
    private int id = 0;

    @Builder.Default
    private LocalDate dateJoinedTeam = localDateNow();

    @Builder.Default
    private String role = "Member";

    private String name;

    @Builder.Default
    private int ticketsCollectedCurrentEvent = 0;

    @Builder.Default
    private int pointsCollectedCurrentEvent = 0;
}
