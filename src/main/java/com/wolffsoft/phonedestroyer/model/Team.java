package com.wolffsoft.phonedestroyer.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class Team {

    @Builder.Default
    private String name = "Gingers Rule!!!";
    private List<TeamMember> teamMembers;
}
