package com.wolffsoft.phonedestroyer.repository;

import com.wolffsoft.phonedestroyer.model.TeamMember;
import com.wolffsoft.phonedestroyer.repository.mapper.OptionalTeamMemberMapper;
import com.wolffsoft.phonedestroyer.repository.mapper.TeamMemberMapper;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.wolffsoft.phonedestroyer.persistance.repositories.jooq.Tables.TEAM_MEMBER;

@Repository
public class TeamMemberRepository {

    private DSLContext dslContext;
    private OptionalTeamMemberMapper optionalTeamMemberMapper;
    private TeamMemberMapper teamMemberMapper;

    public TeamMemberRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
        this.optionalTeamMemberMapper = new OptionalTeamMemberMapper();
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
                .fetchOne(optionalTeamMemberMapper);
    }

    public List<TeamMember> getAllTeamMembers() {
        return dslContext
                .select()
                .from(TEAM_MEMBER)
                .fetch(teamMemberMapper);
    }

    public void deleteTeamMemberByName(String name) {
        dslContext
                .deleteFrom(TEAM_MEMBER)
                .where(TEAM_MEMBER.NAME.eq(name))
                .execute();
    }

    public void deleteTeamMembersByName(List<TeamMember> teamMembers) {
        teamMembers.forEach(teamMember -> deleteTeamMemberByName(teamMember.getName()));
    }

    private List<TeamMember> getTeamMembersByEventName(String eventName) {
        return dslContext
                .select()
                .from(TEAM_MEMBER)
                .join(EVENT_TEAM_MEMBER)
                .on(TEAM_MEMBER.ID.eq(EVENT_TEAM_MEMBER.TEAM_MEMBER_ID))
                .join(EVENT)
                .on(EVENT.ID.eq(EVENT_TEAM_MEMBER.EVENT_ID))
                .where(EVENT.NAME.eq(eventName))
                .orderBy(TEAM_MEMBER.ID)
                .fetch(teamMemberMapper);
    }
}
