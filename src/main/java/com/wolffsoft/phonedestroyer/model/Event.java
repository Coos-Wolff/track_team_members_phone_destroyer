package com.wolffsoft.phonedestroyer.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

import static com.wolffsoft.phonedestroyer.model.InstantNow.formatInstantToString;

@Value
@Builder
public class Event {

    private int id;
    private String name;
    private String eventType;
    @Builder.Default
    private String eventDate = formatInstantToString();
    private List<Member> members;
    @Builder.Default
    private boolean eventHasEnded = false;
}
