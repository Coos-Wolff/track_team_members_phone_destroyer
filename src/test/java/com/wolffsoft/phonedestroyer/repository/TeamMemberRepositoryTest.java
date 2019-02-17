package com.wolffsoft.phonedestroyer.repository;

import com.wolffsoft.phonedestroyer.configuration.AbstractTestRepository;
import com.wolffsoft.phonedestroyer.model.EventTicket;
import com.wolffsoft.phonedestroyer.model.TeamMember;
import org.jooq.DSLContext;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TeamMemberRepositoryTest extends AbstractTestRepository<TeamMemberRepository> {

    private static final String TEAM_MEMBER_NAME_1 = "Team Member 1";
    private static final String TEAM_MEMBER_NAME_2 = "Team Member 2";
    private TeamMember teamMember3;
    private TeamMember teamMember4;

    @Override
    protected TeamMemberRepository createRepository(DSLContext dslContext) {
        return new TeamMemberRepository(dslContext);
    }

    @Before
    public void setup() {
        teamMember3 = TeamMember.builder()
                .id(13)
                .name("Team Member 13")
                .joinedTeam("01-01-2019")
                .build();

        teamMember4 = TeamMember.builder()
                .id(14)
                .name("Team Member 14")
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

        repository.deleteTeamMembersByName(teamMembers);
    }

    @Test
    public void testGetTeamMemberByName() {
        String name = "Team Member 1";

        Optional<TeamMember> returnedTeamMember = repository.getTeamMemberByName(name);

        assertThat(returnedTeamMember.get().getName()).isEqualTo(name);
    }

    @Test
    public void testGetAllTeamMembers() {
        List<TeamMember> teamMembers = repository.getAllTeamMembers();

        assertThat(teamMembers.size()).isEqualTo(13);
        assertThat(teamMembers.get(0).getId()).isEqualTo(1);
        assertThat(teamMembers.get(0).getName()).isEqualTo(TEAM_MEMBER_NAME_1);
        assertThat(teamMembers.get(0).getTicketsCollectedCurrentEvent()).isEqualTo(150);
        assertThat(teamMembers.get(0).getJoinedTeam()).isEqualTo("01-01-2019");
        assertThat(teamMembers.get(1).getId()).isEqualTo(2);
        assertThat(teamMembers.get(1).getName()).isEqualTo(TEAM_MEMBER_NAME_2);
        assertThat(teamMembers.get(1).getTicketsCollectedCurrentEvent()).isEqualTo(123);
        assertThat(teamMembers.get(1).getJoinedTeam()).isEqualTo("02-02-2019");
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

        assertThat(allTeamMembers.size()).isEqualTo(15);

        repository.deleteTeamMembersByName(teamMembers);

        allTeamMembers = repository.getAllTeamMembers();
        assertThat(allTeamMembers.size()).isEqualTo(13);
    }

    @Test
    public void testGetTeamMembersByEventName() {
        String eventName = "Test Event 2";
        List<TeamMember> teamMembers = repository.getTeamMembersByEventName(eventName);

        assertThat(teamMembers.get(0).getName()).isEqualTo(TEAM_MEMBER_NAME_1);
        assertThat(teamMembers.get(0).getTicketsCollectedCurrentEvent()).isEqualTo(150);
        assertThat(teamMembers.get(0).getJoinedTeam()).isEqualTo("01-01-2019");
        assertThat(teamMembers.get(1).getName()).isEqualTo(TEAM_MEMBER_NAME_2);
        assertThat(teamMembers.get(1).getTicketsCollectedCurrentEvent()).isEqualTo(123);
        assertThat(teamMembers.get(1).getJoinedTeam()).isEqualTo("02-02-2019");
    }
}
