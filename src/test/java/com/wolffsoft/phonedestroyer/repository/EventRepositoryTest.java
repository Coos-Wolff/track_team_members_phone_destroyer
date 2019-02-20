package com.wolffsoft.phonedestroyer.repository;

import com.wolffsoft.phonedestroyer.configuration.AbstractTestRepository;
import com.wolffsoft.phonedestroyer.model.CreateEvent;
import com.wolffsoft.phonedestroyer.model.Event;
import org.jooq.DSLContext;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class EventRepositoryTest extends AbstractTestRepository<EventRepository> {

    @Override
    protected EventRepository createRepository(DSLContext dslContext) {
        return new EventRepository(dslContext);
    }

    @Test
    public void testGetEventById() {
        int eventId = 1;

        Optional<Event> returnedEvent = repository.getEventById(eventId);

        assertThat(returnedEvent.get().getName()).isEqualTo("Test Event 1");
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

    @Test
    public void testGetLastTwoEvents() {
        List<Event> lastTwoEvents = repository.getLastTwoEvents();

        assertThat(lastTwoEvents.size()).isEqualTo(2);
        assertThat(lastTwoEvents.get(0).getName()).isEqualTo("Test Event 123456789");
        assertThat(lastTwoEvents.get(1).getName()).isEqualTo("Test Event 6");
    }
}
