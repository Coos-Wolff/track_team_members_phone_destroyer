package com.wolffsoft.phonedestroyer.model;

import lombok.Builder;
import lombok.Value;

import static com.wolffsoft.phonedestroyer.model.InstantNowToString.instantToString;

@Value
@Builder
public class Event {
    private String name;
    private String eventDate = instantToString();
}
