package com.wolffsoft.phonedestroyer.helperclass.model;

import com.wolffsoft.phonedestroyer.model.EventHistory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.wolffsoft.phonedestroyer.helperclass.model.EventTestObject.*;
import static com.wolffsoft.phonedestroyer.helperclass.model.MemberTestObject.*;

public class EventHistoryTestObject {

    public static EventHistory testEventHistory1 = getTestEventHistory1();
    public static EventHistory testEventHistory2 = getTestEventHistory2();
    public static EventHistory testEventHistory3 = getTestEventHistory3();
    public static EventHistory testEventHistory4 = getTestEventHistory4();
    public static EventHistory testEventHistory5 = getTestEventHistory5();
    public static EventHistory testEventHistory6 = getTestEventHistory6();
    public static EventHistory testEventHistory7 = getTestEventHistory7();
    public static EventHistory testEventHistory8 = getTestEventHistory8();
    public static EventHistory testEventHistory9 = getTestEventHistory9();
    public static EventHistory testEventHistory10 = getTestEventHistory10();
    public static EventHistory testEventHistory11 = getTestEventHistory11();
    public static EventHistory testEventHistory12 = getTestEventHistory12();
    public static EventHistory testEventHistory13 = getTestEventHistory13();
    public static EventHistory testEventHistory14 = getTestEventHistory14();
    public static EventHistory testEventHistory15 = getTestEventHistory15();
    public static EventHistory testEventHistory16 = getTestEventHistory16();

    private static EventHistory getTestEventHistory1() {
        return EventHistory.builder()
                .id(1)
                .eventId(testEvent1.getId())
                .eventName(testEvent1.getName())
                .eventDate(testEvent1.getEventDate())
                .memberId(testMember1.getId())
                .memberName(testMember1.getName())
                .dateJoinedTeam(testMember1.getDateJoinedTeam())
                .role(testMember1.getRole())
                .eventTicketsCollected(testMember1.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember1.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory2() {
        return EventHistory.builder()
                .id(2)
                .eventId(testEvent1.getId())
                .eventName(testEvent1.getName())
                .eventDate(testEvent1.getEventDate())
                .memberId(testMember2.getId())
                .memberName(testMember2.getName())
                .dateJoinedTeam(testMember2.getDateJoinedTeam())
                .role(testMember2.getRole())
                .eventTicketsCollected(testMember2.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember2.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory3() {
        return EventHistory.builder()
                .id(3)
                .eventId(testEvent1.getId())
                .eventName(testEvent1.getName())
                .eventDate(testEvent1.getEventDate())
                .memberId(testMember3.getId())
                .memberName(testMember3.getName())
                .dateJoinedTeam(testMember3.getDateJoinedTeam())
                .role(testMember3.getRole())
                .eventTicketsCollected(testMember3.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember2.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory4() {
        return EventHistory.builder()
                .id(4)
                .eventId(testEvent4.getId())
                .eventName(testEvent4.getName())
                .eventDate(testEvent4.getEventDate())
                .memberId(testMember4.getId())
                .memberName(testMember4.getName())
                .dateJoinedTeam(testMember4.getDateJoinedTeam())
                .role(testMember4.getRole())
                .eventTicketsCollected(testMember4.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember4.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory5() {
        return EventHistory.builder()
                .id(5)
                .eventId(testEvent2.getId())
                .eventName(testEvent2.getName())
                .eventDate(testEvent2.getEventDate())
                .memberId(testMember5.getId())
                .memberName(testMember5.getName())
                .dateJoinedTeam(testMember5.getDateJoinedTeam())
                .role(testMember5.getRole())
                .eventTicketsCollected(testMember5.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember5.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory6() {
        return EventHistory.builder()
                .id(6)
                .eventId(testEvent2.getId())
                .eventName(testEvent2.getName())
                .eventDate(testEvent2.getEventDate())
                .memberId(testMember6.getId())
                .memberName(testMember6.getName())
                .dateJoinedTeam(testMember6.getDateJoinedTeam())
                .role(testMember6.getRole())
                .eventTicketsCollected(testMember6.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember6.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory7() {
        return EventHistory.builder()
                .id(7)
                .eventId(testEvent2.getId())
                .eventName(testEvent2.getName())
                .eventDate(testEvent2.getEventDate())
                .memberId(testMember7.getId())
                .memberName(testMember7.getName())
                .dateJoinedTeam(testMember7.getDateJoinedTeam())
                .role(testMember7.getRole())
                .eventTicketsCollected(testMember7.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember7.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory8() {
        return EventHistory.builder()
                .id(8)
                .eventId(testEvent2.getId())
                .eventName(testEvent2.getName())
                .eventDate(testEvent2.getEventDate())
                .memberId(testMember8.getId())
                .memberName(testMember8.getName())
                .dateJoinedTeam(testMember8.getDateJoinedTeam())
                .role(testMember8.getRole())
                .eventTicketsCollected(testMember8.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember8.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory9() {
        return EventHistory.builder()
                .id(9)
                .eventId(testEvent3.getId())
                .eventName(testEvent3.getName())
                .eventDate(testEvent3.getEventDate())
                .memberId(testMember9.getId())
                .memberName(testMember9.getName())
                .dateJoinedTeam(testMember9.getDateJoinedTeam())
                .role(testMember9.getRole())
                .eventTicketsCollected(testMember9.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember9.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory10() {
        return EventHistory.builder()
                .id(10)
                .eventId(testEvent3.getId())
                .eventName(testEvent3.getName())
                .eventDate(testEvent3.getEventDate())
                .memberId(testMember10.getId())
                .memberName(testMember10.getName())
                .dateJoinedTeam(testMember10.getDateJoinedTeam())
                .role(testMember10.getRole())
                .eventTicketsCollected(testMember10.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember10.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory11() {
        return EventHistory.builder()
                .id(11)
                .eventId(testEvent3.getId())
                .eventName(testEvent3.getName())
                .eventDate(testEvent3.getEventDate())
                .memberId(testMember11.getId())
                .memberName(testMember11.getName())
                .dateJoinedTeam(testMember11.getDateJoinedTeam())
                .role(testMember11.getRole())
                .eventTicketsCollected(testMember11.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember11.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory12() {
        return EventHistory.builder()
                .id(12)
                .eventId(testEvent3.getId())
                .eventName(testEvent3.getName())
                .eventDate(testEvent3.getEventDate())
                .memberId(testMember12.getId())
                .memberName(testMember12.getName())
                .dateJoinedTeam(testMember12.getDateJoinedTeam())
                .role(testMember12.getRole())
                .eventTicketsCollected(testMember12.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember12.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory13() {
        return EventHistory.builder()
                .id(13)
                .eventId(testEvent4.getId())
                .eventName(testEvent4.getName())
                .eventDate(testEvent4.getEventDate())
                .memberId(testMember13.getId())
                .memberName(testMember13.getName())
                .dateJoinedTeam(testMember13.getDateJoinedTeam())
                .role(testMember13.getRole())
                .eventTicketsCollected(testMember13.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember13.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory14() {
        return EventHistory.builder()
                .id(14)
                .eventId(testEvent4.getId())
                .eventName(testEvent4.getName())
                .eventDate(testEvent4.getEventDate())
                .memberId(testMember14.getId())
                .memberName(testMember14.getName())
                .dateJoinedTeam(testMember14.getDateJoinedTeam())
                .role(testMember14.getRole())
                .eventTicketsCollected(testMember14.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember14.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory15() {
        return EventHistory.builder()
                .id(15)
                .eventId(testEvent4.getId())
                .eventName(testEvent4.getName())
                .eventDate(testEvent4.getEventDate())
                .memberId(testMember15.getId())
                .memberName(testMember15.getName())
                .dateJoinedTeam(testMember15.getDateJoinedTeam())
                .role(testMember15.getRole())
                .eventTicketsCollected(testMember15.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember15.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory16() {
        return EventHistory.builder()
                .id(16)
                .eventId(testEvent4.getId())
                .eventName(testEvent4.getName())
                .eventDate(testEvent4.getEventDate())
                .memberId(testMember16.getId())
                .memberName(testMember16.getName())
                .dateJoinedTeam(testMember16.getDateJoinedTeam())
                .role(testMember16.getRole())
                .eventTicketsCollected(testMember16.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember16.getPointsCollectedCurrentEvent())
                .build();
    }

    public static List<EventHistory> getTestEventHistories() {
        return Stream.of(
                testEventHistory1,
                testEventHistory2,
                testEventHistory3,
                testEventHistory4,
                testEventHistory5,
                testEventHistory6,
                testEventHistory7,
                testEventHistory8,
                testEventHistory9,
                testEventHistory10,
                testEventHistory11,
                testEventHistory12,
                testEventHistory13,
                testEventHistory14,
                testEventHistory15,
                testEventHistory16
        ).collect(Collectors.toList());
    }
}
