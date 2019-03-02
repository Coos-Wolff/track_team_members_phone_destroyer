package com.wolffsoft.phonedestroyer.calculate;

import com.wolffsoft.phonedestroyer.model.Event;
import com.wolffsoft.phonedestroyer.model.EventHistory;
import com.wolffsoft.phonedestroyer.repository.EventHistoryRepository;
import com.wolffsoft.phonedestroyer.repository.EventRepository;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Calculate {

    private EventRepository eventRepository;
    private EventHistoryRepository eventHistoryRepository;

    public Calculate(EventRepository eventRepository, EventHistoryRepository eventHistoryRepository) {
        this.eventRepository = eventRepository;
        this.eventHistoryRepository = eventHistoryRepository;
    }

    public List<String> calculateMembersToBeKicked() {
        List<String> memberNames = new ArrayList<>();
        List<Event> lastTwoEvents = getLastTwoEvents();
        List<EventHistory> eventHistoryLastTwoEvents = getEventHistoryLastTwoEvents(lastTwoEvents);
        eventHistoryLastTwoEvents.removeIf(eventHistory ->
                (eventHistory.getEventTicketsCollected() > 50 && eventHistory.getPointsCollected() == 0) ||
                        (eventHistory.getEventTicketsCollected() == 0 && eventHistory.getPointsCollected() > 10)
        );

        eventHistoryLastTwoEvents.forEach(eventHistory -> memberNames.add(eventHistory.getMemberName()));

        return memberNames.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(name -> name.getValue() > 1L)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<Event> getLastTwoEvents() {
        return eventRepository.getLastTwoEvents();
    }

    public List<EventHistory> getEventHistoryLastTwoEvents(List<Event> lastTwoEvents) {
        List<EventHistory> eventHistories = eventHistoryRepository.getEventHistories();

        eventHistories.removeIf(eventHistory ->
                !eventHistory.getEventName().equalsIgnoreCase(lastTwoEvents.get(0).getName()) &&
                        !eventHistory.getEventName().equalsIgnoreCase(lastTwoEvents.get(1).getName())
        );

        return eventHistories;
    }
}
