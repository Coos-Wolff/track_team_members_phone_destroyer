package com.wolffsoft.phonedestroyer.repository.mapper;

import com.wolffsoft.phonedestroyer.model.Event;
import org.jooq.Record;
import org.jooq.RecordMapper;

import java.time.LocalDate;

import static com.wolffsoft.phonedestroyer.persistance.repositories.jooq.Tables.EVENT;

public class EventMapper implements RecordMapper<Record, Event> {

    @Override
    public Event map(Record record) {
        return Event.builder()
                .id(record.get(EVENT.ID))
                .name(record.get(EVENT.NAME))
                .eventType(record.get(EVENT.EVENT_TYPE))
                .eventDate(LocalDate.parse(record.get(EVENT.EVENT_DATE)))
                .eventHasEnded(record.get(EVENT.HAS_ENDED))
                .build();
    }
}
