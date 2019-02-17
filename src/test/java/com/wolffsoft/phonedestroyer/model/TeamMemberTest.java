package com.wolffsoft.phonedestroyer.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.wolffsoft.phonedestroyer.model.InstantNowToString.instantToString;
import static org.assertj.core.api.Assertions.assertThat;

public class TeamMemberTest {

    @Test
    public void testTeamMember() {
        TeamMember teamMember = TeamMember.builder()
                .name("TestMember")
                .ticketsCollectedCurrentEvent(150)
                .build();

        assertThat(teamMember.getName()).isEqualTo("TestMember");
        assertThat(teamMember.getJoinedTeam()).isEqualTo(instantToString());
        assertThat(teamMember.getTicketsCollectedCurrentEvent()).isEqualTo(150);
    }
}
