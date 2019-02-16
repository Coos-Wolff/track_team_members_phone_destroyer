package com.wolffsoft.phonedestroyer.repository.mapper;

import com.wolffsoft.phonedestroyer.model.TeamMember;
import org.jooq.Record;
import org.jooq.RecordMapper;

import static com.wolffsoft.phonedestroyer.persistance.repositories.jooq.Tables.TEAM_MEMBER;

public class TeamMemberMapper implements RecordMapper<Record, TeamMember> {

    @Override
    public TeamMember map(Record record) {
        return TeamMember.builder()
                .id(record.get(TEAM_MEMBER.ID))
                .name(record.get(TEAM_MEMBER.NAME))
                .joinedTeam(record.get(TEAM_MEMBER.DATE_JOINED))
                .ticketsCollectedCurrentEvent(record.get(TEAM_MEMBER.TICKETS_COLLECTED_CURRENT_EVENT))
                .build();
    }
}
