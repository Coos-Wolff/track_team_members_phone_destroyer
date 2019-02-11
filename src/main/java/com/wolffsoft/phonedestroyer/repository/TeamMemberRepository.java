package com.wolffsoft.phonedestroyer.repository;

import com.wolffsoft.phonedestroyer.model.TeamMember;
import com.wolffsoft.phonedestroyer.repository.mapper.TeamMemberMapper;
import org.jooq.DSLContext;

import java.util.List;
import java.util.Optional;

import static com.wolffsoft.phonedestroyer.persistance.repositories.jooq.Tables.TEAM_MEMBER;

public class TeamMemberRepository {

    private DSLContext dslContext;
    private TeamMemberMapper teamMemberMapper;

    public TeamMemberRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
        this.teamMemberMapper = new TeamMemberMapper();
    }

    public int addTeamMember(TeamMember teamMember) {
        return dslContext
                .insertInto(TEAM_MEMBER, TEAM_MEMBER.NAME, TEAM_MEMBER.DATE_JOINED)
                .values(teamMember.getName(), teamMember.getJoinedTeam())
                .execute();
    }

    public void addTeamMembers(List<TeamMember> teamMembers) {
        teamMembers.forEach(this::addTeamMember);
    }

    public Optional<TeamMember> getTeamMemberByName(String name) {
        return dslContext
                .select()
                .from(TEAM_MEMBER)
                .where(TEAM_MEMBER.NAME.eq(name))
                .fetchOne(teamMemberMapper);
    }

    public List<TeamMember> getAllTeamMembers() {
        return dslContext
                .insertInto(TEAM_MEMBER, TEAM_MEMBER.NAME, TEAM_MEMBER.DATE_JOINED)
                .values(teamMember.getName(), teamMember.getJoinedTeam())
                .execute();
    }

    public void deleteTeamMembersByName(List<TeamMember> teamMembers) {
        teamMembers.forEach(teamMember -> deleteTeamMemberByName(teamMember.getName()));
    }
}
