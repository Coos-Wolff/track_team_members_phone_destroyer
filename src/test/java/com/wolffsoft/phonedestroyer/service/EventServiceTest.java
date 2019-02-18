package com.wolffsoft.phonedestroyer.service;

import com.wolffsoft.phonedestroyer.model.Event;
import com.wolffsoft.phonedestroyer.model.EventHistory;
import com.wolffsoft.phonedestroyer.model.EventTicket;
import com.wolffsoft.phonedestroyer.model.Member;
import com.wolffsoft.phonedestroyer.repository.EventHistoryRepository;
import com.wolffsoft.phonedestroyer.repository.EventRepository;
import com.wolffsoft.phonedestroyer.repository.EventMemberRepository;
import com.wolffsoft.phonedestroyer.repository.MemberRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.wolffsoft.phonedestroyer.helperclass.model.EventHistoryTestObject.getTestEventHistories;
import static com.wolffsoft.phonedestroyer.helperclass.model.TeamMemberTestObject.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceTest {

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

        returnedEventHistory.forEach(eventHistory ->
                assertThat(eventHistory.getEventId()).isEqualTo(event.getId()));
        assertThat(returnedEventHistory.get(0).getMemberId()).isEqualTo(testMember1.getId());
        assertThat(returnedEventHistory.get(1).getMemberId()).isEqualTo(testMember2.getId());
        assertThat(returnedEventHistory.get(2).getMemberId()).isEqualTo(testMember3.getId());
    }

    // TODO Complete this test.
    //  Make sure EventId and TeamMemberId are added to the event_team_member table.
    //  Also make sure that all team members are added to the new event.
    @Test
    public void testCreateNewEventAddTeamMembersSetTicketsToZero() {
        String eventName = "New created Test Event";

        when(memberRepository.getAllMembers()).thenReturn(testMembers);

        eventService.createNewEventAddMembersSetTicketsToZero(eventName);
    }
}
