package com.wolffsoft.phonedestroyer.service;

import com.wolffsoft.phonedestroyer.model.*;
import com.wolffsoft.phonedestroyer.repository.EventHistoryRepository;
import com.wolffsoft.phonedestroyer.repository.EventMemberRepository;
import com.wolffsoft.phonedestroyer.repository.EventRepository;
import com.wolffsoft.phonedestroyer.repository.MemberRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.wolffsoft.phonedestroyer.helperclass.model.EventHistoryTestObject.getTestEventHistories;
import static com.wolffsoft.phonedestroyer.helperclass.model.MemberTestObject.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceTest {

    private static final String EVENT_NAME = "New created Test Event";
    private static final String EVENT_TYPE_TICKETS = "Tickets";
    private static final String EVENT_TYPE_POINTS = "Points";

    @Mock
    private EventRepository eventRepository;

    @Mock
    private EventMemberRepository eventMemberRepository;

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private EventHistoryRepository eventHistoryRepository;

    private List<Member> testMembers;
    private List<EventHistory> testEventHistories;
    private EventService eventService;

    @Before
    public void setup() {
        testMembers = getTestTeamMembers();
        testEventHistories = getTestEventHistories();
        eventService = new EventService(
                eventRepository,
                memberRepository,
                eventHistoryRepository,
                eventMemberRepository
        );
    }

    @Test
    public void testGetEventTicketsOfTeamMembersByEvent() {
        String eventName = "Test Event 1";

        when(memberRepository.getMembersByEventName(eventName)).thenReturn(testMembers);

        List<EventTicket> returnedEventTickets = eventService
                .getEventTicketsTeamMembersByEventName(eventName);

        assertThat(returnedEventTickets.get(0).getMemberName()).isEqualTo(testMember1.getName());
        assertThat(returnedEventTickets.get(0).getAmountEventTickets())
                .isEqualTo(testMember1.getTicketsCollectedCurrentEvent());

        assertThat(returnedEventTickets.get(1).getMemberName()).isEqualTo(testMember2.getName());
        assertThat(returnedEventTickets.get(1).getAmountEventTickets())
                .isEqualTo(testMember2.getTicketsCollectedCurrentEvent());

        assertThat(returnedEventTickets.get(2).getMemberName()).isEqualTo(testMember3.getName());
        assertThat(returnedEventTickets.get(2).getAmountEventTickets())
                .isEqualTo(testMember3.getTicketsCollectedCurrentEvent());
    }

    @Test
    public void testStoreEventHistory() {
        Event event = Event.builder()
                .id(1)
                .name("Test Event")
                .members(testMembers)
                .build();

        when(eventHistoryRepository.getAllEventHistories()).thenReturn(testEventHistories);

        eventService.storeEventHistory(event);
        List<EventHistory> returnedEventHistory = eventHistoryRepository.getAllEventHistories();

        assertThat(returnedEventHistory.get(0).getMemberId()).isEqualTo(testMember1.getId());
        assertThat(returnedEventHistory.get(1).getMemberId()).isEqualTo(testMember2.getId());
        assertThat(returnedEventHistory.get(2).getMemberId()).isEqualTo(testMember3.getId());
    }

    @Test
    public void testCreateNewEvent() {
        ArgumentCaptor<Event> eventArgumentCaptor = ArgumentCaptor.forClass(Event.class);
        ArgumentCaptor<Member> memberArgumentCaptor = ArgumentCaptor.forClass(Member.class);
        Event event = Event.builder()
                .id(666)
                .name(EVENT_NAME)
                .eventType(EVENT_TYPE_TICKETS)
                .members(testMembers)
                .build();

        when(memberRepository.getAllMembers()).thenReturn(testMembers);
        when(eventRepository.getEventByName(EVENT_NAME)).thenReturn(Optional.of(event));

        eventService.createNewEvent(EVENT_NAME, EVENT_TYPE_TICKETS);

        verify(eventMemberRepository, times(6))
                .storeEventIdAndMemberId(eventArgumentCaptor.capture(), memberArgumentCaptor.capture());

        Event returnedEvent = eventService.getEventByName(EVENT_NAME).get();
        Event capturedEvent = eventArgumentCaptor.getValue();
        List<Member> capturedMember = memberArgumentCaptor.getAllValues();

        assertThat(capturedEvent).isEqualTo(event);
        assertThat(capturedMember).isEqualTo(testMembers);
        assertThat(returnedEvent).isEqualTo(event);
    }

    @Test
    public void testGetEventByName() {
        Event event = Event.builder()
                .id(1)
                .name(EVENT_NAME)
                .build();
        when(eventRepository.getEventByName(EVENT_NAME)).thenReturn(Optional.of(event));

        Event returnedEvent = eventService.getEventByName(EVENT_NAME).get();

        assertThat(returnedEvent).isEqualTo(event);
    }

    @Test
    public void testEndEvent() {
        Event event = Event.builder()
                .id(123456789)
                .name(EVENT_NAME)
                .members(testMembers)
                .eventHasEnded(false)
                .build();

        when(memberRepository.getAllMembers()).thenReturn(testMembers);

        ArgumentCaptor<Member> memberArgumentCaptor = ArgumentCaptor.forClass(Member.class);
        ArgumentCaptor<Event> eventArgumentCaptor = ArgumentCaptor.forClass(Event.class);

        eventService.endEvent(event);

        verify(eventRepository, times(1)).endEvent(eventArgumentCaptor.capture());
        verify(memberRepository, times(6)).setTicketsToZero(memberArgumentCaptor.capture());
        testMembers.forEach(testMember ->
                verify(eventHistoryRepository, times(6))
                        .storeEventHistory(memberArgumentCaptor.capture(), eventArgumentCaptor.capture()));

        List<Member> capturedMembers = memberArgumentCaptor.getAllValues();
        Event capturedEvent = eventArgumentCaptor.getValue();

        assertThat(capturedMembers).containsSequence(testMembers);
        assertThat(capturedEvent).isEqualTo(event);
    }

    @Test
    public void testCalculateMembersToBeKicked() {
        Event event1 = Event.builder()
                .id(1)
                .name("Test Event 1")
                .eventHasEnded(true)
                .eventType(EVENT_TYPE_TICKETS)
                .members(testMembers)
                .build();

        Event event2 = Event.builder()
                .id(1)
                .name("Test Event 2")
                .eventHasEnded(true)
                .eventType(EVENT_TYPE_TICKETS)
                .members(testMembers)
                .build();

        List<Event> lastTwoEvents = Stream.of(event1, event2).collect(Collectors.toList());
        List<EventHistory> eventHistoryOfLastTwoEvents = testEventHistories;

        when(eventRepository.getLastTwoEvents()).thenReturn(lastTwoEvents);
        when(eventHistoryRepository.getEventHistoryOfLastTwoEvents(event1.getName(), event2.getName()))
                .thenReturn(eventHistoryOfLastTwoEvents);
        Member member1 = testMembers.get(0);
        Member member2 = testMembers.get(1);
        when(memberRepository.getMemberByName(member1.getName())).thenReturn(Optional.of(member1));
        when(memberRepository.getMemberByName(member2.getName())).thenReturn(Optional.of(member2));

        List<Member> membersToBeKicked = eventService.calculateMembersToBeKicked();

        assertThat(membersToBeKicked.size()).isEqualTo(2);
    }
}
