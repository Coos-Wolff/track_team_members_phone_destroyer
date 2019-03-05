package com.wolffsoft.phonedestroyer.calculate;

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

    public List<String> membersToBeKicked() {
        List<EventHistory> eventHistoryLastFourEvents = getEventHistoryLastFourEvents();
        List<String> membersToKick = new ArrayList<>();
        List<EventHistory> eventHistoryOfMembers = new ArrayList<>();
        List<EventHistory> eventHistoryOfElders = new ArrayList<>();

        List<EventHistory> eventHistoryLastFourEvents = getEventHistoryLastFourEvents();
        divideEventHistoryIntoLists(eventHistoryLastFourEvents, eventHistoryOfElders, eventHistoryOfMembers);
        calculateMembersToKick(eventHistoryOfMembers).forEach(membersToKick::add);
        calculateEldersToKick(eventHistoryOfElders).forEach(membersToKick::add);

        return membersToKick;
    }

    public List<EventHistory> getEventHistoryLastFourEvents() {
        List<EventHistory> eventHistories = eventHistoryRepository.getEventHistories();
        eventHistories.removeIf(eventHistory -> eventHistory.getEventDate().isBefore(FOUR_WEEKS_AGO));

        return eventHistories;
    }

    private void divideMembersIntoSeparateLists(
    private void divideEventHistoryIntoLists(
            List<EventHistory> eventHistoryLastFourEvents,
            List<EventHistory> eventHistoryOfElders,
            List<EventHistory> eventHistoryOfMembers) {
        eventHistoryLastFourEvents.forEach(eventHistory -> {
            if (eventHistory.getRole().equalsIgnoreCase("Elder")) {
                eventHistoryOfElders.add(eventHistory);
            } else {
                eventHistoryOfMembers.add(eventHistory);
            }
        });
    }

    private List<String> calculateMembersToKick(List<EventHistory> eventHistoryOfMembers) {
        List<String> allMembersToKick = new ArrayList<>();
        eventHistoryOfMembers.removeIf(this::removeAllEventHistoryBeforeTwoWeeks);

        List<EventHistory> beginnersToKick = addBeginnersToKick(eventHistoryOfMembers);
        List<EventHistory> membersToKick = addMembersToKick(eventHistoryOfMembers);

        beginnersToKick.forEach(eventHistory -> allMembersToKick.add(eventHistory.getMemberName()));
        getDuplicates(membersToKick).forEach(eventHistory -> allMembersToKick.add(eventHistory.getMemberName()));

        return removeDuplicates(allMembersToKick);
    }

    private boolean removeAllEventHistoryBeforeTwoWeeks(EventHistory eventHistory) {
        return eventHistory.getEventDate().isBefore(TWO_WEEKS_AGO);
    }

    private List<EventHistory> addBeginnersToKick(List<EventHistory> eventHistoryOfMembers) {
        List<EventHistory> beginnersThreshold = new ArrayList<>();
        eventHistoryOfMembers.forEach(eventHistory -> {
            if (thresholdBeginner(eventHistory)) {
                beginnersThreshold.add(eventHistory);
            }
        });
        return beginnersThreshold;
    }

    private List<EventHistory> addMembersToKick(List<EventHistory> eventHistoryOfMembers) {
        List<EventHistory> membersThreshold = new ArrayList<>();
        eventHistoryOfMembers.forEach(eventHistory -> {
            if (thresholdPoints(eventHistory) || thresholdTickets(eventHistory)) {
                membersThreshold.add(eventHistory);
            }
        });
        return membersThreshold;
    }

    private List<String> calculateEldersToKick(List<EventHistory> eventHistoryOfElders) {
        List<EventHistory> eldersThreshold = new ArrayList<>();
        List<String> eldersToKick = new ArrayList<>();
        eventHistoryOfElders.forEach(eventHistory -> {
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
