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

    private static final String TEAM_MEMBER_NAME = "Team Member Name";
    private static final  String DATE_JOINED = instantToString();
    private static final int TICKETS_COLLECTED = 12;
    private static final int ID = 1;

    private TeamMember testTeamMember;

    @Before
    public void setup() {
        testTeamMember = TeamMember.builder()
                .id(ID)
                .name(TEAM_MEMBER_NAME)
                .ticketsCollectedCurrentEvent(TICKETS_COLLECTED)
                .joinedTeam(DATE_JOINED)
                .build();
    }

    @Test
    public void testTeamMember() {
        TeamMember teamMember = TeamMember.builder()
                .id(ID)
                .name(TEAM_MEMBER_NAME)
                .joinedTeam(DATE_JOINED)
                .ticketsCollectedCurrentEvent(TICKETS_COLLECTED)
                .build();

        assertThat(teamMember).isEqualTo(testTeamMember);
    }
}
