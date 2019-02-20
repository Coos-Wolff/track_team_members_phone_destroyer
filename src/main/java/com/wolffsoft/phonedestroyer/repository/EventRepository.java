package com.wolffsoft.phonedestroyer.repository;

import com.wolffsoft.phonedestroyer.model.CreateEvent;
import com.wolffsoft.phonedestroyer.model.Event;
import com.wolffsoft.phonedestroyer.repository.mapper.OptionalEventMapper;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.wolffsoft.phonedestroyer.persistance.repositories.jooq.Tables.EVENT;

@Repository
public class EventRepository {

    private DSLContext dslContext;
    private OptionalEventMapper optionalEventMapper;

    public EventRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
        this.optionalEventMapper = new OptionalEventMapper();
    }

    public void createNewEvent(CreateEvent createEvent) {
        dslContext
                .insertInto(EVENT, EVENT.NAME, EVENT.EVENT_DATE)
                .values(createEvent.getName(), createEvent.getEventDate())
                .execute();
    }

    public Optional<Event> getEventById(int eventId) {
        return dslContext
                .select()
                .from(EVENT)
                .where(EVENT.ID.eq(eventId))
                .fetchOne(optionalEventMapper);
    }

    public Optional<Event> getEventByName(String name) {
        return dslContext
                .select()
                .from(EVENT)
                .where(EVENT.NAME.eq(name))
                .fetchOne(optionalEventMapper);
    }
}
