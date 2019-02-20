package com.wolffsoft.phonedestroyer.repository;

import com.wolffsoft.phonedestroyer.model.Event;
import com.wolffsoft.phonedestroyer.model.Member;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import static com.wolffsoft.phonedestroyer.persistance.repositories.jooq.Tables.EVENT_MEMBER;

@Repository
public class EventMemberRepository {

    private DSLContext dslContext;

    public EventMemberRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public void storeEventIdAndMemberId(Event event, Member member) {
        dslContext
                .insertInto(EVENT_MEMBER, EVENT_MEMBER.EVENT_ID, EVENT_MEMBER.MEMBER_ID)
                .values(event.getId(), member.getId())
                .execute();
    }
}
