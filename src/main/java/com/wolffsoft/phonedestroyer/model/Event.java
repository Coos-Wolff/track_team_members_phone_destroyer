package com.wolffsoft.phonedestroyer.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

import static com.wolffsoft.phonedestroyer.model.InstantNow.formatInstantToString;
import static com.wolffsoft.phonedestroyer.model.InstantNow.instantNow;

@Value
@Builder
public class Event {

    private int id;
    private String name;
    @Builder.Default
    private String eventDate = formatInstantToString(instantNow());
    private List<Member> members;
}
