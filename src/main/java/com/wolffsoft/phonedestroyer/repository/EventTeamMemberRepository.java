package com.wolffsoft.phonedestroyer.repository;

import com.wolffsoft.phonedestroyer.model.Event;
import com.wolffsoft.phonedestroyer.model.TeamMember;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import static com.wolffsoft.phonedestroyer.persistance.repositories.jooq.Tables.EVENT_TEAM_MEMBER;

@Repository
public class EventTeamMemberRepository {

    private DSLContext dslContext;

    public EventTeamMemberRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public void storeEventIdAndTeamMemberId(Event event, TeamMember teamMember) {
        dslContext
                .insertInto(EVENT_TEAM_MEMBER, EVENT_TEAM_MEMBER.EVENT_ID, EVENT_TEAM_MEMBER.TEAM_MEMBER_ID)
                .values(event.getId(), teamMember.getId())
                .execute();
    }
}
