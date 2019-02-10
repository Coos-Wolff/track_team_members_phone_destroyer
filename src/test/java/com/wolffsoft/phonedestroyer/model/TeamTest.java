package com.wolffsoft.phonedestroyer.model;

import com.wolffsoft.phonedestroyer.model.Team;
import com.wolffsoft.phonedestroyer.model.TeamMember;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TeamTest {

    private List<TeamMember> teamMembers;

    @Before
    public void setup() {
        TeamMember teamMember1 = TeamMember.builder()
                .name("TestMember1")
                .build();

        TeamMember teamMember2 = TeamMember.builder()
                .name("TestMember2")
                .build();

        teamMembers = Stream.of(teamMember1, teamMember2).collect(Collectors.toList());
    }

    @Test
    public void testTeam() {
        Team team = Team.builder()
                .teamMembers(teamMembers)
                .build();

        assertThat(team.getName()).isEqualTo("Gingers Rule!!!");
        assertThat(team.getTeamMembers()).isEqualTo(teamMembers);
    }
}
