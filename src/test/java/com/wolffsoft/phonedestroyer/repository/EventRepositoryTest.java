package com.wolffsoft.phonedestroyer.repository;

import com.wolffsoft.phonedestroyer.configuration.AbstractTestRepository;
import com.wolffsoft.phonedestroyer.model.CreateEvent;
import com.wolffsoft.phonedestroyer.model.Event;
import org.jooq.DSLContext;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class EventRepositoryTest extends AbstractTestRepository<EventRepository> {

    @Override
    protected EventRepository createRepository(DSLContext dslContext) {
        return new EventRepository(dslContext);
    }

    @Test
    public void testGetEventByName() {
        String name = "Test Event 1";

        Optional<Event> returnedEvent = repository.getEventByName(name);

        assertThat(returnedEvent.get().getName()).isEqualTo("Test Event 1");
    }

    @Test
    public void testCreateNewEvent() {
        CreateEvent createEvent = CreateEvent.create("New Created Event", "Points");

        repository.createNewEvent(createEvent);

        Optional<Event> createdEvent = repository.getEventByName(createEvent.getName());

        assertThat(createdEvent.get().getName()).isEqualTo(createEvent.getName());
    }

    @Test
    public void testEndEvent() {
        CreateEvent createEvent = CreateEvent.create("End Event", "Tickets");

        repository.createNewEvent(createEvent);

        Optional<Event> eventCreated = repository.getEventByName(createEvent.getName());

        assertThat(eventCreated.get().getName()).isEqualTo(createEvent.getName());
        assertThat(eventCreated.get().isEventHasEnded()).isEqualTo(false);

        repository.endEvent(eventCreated.get());

        Optional<Event> endedEvent = repository.getEventByName(eventCreated.get().getName());

        assertThat(endedEvent.get().isEventHasEnded()).isEqualTo(true);
    }
}
