package com.wolffsoft.phonedestroyer.repository.mapper;

import com.wolffsoft.phonedestroyer.model.Event;
import org.jooq.Record;
import org.jooq.RecordMapper;

import java.util.Optional;

import static com.wolffsoft.phonedestroyer.persistance.repositories.jooq.Tables.EVENT;

public class OptionalEventMapper implements RecordMapper<Record, Optional<Event>> {

    @Override
    public Optional<Event> map(Record record) {
        return Optional.of(Event.builder()
                .name(record.get(EVENT.NAME))
                .build());
    }
}
