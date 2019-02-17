package com.wolffsoft.phonedestroyer.repository;

import com.wolffsoft.phonedestroyer.model.Event;
import com.wolffsoft.phonedestroyer.configuration.AbstractTestRepository;
import org.jooq.DSLContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

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
}
