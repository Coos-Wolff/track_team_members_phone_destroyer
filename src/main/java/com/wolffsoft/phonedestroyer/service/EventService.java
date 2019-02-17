package com.wolffsoft.phonedestroyer.service;

import com.wolffsoft.phonedestroyer.model.Event;
import com.wolffsoft.phonedestroyer.model.EventTicket;
import com.wolffsoft.phonedestroyer.model.TeamMember;
import com.wolffsoft.phonedestroyer.repository.EventHistoryRepository;
import com.wolffsoft.phonedestroyer.repository.TeamMemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private TeamMemberRepository teamMemberRepository;
    private EventHistoryRepository eventHistoryRepository;

    public EventService(TeamMemberRepository teamMemberRepository, EventHistoryRepository eventHistoryRepository) {
        this.teamMemberRepository = teamMemberRepository;
        this.eventHistoryRepository = eventHistoryRepository;
    }

    public List<EventTicket> getEventTicketsTeamMembersByEventName(String eventName) {
        List<EventTicket> eventTickets = new ArrayList<>();
        List<TeamMember> teamMembers = teamMemberRepository.getTeamMembersByEventName(eventName);

        teamMembers
                .forEach(teamMember -> {
                    EventTicket eventTicket = EventTicket.builder()
                            .teamMemberName(teamMember.getName())
                            .amountEventTickets(teamMember.getTicketsCollectedCurrentEvent())
                            .build();
                    eventTickets.add(eventTicket);
                });

        return eventTickets;
    }

    public void endEventAndStoreEventHistory(Event event) {
        List<TeamMember> teamMembers = teamMemberRepository.getTeamMembersByEventName(event.getName());
        teamMembers.forEach(teamMember -> eventHistoryRepository.storeEventHistoryByTeamMember(teamMember, event));
    }
}