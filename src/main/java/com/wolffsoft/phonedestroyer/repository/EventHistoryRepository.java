package com.wolffsoft.phonedestroyer.repository;

import com.wolffsoft.phonedestroyer.model.Event;
import com.wolffsoft.phonedestroyer.model.EventHistory;
import com.wolffsoft.phonedestroyer.model.Member;
import com.wolffsoft.phonedestroyer.repository.mapper.EventHistoryMapper;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.wolffsoft.phonedestroyer.persistance.repositories.jooq.Tables.EVENT_HISTORY;

@Repository
public class EventHistoryRepository {

    private DSLContext dslContext;
    private EventHistoryMapper eventHistoryMapper;

    public EventHistoryRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
        this.eventHistoryMapper = new EventHistoryMapper();
    }

    public void storeEventHistoryByTeamMember(Member member, Event event) {
        dslContext
                .insertInto(EVENT_HISTORY,
                        EVENT_HISTORY.EVENT_ID,
                        EVENT_HISTORY.MEMBER_ID,
                        EVENT_HISTORY.EVENT_NAME,
                        EVENT_HISTORY.MEMBER_NAME,
                        EVENT_HISTORY.EVENT_TICKETS_COLLECTED
                )
                .values(event.getId(),
                        member.getId(),
                        event.getName(),
                        member.getName(),
                        member.getTicketsCollectedCurrentEvent()
                )
                .execute();
    }

    public Optional<EventHistory> getEventHistoryByTeamMemberAndEvent(Member member, Event event) {
        return dslContext
                .select()
                .from(EVENT_HISTORY)
                .where(EVENT_HISTORY.MEMBER_ID.eq(member.getId()))
                .and(EVENT_HISTORY.EVENT_ID.eq(event.getId()))
                .fetchOptional(eventHistoryMapper);
    }

    public List<EventHistory> getAllEventHistories() {
        return dslContext
                .select()
                .from(EVENT_HISTORY)
                .groupBy(EVENT_HISTORY.ID)
                .fetch(eventHistoryMapper);
    }
}
