package com.wolffsoft.phonedestroyer.repository.mapper;

import com.wolffsoft.phonedestroyer.model.member.Member;
import org.jooq.Record;
import org.jooq.RecordMapper;

import java.time.LocalDate;

import static com.wolffsoft.phonedestroyer.persistance.repositories.jooq.Tables.MEMBER;

public class MemberMapper implements RecordMapper<Record, Member> {

    @Override
    public Member map(Record record) {
        return Member.builder()
                .id(record.get(MEMBER.ID))
                .name(record.get(MEMBER.NAME))
                .dateJoinedTeam(LocalDate.parse(record.get(MEMBER.DATE_JOINED)))
                .ticketsCollectedCurrentEvent(record.get(MEMBER.TICKETS_COLLECTED_CURRENT_EVENT))
                .pointsCollectedCurrentEvent(record.get(MEMBER.POINTS_COLLECTED_CURRENT_EVENT))
                .build();
    }
}
