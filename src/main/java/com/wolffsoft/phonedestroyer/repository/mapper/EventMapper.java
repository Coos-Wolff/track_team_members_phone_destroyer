package com.wolffsoft.phonedestroyer.repository.mapper;

import com.wolffsoft.phonedestroyer.model.Event;
import org.jooq.Record;
import org.jooq.RecordMapper;

import static com.wolffsoft.phonedestroyer.persistance.repositories.jooq.Tables.EVENT;

public class EventMapper implements RecordMapper<Record, Event> {

    @Override
    public Event map(Record record) {
        return Event.builder()
                .name(record.get(EVENT.NAME))
                .build();
    }
}
