package com.wolffsoft.phonedestroyer.model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;

import static com.wolffsoft.phonedestroyer.model.InstantNow.localDateNow;

@Value
@Builder
public class Event {

    private int id;
    private String name;
    private String eventType;
    @Builder.Default
    private LocalDate eventDate = localDateNow();
    private List<Member> members;
    @Builder.Default
    private boolean eventHasEnded = false;
}
