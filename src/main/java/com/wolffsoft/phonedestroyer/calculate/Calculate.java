package com.wolffsoft.phonedestroyer.calculate;

import com.wolffsoft.phonedestroyer.model.EventHistory;
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

        divideMembersIntoSeparateLists(eventHistoryLastFourEvents, eventHistoryOfElders, eventHistoryOfMembers);
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
        List<EventHistory> beginnersThreshold = new ArrayList<>();
        List<EventHistory> membersThreshold = new ArrayList<>();
        List<String> membersToKick = new ArrayList<>();

        eventHistoryOfMembers.removeIf(eventHistory -> eventHistory.getEventDate().isBefore(TWO_WEEKS_AGO));
        eventHistoryOfMembers.forEach(eventHistory -> {
            if (thresholdBeginner(eventHistory)) {
                beginnersThreshold.add(eventHistory);
            } else if (thresholdPoints(eventHistory) || thresholdTickets(eventHistory)) {
                membersThreshold.add(eventHistory);
            }
        });
        beginnersThreshold.forEach(eventHistory -> membersToKick.add(eventHistory.getMemberName()));
        getDuplicates(membersThreshold).forEach(eventHistory -> membersToKick.add(eventHistory.getMemberName()));

        return removeDuplicates(membersToKick);
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

    private boolean thresHoldElder(EventHistory eventHistory) {
        return true;
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
