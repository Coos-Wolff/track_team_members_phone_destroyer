package com.wolffsoft.phonedestroyer.helperclass.model.event.elder;

import com.wolffsoft.phonedestroyer.model.event.EventHistory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.wolffsoft.phonedestroyer.helperclass.model.event.elder.ElderEventNotDemoted.elderEventNotDemoted1;
import static com.wolffsoft.phonedestroyer.helperclass.model.event.elder.ElderEventNotDemoted.elderEventNotDemoted2;
import static com.wolffsoft.phonedestroyer.helperclass.model.member.elder.ElderNotDemoted.*;

public class ElderHistoryNotDemoted {

    public static EventHistory testElderHistoryNotDemoted1 = getTestElderHistoryNotDemoted1();
    public static EventHistory testElderHistoryNotDemoted2 = getTestElderHistoryNotDemoted2();
    public static EventHistory testElderHistoryNotDemoted3 = getTestElderHistoryNotDemoted3();
    public static EventHistory testElderHistoryNotDemoted4 = getTestElderHistoryNotDemoted4();

    private static EventHistory getTestElderHistoryNotDemoted1() {
        return EventHistory.builder()
                .id(1)
                .eventId(elderEventNotDemoted1.getId())
                .eventName(elderEventNotDemoted1.getName())
                .eventDate(elderEventNotDemoted1.getEventDate())
                .memberId(testElderNotKicked1.getId())
                .memberName(testElderNotKicked1.getName())
                .dateJoinedTeam(testElderNotKicked1.getDateJoinedTeam())
                .role(testElderNotKicked1.getRole())
                .eventTicketsCollected(testElderNotKicked1.getTicketsCollectedCurrentEvent())
                .pointsCollected(testElderNotKicked1.getPointsCollectedCurrentEvent())
                .build();
    }
    private static EventHistory getTestElderHistoryNotDemoted2() {
        return EventHistory.builder()
                .id(1)
                .eventId(elderEventNotDemoted2.getId())
                .eventName(elderEventNotDemoted2.getName())
                .eventDate(elderEventNotDemoted2.getEventDate())
                .memberId(testElderNotKicked2.getId())
                .memberName(testElderNotKicked2.getName())
                .dateJoinedTeam(testElderNotKicked2.getDateJoinedTeam())
                .role(testElderNotKicked2.getRole())
                .eventTicketsCollected(testElderNotKicked2.getTicketsCollectedCurrentEvent())
                .pointsCollected(testElderNotKicked2.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestElderHistoryNotDemoted3() {
        return EventHistory.builder()
                .id(1)
                .eventId(elderEventNotDemoted1.getId())
                .eventName(elderEventNotDemoted1.getName())
                .eventDate(elderEventNotDemoted1.getEventDate())
                .memberId(testElderNotKicked3.getId())
                .memberName(testElderNotKicked3.getName())
                .dateJoinedTeam(testElderNotKicked3.getDateJoinedTeam())
                .role(testElderNotKicked3.getRole())
                .eventTicketsCollected(testElderNotKicked3.getTicketsCollectedCurrentEvent())
                .pointsCollected(testElderNotKicked3.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestElderHistoryNotDemoted4() {
        return EventHistory.builder()
                .id(1)
                .eventId(elderEventNotDemoted2.getId())
                .eventName(elderEventNotDemoted2.getName())
                .eventDate(elderEventNotDemoted2.getEventDate())
                .memberId(testElderNotKicked4.getId())
                .memberName(testElderNotKicked4.getName())
                .dateJoinedTeam(testElderNotKicked4.getDateJoinedTeam())
                .role(testElderNotKicked4.getRole())
                .eventTicketsCollected(testElderNotKicked4.getTicketsCollectedCurrentEvent())
                .pointsCollected(testElderNotKicked4.getPointsCollectedCurrentEvent())
                .build();
    }

    public static List<EventHistory> getEldersHistoryNotKicked() {
        return Stream.of(
                testElderHistoryNotDemoted1,
                testElderHistoryNotDemoted2,
                testElderHistoryNotDemoted3,
                testElderHistoryNotDemoted4
        ).collect(Collectors.toList());
    }
}
