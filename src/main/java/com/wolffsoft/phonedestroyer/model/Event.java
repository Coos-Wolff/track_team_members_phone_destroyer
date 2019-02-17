package com.wolffsoft.phonedestroyer.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

import static com.wolffsoft.phonedestroyer.model.InstantNowToString.instantToString;

@Value
@Builder
public class Event {
    private String name;
    @Builder.Default
    private String eventDate = instantToString();
    private List<TeamMember> teamMembers;
}
