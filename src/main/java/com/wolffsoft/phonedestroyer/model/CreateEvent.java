package com.wolffsoft.phonedestroyer.model;

import lombok.Builder;
import lombok.Value;

import static com.wolffsoft.phonedestroyer.model.InstantNow.formatInstantToString;
import static com.wolffsoft.phonedestroyer.model.InstantNow.instantNow;

@Value
@Builder
public class CreateEvent {

    private String name;
    @Builder.Default
    private String eventDate = formatInstantToString(instantNow());
}
