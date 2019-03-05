package com.wolffsoft.phonedestroyer.helperclass.model.event.elder;

import com.wolffsoft.phonedestroyer.model.event.EventHistory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.wolffsoft.phonedestroyer.helperclass.model.event.elder.ElderEventDemoted.*;
import static com.wolffsoft.phonedestroyer.helperclass.model.member.elder.ElderDemoted.*;

public class ElderHistoryDemoted {

    public static EventHistory testElderHistoryDemoted1 = getTestElderHistoryDemoted1();
    public static EventHistory testElderHistoryDemoted2 = getTestElderHistoryDemoted2();
    public static EventHistory testElderHistoryDemoted3 = getTestElderHistoryDemoted3();
    public static EventHistory testElderHistoryDemoted4 = getTestElderHistoryDemoted4();

    private static EventHistory getTestElderHistoryDemoted1() {
        return EventHistory.builder()
                .id(1)
                .eventId(elderEventDemoted1.getId())
                .eventName(elderEventDemoted1.getName())
                .eventDate(elderEventDemoted1.getEventDate())
                .memberId(testElderDemoted1.getId())
                .memberName(testElderDemoted1.getName())
                .dateJoinedTeam(testElderDemoted1.getDateJoinedTeam())
                .role(testElderDemoted1.getRole())
                .eventTicketsCollected(testElderDemoted1.getTicketsCollectedCurrentEvent())
                .pointsCollected(testElderDemoted1.getPointsCollectedCurrentEvent())
                .build();
    }
    private static EventHistory getTestElderHistoryDemoted2() {
        return EventHistory.builder()
                .id(2)
                .eventId(elderEventDemoted2.getId())
                .eventName(elderEventDemoted2.getName())
                .eventDate(elderEventDemoted2.getEventDate())
                .memberId(testElderDemoted2.getId())
                .memberName(testElderDemoted2.getName())
                .dateJoinedTeam(testElderDemoted2.getDateJoinedTeam())
                .role(testElderDemoted2.getRole())
                .eventTicketsCollected(testElderDemoted2.getTicketsCollectedCurrentEvent())
                .pointsCollected(testElderDemoted2.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestElderHistoryDemoted3() {
        return EventHistory.builder()
                .id(3)
                .eventId(elderEventDemoted1.getId())
                .eventName(elderEventDemoted1.getName())
                .eventDate(elderEventDemoted1.getEventDate())
                .memberId(testElderDemoted3.getId())
                .memberName(testElderDemoted3.getName())
                .dateJoinedTeam(testElderDemoted3.getDateJoinedTeam())
                .role(testElderDemoted3.getRole())
                .eventTicketsCollected(testElderDemoted3.getTicketsCollectedCurrentEvent())
                .pointsCollected(testElderDemoted3.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestElderHistoryDemoted4() {
        return EventHistory.builder()
                .id(4)
                .eventId(elderEventDemoted2.getId())
                .eventName(elderEventDemoted2.getName())
                .eventDate(elderEventDemoted2.getEventDate())
                .memberId(testElderDemoted4.getId())
                .memberName(testElderDemoted4.getName())
                .dateJoinedTeam(testElderDemoted4.getDateJoinedTeam())
                .role(testElderDemoted4.getRole())
                .eventTicketsCollected(testElderDemoted4.getTicketsCollectedCurrentEvent())
                .pointsCollected(testElderDemoted4.getPointsCollectedCurrentEvent())
                .build();
    }

    public static List<EventHistory> getEldersHistoryToKick() {
        return Stream.of(
                testElderHistoryDemoted1,
                testElderHistoryDemoted2,
                testElderHistoryDemoted3,
                testElderHistoryDemoted4
        ).collect(Collectors.toList());
    }
}
