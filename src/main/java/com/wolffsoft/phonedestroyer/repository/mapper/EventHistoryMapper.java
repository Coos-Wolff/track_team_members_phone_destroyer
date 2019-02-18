package com.wolffsoft.phonedestroyer.repository.mapper;

import com.wolffsoft.phonedestroyer.model.EventHistory;
import org.jooq.Record;
import org.jooq.RecordMapper;

import static com.wolffsoft.phonedestroyer.persistance.repositories.jooq.Tables.EVENT_HISTORY;

public class EventHistoryMapper implements RecordMapper<Record, EventHistory> {

    @Override
    public EventHistory map(Record record) {
        return EventHistory.builder()
                .id(record.get(EVENT_HISTORY.ID))
                .eventId(record.get(EVENT_HISTORY.EVENT_ID))
                .eventName(record.get(EVENT_HISTORY.EVENT_NAME))
                .memberId(record.get(EVENT_HISTORY.MEMBER_ID))
                .eventTicketsCollected(record.get(EVENT_HISTORY.EVENT_TICKETS_COLLECTED))
                .build();
    }
}
