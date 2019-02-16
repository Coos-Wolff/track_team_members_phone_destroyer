package com.wolffsoft.phonedestroyer.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.wolffsoft.phonedestroyer.model.InstantNowToString.instantToString;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TeamMemberTest {

    @Test
    public void testTeamMember() {
        Event event1 = Event.builder().name("Test Event 1").build();
        Event event2 = Event.builder().name("Test Event 2").build();
        Event event3 = Event.builder().name("Test Event 3").build();

        TeamMember teamMember = TeamMember.builder()
                .name("TestMember")
                .ticketsCollectedCurrentEvent(150)
                .build();

        assertThat(teamMember.getName()).isEqualTo("TestMember");
        assertThat(teamMember.getJoinedTeam()).isEqualTo(instantToString());
        assertThat(teamMember.getTicketsCollectedCurrentEvent()).isEqualTo(150);
    }
}
