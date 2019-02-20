package com.wolffsoft.phonedestroyer.repository;

import com.wolffsoft.phonedestroyer.model.CreateEvent;
import com.wolffsoft.phonedestroyer.model.Event;
import com.wolffsoft.phonedestroyer.repository.mapper.EventMapper;
import com.wolffsoft.phonedestroyer.repository.mapper.OptionalEventMapper;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.wolffsoft.phonedestroyer.persistance.repositories.jooq.Tables.EVENT;

@Repository
public class EventRepository {

    private DSLContext dslContext;
    private OptionalEventMapper optionalEventMapper;
    private EventMapper eventMapper;

    public EventRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
        this.optionalEventMapper = new OptionalEventMapper();
        this.eventMapper = new EventMapper();
    }

    public void createNewEvent(CreateEvent createEvent) {
        dslContext
                .insertInto(EVENT, EVENT.NAME, EVENT.EVENT_DATE, EVENT.EVENT_TYPE)
                .values(createEvent.getName(), createEvent.getEventDate(), createEvent.getEventType())
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

    public void endEvent(Event event) {
        dslContext
                .update(EVENT)
                .set(EVENT.HAS_ENDED, true)
                .where(EVENT.NAME.eq(event.getName()))
                .execute();
    }

    public List<Event> getLastTwoEvents() {
        return dslContext
                .select()
                .from(EVENT)
                .orderBy(EVENT.ID.desc())
                .limit(2)
                .fetch(eventMapper);
    }
}
