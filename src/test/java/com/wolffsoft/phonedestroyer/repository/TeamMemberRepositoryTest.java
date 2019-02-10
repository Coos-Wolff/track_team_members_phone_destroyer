package com.wolffsoft.phonedestroyer.repository;

import com.wolffsoft.phonedestroyer.model.TeamMember;
import com.wolffsoft.phonedestroyer.model.configuration.AbstractTestRepository;
import org.jooq.DSLContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TeamMemberRepositoryTest extends AbstractTestRepository<TeamMemberRepository> {

    TeamMember teamMember1;

    @Override
    protected TeamMemberRepository createRepository(DSLContext dslContext) {
        return new TeamMemberRepository(dslContext);
    }

    @Before
    public void setup() {
        teamMember1 = TeamMember.builder()
                .id(1)
                .name("Team Member 1")
                .joinedTeam("01-01-2019")
                .build();
    }

    @Test
    public void testAddMember() {
        int addedTeamMember = repository.addTeamMember(teamMember1);

        assertThat(addedTeamMember).isEqualTo(1);
    }

    @Test
    public void testGetTeamMemberByName() {
        String name = "Team Member 1";

        Optional<TeamMember> returnedTeamMember = repository.getTeamMemberByName(name);

        assertThat(returnedTeamMember).isEqualTo(Optional.of(teamMember1));
    }
}
