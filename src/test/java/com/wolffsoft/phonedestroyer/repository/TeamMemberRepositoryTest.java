package com.wolffsoft.phonedestroyer.repository;

import com.wolffsoft.phonedestroyer.model.TeamMember;
import com.wolffsoft.phonedestroyer.model.configuration.AbstractTestRepository;
import org.jooq.DSLContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TeamMemberRepositoryTest extends AbstractTestRepository<TeamMemberRepository> {

    private TeamMember teamMember3;
    private TeamMember teamMember4;

    @Override
    protected TeamMemberRepository createRepository(DSLContext dslContext) {
        return new TeamMemberRepository(dslContext);
    }

    @Before
    public void setup() {
        teamMember3 = TeamMember.builder()
                .id(3)
                .name("Team Member 3")
                .joinedTeam("01-01-2019")
                .build();

        teamMember4 = TeamMember.builder()
                .id(4)
                .name("Team Member 4")
                .joinedTeam("01-01-2019")
                .build();
    }

    @Test
    public void testAddMember() {
        int addedTeamMember = repository.addTeamMember(teamMember3);

        assertThat(addedTeamMember).isEqualTo(1);
    }

    @Test
    public void testAddMembers() {
        List<TeamMember> teamMembers = Stream.of(teamMember3, teamMember4).collect(Collectors.toList());

        repository.addTeamMembers(teamMembers);

        Optional<TeamMember> addedTeamMember1 = repository.getTeamMemberByName(teamMember3.getName());
        Optional<TeamMember> addedTeamMember2 = repository.getTeamMemberByName(teamMember4.getName());

        assertThat(addedTeamMember1.get().getName()).isEqualTo(teamMember3.getName());
        assertThat(addedTeamMember2.get().getName()).isEqualTo(teamMember4.getName());
    }

    @Test
    public void testGetTeamMemberByName() {
        String name = "Team Member 1";

        Optional<TeamMember> returnedTeamMember = repository.getTeamMemberByName(name);

        assertThat(returnedTeamMember).isEqualTo(Optional.of(teamMember3));
    }

    @Test
    public void testDeleteTeamMember() {
        int addedTeamMember = repository.addTeamMember(teamMember3);

        assertThat(addedTeamMember).isEqualTo(1);

        String name = teamMember3.getName();
        repository.deleteTeamMemberByName(name);

        Optional<TeamMember> deletedTeamMember = repository.getTeamMemberByName(name);
        assertThat(deletedTeamMember).isNull();
    }

    @Test
    public void testDeleteTeamMembers() {
        List<TeamMember> teamMembers = Stream.of(teamMember3, teamMember4).collect(Collectors.toList());

        repository.addTeamMembers(teamMembers);
        List<TeamMember> allTeamMembers = repository.getAllTeamMembers();

        assertThat(allTeamMembers.size()).isEqualTo(4);

        repository.deleteTeamMembersByName(teamMembers);

        allTeamMembers = repository.getAllTeamMembers();
        assertThat(allTeamMembers.size()).isEqualTo(2);
    }
}
