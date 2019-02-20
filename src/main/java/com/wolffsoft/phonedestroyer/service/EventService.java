package com.wolffsoft.phonedestroyer.service;

import com.wolffsoft.phonedestroyer.model.CreateEvent;
import com.wolffsoft.phonedestroyer.model.Event;
import com.wolffsoft.phonedestroyer.model.EventTicket;
import com.wolffsoft.phonedestroyer.model.Member;
import com.wolffsoft.phonedestroyer.repository.EventHistoryRepository;
import com.wolffsoft.phonedestroyer.repository.EventRepository;
import com.wolffsoft.phonedestroyer.repository.EventMemberRepository;
import com.wolffsoft.phonedestroyer.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private EventRepository eventRepository;
    private MemberRepository memberRepository;
    private EventHistoryRepository eventHistoryRepository;
    private EventMemberRepository eventMemberRepository;

    public EventService(EventRepository eventRepository,
                        MemberRepository memberRepository,
                        EventHistoryRepository eventHistoryRepository,
                        EventMemberRepository eventMemberRepository) {
        this.eventRepository = eventRepository;
        this.memberRepository = memberRepository;
        this.eventHistoryRepository = eventHistoryRepository;
        this.eventMemberRepository = eventMemberRepository;
    }

    public List<EventTicket> getEventTicketsTeamMembersByEventName(String eventName) {
        List<EventTicket> eventTickets = new ArrayList<>();
        List<Member> members = memberRepository.getMembersByEventName(eventName);

        members.forEach(teamMember -> {
            EventTicket eventTicket = EventTicket.builder()
                    .memberName(teamMember.getName())
                    .amountEventTickets(teamMember.getTicketsCollectedCurrentEvent())
                    .build();
            eventTickets.add(eventTicket);
        });

        return eventTickets;
    }

    public void storeEventHistory(Event event) {
        List<Member> members = memberRepository.getMembersByEventName(event.getName());
        members.forEach(teamMember -> eventHistoryRepository.storeEventHistory(teamMember, event));
    }

    public void createNewEvent(String eventName, String eventType) {
        CreateEvent createEvent = CreateEvent.create(eventName, eventType);
        List<Member> members = memberRepository.getAllMembers();

        eventRepository.createNewEvent(createEvent);

        Optional<Event> event = eventRepository.getEventByName(eventName);

        event.ifPresent(createdEvent -> members.forEach(teamMember ->
                eventMemberRepository.storeEventIdAndMemberId(createdEvent, teamMember)));
    }

    public Optional<Event> getEventByName(String eventName) {
        return eventRepository.getEventByName(eventName);
    }

    public void endEvent(Event event) {
        eventRepository.endEvent(event);
        List<Member> members = memberRepository.getAllMembers();
        members.forEach(member -> {
            memberRepository.setTicketsToZero(member);
            eventHistoryRepository.storeEventHistory(member, event);
        });
    }
}
