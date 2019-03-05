package com.wolffsoft.phonedestroyer.calculate;

import com.wolffsoft.phonedestroyer.model.DividedEventHistory;
import com.wolffsoft.phonedestroyer.model.event.EventHistory;
import com.wolffsoft.phonedestroyer.repository.EventHistoryRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Calculate {

    private static final LocalDate ONE_WEEK_AGO = LocalDate.now().minusWeeks(1);
    private static final LocalDate TWO_WEEKS_AGO = LocalDate.now().minusWeeks(2);
    private static final LocalDate FOUR_WEEKS_AGO = LocalDate.now().minusWeeks(4);
    private EventHistoryRepository eventHistoryRepository;

    public Calculate(EventHistoryRepository eventHistoryRepository) {
        this.eventHistoryRepository = eventHistoryRepository;
    }

    public List<String> membersToKick() {
        List<String> membersToKick = new ArrayList<>();
        List<EventHistory> eventHistoryLastFourEvents = getEventHistoryLastFourEvents();

        eventHistoryLastFourEvents.removeIf(this::removeOldEvents);
        DividedEventHistory dividedEventHistory = divideEventHistoryIntoLists(eventHistoryLastFourEvents);
        calculateMembersToKick(dividedEventHistory).forEach(membersToKick::add);
        calculateEldersToKick(dividedEventHistory).forEach(membersToKick::add);

        return membersToKick;
    }

    public List<EventHistory> getEventHistoryLastFourEvents() {
        List<EventHistory> eventHistories = eventHistoryRepository.getEventHistories();
        eventHistories.removeIf(eventHistory -> eventHistory.getEventDate().isBefore(FOUR_WEEKS_AGO));

        return eventHistories;
    }

    private DividedEventHistory divideEventHistoryIntoLists(
            List<EventHistory> eventHistoryLastFourEvents) {
        DividedEventHistory dividedEventHistory = new DividedEventHistory();
        eventHistoryLastFourEvents.forEach(eventHistory -> {
            if (eventHistory.getRole().equalsIgnoreCase("Elder")) {
                dividedEventHistory.addForElders(eventHistory);
            } else {
                dividedEventHistory.addForMembers(eventHistory);
            }
        });
        return dividedEventHistory;
    }

    private List<String> calculateMembersToKick(DividedEventHistory dividedEventHistory) {
        List<String> allMembersToKick = new ArrayList<>();
        List<EventHistory> beginnersToKick = addBeginnersToKick(dividedEventHistory);
        List<EventHistory> membersToKick = addMembersToKick(dividedEventHistory);

        beginnersToKick.forEach(eventHistory -> allMembersToKick.add(eventHistory.getMemberName()));
        getDuplicates(membersToKick).forEach(eventHistory -> allMembersToKick.add(eventHistory.getMemberName()));

        return removeDuplicates(allMembersToKick);
    }

    private boolean removeOldEvents(EventHistory eventHistory) {
        return eventHistory.getRole().equalsIgnoreCase("Member") &&
                eventHistory.getEventDate().isBefore(TWO_WEEKS_AGO);
    }

    private List<EventHistory> addBeginnersToKick(DividedEventHistory dividedEventHistory) {
        List<EventHistory> beginnersThreshold = new ArrayList<>();
        dividedEventHistory
                .getEventHistoryMembers()
                .forEach(eventHistory -> {
                    if (thresholdBeginner(eventHistory)) {
                        beginnersThreshold.add(eventHistory);
                    }
                });
        return beginnersThreshold;
    }

    private List<EventHistory> addMembersToKick(DividedEventHistory dividedEventHistory) {
        List<EventHistory> membersThreshold = new ArrayList<>();
        dividedEventHistory
                .getEventHistoryMembers()
                .forEach(eventHistory -> {
            if (thresholdPoints(eventHistory) || thresholdTickets(eventHistory)) {
                membersThreshold.add(eventHistory);
            }
        });
        return membersThreshold;
    }

    private List<String> calculateEldersToKick(DividedEventHistory dividedEventHistory) {
        List<EventHistory> eldersThreshold = new ArrayList<>();
        List<String> eldersToKick = new ArrayList<>();
        dividedEventHistory
                .getEventHistoryElders()
                .forEach(eventHistory -> {
            if (thresholdPoints(eventHistory) || thresholdTickets(eventHistory)) {
                eldersThreshold.add(eventHistory);
            }
        });
        getDuplicates(eldersThreshold).forEach(eventHistory -> eldersToKick.add(eventHistory.getMemberName()));

        return removeDuplicates(eldersToKick);
    }

    private boolean thresholdBeginner(EventHistory eventHistory) {
        return (eventHistory.getDateJoinedTeam().isEqual(ONE_WEEK_AGO) ||
                eventHistory.getDateJoinedTeam().isAfter(ONE_WEEK_AGO)) &&
                (thresholdTickets(eventHistory) || thresholdPoints(eventHistory));
    }

    private boolean thresholdTickets(EventHistory eventHistory) {
        return eventHistory.getEventTicketsCollected() < 50 && eventHistory.getPointsCollected() == 0;
    }

    private boolean thresholdPoints(EventHistory eventHistory) {
        return eventHistory.getEventTicketsCollected() == 0 && eventHistory.getPointsCollected() < 10;
    }

    private List<EventHistory> getDuplicates(List<EventHistory> eventHistories) {
        return eventHistories.stream()
                .collect(Collectors.groupingBy(EventHistory::getMemberId))
                .entrySet().stream()
                .filter(entry-> entry.getValue().size() > 1L)
                .flatMap(entry-> entry.getValue().stream())
                .collect(Collectors.toList());
    }

    private List<String> removeDuplicates(List<String> memberNamesToKick) {
        return memberNamesToKick.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(name -> name.getValue() >= 1L)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
