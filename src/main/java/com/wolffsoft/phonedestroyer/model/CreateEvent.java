package com.wolffsoft.phonedestroyer.model;

import lombok.Builder;
import lombok.Value;

import static com.wolffsoft.phonedestroyer.model.InstantNow.formatInstantToString;

@Value
@Builder
public class CreateEvent {

    public static CreateEvent create(String name, String eventType) {
        return CreateEvent.builder()
                .name(name)
                .eventType(eventType)
                .build();
    }

    private String name;
    private String eventType;
    @Builder.Default
    private String eventDate = formatInstantToString();
}
