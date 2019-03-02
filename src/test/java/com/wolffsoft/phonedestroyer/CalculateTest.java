package com.wolffsoft.phonedestroyer;

import com.wolffsoft.phonedestroyer.calculate.Calculate;
import com.wolffsoft.phonedestroyer.model.Event;
import com.wolffsoft.phonedestroyer.model.EventHistory;
import com.wolffsoft.phonedestroyer.model.Member;
import com.wolffsoft.phonedestroyer.repository.EventHistoryRepository;
import com.wolffsoft.phonedestroyer.repository.EventRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.wolffsoft.phonedestroyer.helperclass.model.EventHistoryTestObject.getTestEventHistories;
import static com.wolffsoft.phonedestroyer.helperclass.model.MemberTestObject.getTestTeamMembers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculateTest {

    private static final String EVENT_TYPE_TICKETS = "Tickets";

    @Mock
    private EventRepository eventRepository;

    @Mock
    private EventHistoryRepository eventHistoryRepository;

    private Calculate calculate;
    private Event event1;
    private Event event2;
    private List<Member> testMembers;
    private List<EventHistory> testEventHistories;

    @Before
    public void setup() {
        testMembers = getTestTeamMembers();
        testEventHistories = getTestEventHistories();
        event1 = Event.builder()
                .id(1)
                .name("Test Event 1")
                .eventHasEnded(true)
                .eventType(EVENT_TYPE_TICKETS)
                .members(testMembers)
                .build();

        event2 = Event.builder()
                .id(2)
                .name("Test Event 2")
                .eventHasEnded(true)
                .eventType(EVENT_TYPE_TICKETS)
                .members(testMembers)
                .build();
        calculate = new Calculate(eventRepository, eventHistoryRepository);
    }

    @Test
    public void testCalculateMembersToBeKicked() {
        List<Event> events = Stream.of(event2, event1).collect(Collectors.toList());

        when(eventRepository.getLastTwoEvents()).thenReturn(events);
        when(eventHistoryRepository.getEventHistories()).thenReturn(testEventHistories);

        List<String> memberNames = calculate.calculateMembersToBeKicked();

        assertThat(memberNames.size()).isEqualTo(4);

    }

    @Test
    public void testGetLastTwoEvents() {
        List<Event> events = Stream.of(event2, event1).collect(Collectors.toList());

        when(eventRepository.getLastTwoEvents()).thenReturn(events);

        List<Event> returnedEvents = calculate.getLastTwoEvents();

        assertThat(returnedEvents.size()).isEqualTo(2);
        assertThat(returnedEvents.get(0).getId()).isEqualTo(event2.getId());
        assertThat(returnedEvents.get(1).getId()).isEqualTo(event1.getId());
    }

    @Test
    public void testGetEventHistoryFromLastTwoEvents() {
        List<Event> events = Stream.of(event1, event2).collect(Collectors.toList());

        when(eventHistoryRepository.getEventHistories()).thenReturn(testEventHistories);

        List<EventHistory> returnedEventHistories = calculate.getEventHistoryLastTwoEvents(events);

        assertThat(returnedEventHistories.size()).isEqualTo(12);
    }
}
