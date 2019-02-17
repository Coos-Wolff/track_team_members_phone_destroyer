package com.wolffsoft.phonedestroyer.service;

import com.wolffsoft.phonedestroyer.model.Event;
import com.wolffsoft.phonedestroyer.model.EventHistory;
import com.wolffsoft.phonedestroyer.model.EventTicket;
import com.wolffsoft.phonedestroyer.model.TeamMember;
import com.wolffsoft.phonedestroyer.repository.EventHistoryRepository;
import com.wolffsoft.phonedestroyer.repository.TeamMemberRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceTest {

    @Mock
    private TeamMemberRepository teamMemberRepository;

    @Mock
    private EventHistoryRepository eventHistoryRepository;

    private TeamMember teamMember1;
    private TeamMember teamMember2;
    private TeamMember teamMember3;

    private EventService eventService;

    @Before
    public void setup() {
        teamMember1 = TeamMember.builder()
                .id(1)
                .name("Team Member Name 1")
                .ticketsCollectedCurrentEvent(150)
                .build();
        teamMember2 = TeamMember.builder()
                .id(2)
                .name("Team Member Name 2")
                .ticketsCollectedCurrentEvent(12)
                .build();
        teamMember3 = TeamMember.builder()
                .id(1)
                .name("Team Member Name 3")
                .ticketsCollectedCurrentEvent(1456)
                .build();

        eventService = new EventService(teamMemberRepository, eventHistoryRepository);
    }

    @Test
    public void testGetEventTicketsOfTeamMembersByEvent() {
        String eventName = "Test Event 1";
        List<TeamMember> teamMembers = Stream.of(teamMember1, teamMember2, teamMember3)
                .collect(Collectors.toList());

        when(teamMemberRepository.getTeamMembersByEventName(eventName)).thenReturn(teamMembers);

        List<EventTicket> returnedEventTickets = eventService.getEventTicketsTeamMembersByEventName(eventName);

        assertThat(returnedEventTickets.get(0).getTeamMemberName()).isEqualTo(teamMember1.getName());
        assertThat(returnedEventTickets.get(0).getAmountEventTickets())
                .isEqualTo(teamMember1.getTicketsCollectedCurrentEvent());

        assertThat(returnedEventTickets.get(1).getTeamMemberName()).isEqualTo(teamMember2.getName());
        assertThat(returnedEventTickets.get(1).getAmountEventTickets())
                .isEqualTo(teamMember2.getTicketsCollectedCurrentEvent());

        assertThat(returnedEventTickets.get(2).getTeamMemberName()).isEqualTo(teamMember3.getName());
        assertThat(returnedEventTickets.get(2).getAmountEventTickets())
                .isEqualTo(teamMember3.getTicketsCollectedCurrentEvent());
    }

    @Test
    public void testEndEventAndStoreEventHistory() {
        List<TeamMember> teamMembers = Stream.of(teamMember1, teamMember2, teamMember3).collect(Collectors.toList());
        Event event = Event.builder()
                .id(1)
                .name("Test Event")
                .teamMembers(teamMembers)
                .build();

        EventHistory eventHistory1 = EventHistory.builder()
                .eventId(event.getId())
                .eventName(event.getName())
                .teamMemberId(teamMember1.getId())
                .eventTicketsCollected(teamMember1.getTicketsCollectedCurrentEvent())
                .build();
        EventHistory eventHistory2 = EventHistory.builder()
                .eventId(event.getId())
                .eventName(event.getName())
                .teamMemberId(teamMember2.getId())
                .eventTicketsCollected(teamMember2.getTicketsCollectedCurrentEvent())
                .build();
        EventHistory eventHistory3 = EventHistory.builder()
                .eventId(event.getId())
                .eventName(event.getName())
                .teamMemberId(teamMember3.getId())
                .eventTicketsCollected(teamMember3.getTicketsCollectedCurrentEvent())
                .build();

        List<EventHistory> eventHistories = Stream.of(eventHistory1, eventHistory2, eventHistory3).collect(Collectors.toList());

        when(teamMemberRepository.getTeamMembersByEventName(event.getName())).thenReturn(teamMembers);
        when(eventHistoryRepository.getAllEventHistories()).thenReturn(eventHistories);

        eventService.endEventAndStoreEventHistory(event);
        List<EventHistory> returnedEventHistory = eventHistoryRepository.getAllEventHistories();

        assertThat(returnedEventHistory.get(0).getEventId()).isEqualTo(event.getId());
        assertThat(returnedEventHistory.get(1).getEventId()).isEqualTo(event.getId());
        assertThat(returnedEventHistory.get(2).getEventId()).isEqualTo(event.getId());
        assertThat(returnedEventHistory.get(0).getTeamMemberId()).isEqualTo(teamMember1.getId());
        assertThat(returnedEventHistory.get(1).getTeamMemberId()).isEqualTo(teamMember2.getId());
        assertThat(returnedEventHistory.get(2).getTeamMemberId()).isEqualTo(teamMember3.getId());
    }
}
