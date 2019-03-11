package com.wolffsoft.phonedestroyer.calculate;

import com.wolffsoft.phonedestroyer.model.DivideEventHistory;
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
    private EventHistoryRepository eventHistoryRepository;

    public Calculate(EventHistoryRepository eventHistoryRepository) {
        this.eventHistoryRepository = eventHistoryRepository;
    }

    public List<String> kickMembers() {
        List<String> membersToKick = new ArrayList<>();
        List<EventHistory> historyLastFourEvents = getEventHistoryLastTwoEvents();
        DivideEventHistory divideEventHistory = divideBasedOnRole(historyLastFourEvents);

        calculateMembersToKick(divideEventHistory).forEach(membersToKick::add);

        return membersToKick;
    }

    public List<String> calculateEldersToDemote() {
        List<EventHistory> historyLastFourEvents = getEventHistoryLastTwoEvents();

        DivideEventHistory divideEventHistory = divideBasedOnRole(historyLastFourEvents);

        return demoteElderToMember(divideEventHistory);
    }

    private List<EventHistory> getEventHistoryLastTwoEvents() {
        List<EventHistory> eventHistories = eventHistoryRepository.getEventHistories();
        eventHistories.removeIf(eventHistory -> eventHistory.getEventDate().isBefore(TWO_WEEKS_AGO));

        return eventHistories;
    }

    private DivideEventHistory divideBasedOnRole(
            List<EventHistory> eventHistoryLastFourEvents) {
        DivideEventHistory divideEventHistory = new DivideEventHistory();
        eventHistoryLastFourEvents.forEach(eventHistory -> {
            if (eventHistory.getRole().equalsIgnoreCase("Elder")) {
                divideEventHistory.addForElders(eventHistory);
            } else {
                divideEventHistory.addForMembers(eventHistory);
            }
        });
        return divideEventHistory;
    }

    private List<String> calculateMembersToKick(DivideEventHistory divideEventHistory) {
        List<String> allMembersToKick = new ArrayList<>();
        List<EventHistory> beginnersToKick = addBeginnersToKick(divideEventHistory);
        List<EventHistory> membersToKick = addMembersToKick(divideEventHistory);

        beginnersToKick.forEach(eventHistory -> allMembersToKick.add(eventHistory.getMemberName()));
        getDuplicates(membersToKick).forEach(eventHistory -> allMembersToKick.add(eventHistory.getMemberName()));

        return removeDuplicates(allMembersToKick);
    }

    private List<EventHistory> addBeginnersToKick(DivideEventHistory divideEventHistory) {
        List<EventHistory> beginnersThreshold = new ArrayList<>();
        divideEventHistory
                .getEventHistoryMembers()
                .forEach(eventHistory -> {
                    if (thresholdBeginner(eventHistory)) {
                        beginnersThreshold.add(eventHistory);
                    }
                });
        return beginnersThreshold;
    }

    private List<EventHistory> addMembersToKick(DivideEventHistory divideEventHistory) {
        List<EventHistory> membersThreshold = new ArrayList<>();
        divideEventHistory
                .getEventHistoryMembers()
                .forEach(eventHistory -> {
            if (thresholdPoints(eventHistory) || thresholdTickets(eventHistory)) {
                membersThreshold.add(eventHistory);
            }
        });
        return membersThreshold;
    }

    private List<String> demoteElderToMember(DivideEventHistory divideEventHistory) {
        List<EventHistory> eldersThreshold = new ArrayList<>();
        List<String> eldersToDemote = new ArrayList<>();
        divideEventHistory
                .getEventHistoryElders()
                .forEach(eventHistory -> {
            if (thresholdPoints(eventHistory) || thresholdTickets(eventHistory)) {
                eldersThreshold.add(eventHistory);
            }
        });
        getDuplicates(eldersThreshold).forEach(eventHistory -> eldersToDemote.add(eventHistory.getMemberName()));

        return removeDuplicates(eldersToDemote);
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
