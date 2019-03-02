package com.wolffsoft.phonedestroyer.model;

import org.junit.Before;
import org.junit.Test;

import java.time.Instant;

import static com.wolffsoft.phonedestroyer.model.InstantNow.formatInstantToString;
import static com.wolffsoft.phonedestroyer.model.InstantNow.instantNow;
import static org.assertj.core.api.Assertions.assertThat;

public class MemberTest {

    private static final Instant INSTANT_NOW = instantNow();
    private static final String TEAM_MEMBER_NAME = "Team Member Name";
    private static final  String DATE_JOINED = formatInstantToString(INSTANT_NOW);
    private static final int TICKETS_COLLECTED = 12;
    private static final int POINTS_COLLECTED = 19;
    private static final int ID = 1;

    private Member testMember;

    @Before
    public void setup() {
        testMember = Member.builder()
                .id(ID)
                .name(TEAM_MEMBER_NAME)
                .ticketsCollectedCurrentEvent(TICKETS_COLLECTED)
                .pointsCollectedCurrentEvent(POINTS_COLLECTED)
                .joinedTeam(DATE_JOINED)
                .build();
    }

    @Test
    public void testTeamMember() {
        Member member = Member.builder()
                .id(ID)
                .name(TEAM_MEMBER_NAME)
                .joinedTeam(DATE_JOINED)
                .ticketsCollectedCurrentEvent(TICKETS_COLLECTED)
                .pointsCollectedCurrentEvent(POINTS_COLLECTED)
                .build();

        assertThat(member).isEqualTo(testMember);
    }
}
