package com.wolffsoft.phonedestroyer.repository.mapper;

import com.wolffsoft.phonedestroyer.model.Member;
import org.jooq.Record;
import org.jooq.RecordMapper;

import java.time.LocalDate;
import java.util.Optional;

import static com.wolffsoft.phonedestroyer.persistance.repositories.jooq.Tables.MEMBER;

public class OptionalMemberMapper implements RecordMapper<Record, Optional<Member>> {

    @Override
    public Optional<Member> map(Record record) {
        return Optional.ofNullable(Member.builder()
                .id(record.get(MEMBER.ID))
                .name(record.get(MEMBER.NAME))
                .dateJoinedTeam(LocalDate.parse(record.get(MEMBER.DATE_JOINED)))
                .ticketsCollectedCurrentEvent(record.get(MEMBER.TICKETS_COLLECTED_CURRENT_EVENT))
                .pointsCollectedCurrentEvent(record.get(MEMBER.POINTS_COLLECTED_CURRENT_EVENT))
                .build());
    }
}
