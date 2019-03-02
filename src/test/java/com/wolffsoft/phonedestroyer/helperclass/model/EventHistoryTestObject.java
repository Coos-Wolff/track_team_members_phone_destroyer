package com.wolffsoft.phonedestroyer.helperclass.model;

import com.wolffsoft.phonedestroyer.model.Event;
import com.wolffsoft.phonedestroyer.model.EventHistory;
import com.wolffsoft.phonedestroyer.model.Member;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.wolffsoft.phonedestroyer.helperclass.model.MemberTestObject.*;

public class EventHistoryTestObject {

    private static EventHistory testEventHistory1 = getTestEventHistory1();
    private static EventHistory testEventHistory2 = getTestEventHistory2();
    private static EventHistory testEventHistory3 = getTestEventHistory3();
    private static EventHistory testEventHistory4 = getTestEventHistory4();
    private static EventHistory testEventHistory5 = getTestEventHistory5();
    private static EventHistory testEventHistory6 = getTestEventHistory6();
    private static EventHistory testEventHistory7 = getTestEventHistory7();
    private static EventHistory testEventHistory8 = getTestEventHistory8();
    private static EventHistory testEventHistory9 = getTestEventHistory9();
    private static EventHistory testEventHistory10 = getTestEventHistory10();
    private static EventHistory testEventHistory11 = getTestEventHistory11();
    private static EventHistory testEventHistory12 = getTestEventHistory12();
    private static List<Member> testMembers = getTestTeamMembers();

    private static EventHistory getTestEventHistory1() {
        Event event = Event.builder()
                .id(1)
                .name("Test Event 1")
                .members(testMembers)
                .build();

        return EventHistory.builder()
                .eventId(event.getId())
                .eventName(event.getName())
                .memberName(testMember1.getName())
                .memberId(testMember1.getId())
                .eventTicketsCollected(testMember1.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember1.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory2() {
        Event event = Event.builder()
                .id(1)
                .name("Test Event 1")
                .members(testMembers)
                .build();

        return EventHistory.builder()
                .eventId(event.getId())
                .eventName(event.getName())
                .memberId(testMember2.getId())
                .memberName(testMember2.getName())
                .eventTicketsCollected(testMember2.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember2.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory3() {
        Event event = Event.builder()
                .id(1)
                .name("Test Event 1")
                .members(testMembers)
                .build();

        return EventHistory.builder()
                .eventId(event.getId())
                .eventName(event.getName())
                .memberId(testMember3.getId())
                .memberName(testMember3.getName())
                .eventTicketsCollected(testMember3.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember2.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory4() {
        Event event = Event.builder()
                .id(2)
                .name("Test Event 2")
                .members(testMembers)
                .build();

        return EventHistory.builder()
                .eventId(event.getId())
                .eventName(event.getName())
                .memberId(testMember4.getId())
                .memberName(testMember4.getName())
                .eventTicketsCollected(testMember4.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember4.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory5() {
        Event event = Event.builder()
                .id(2)
                .name("Test Event 2")
                .members(testMembers)
                .build();

        return EventHistory.builder()
                .eventId(event.getId())
                .eventName(event.getName())
                .memberId(testMember5.getId())
                .memberName(testMember5.getName())
                .eventTicketsCollected(testMember5.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember5.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory6() {
        Event event = Event.builder()
                .id(2)
                .name("Test Event 2")
                .members(testMembers)
                .build();

        return EventHistory.builder()
                .eventId(event.getId())
                .eventName(event.getName())
                .memberId(testMember6.getId())
                .memberName(testMember6.getName())
                .eventTicketsCollected(testMember6.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember6.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory7() {
        Event event = Event.builder()
                .id(1)
                .name("Test Event 1")
                .members(testMembers)
                .build();

        return EventHistory.builder()
                .eventId(event.getId())
                .eventName(event.getName())
                .memberId(testMember7.getId())
                .memberName(testMember7.getName())
                .eventTicketsCollected(testMember7.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember7.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory8() {
        Event event = Event.builder()
                .id(1)
                .name("Test Event 1")
                .members(testMembers)
                .build();

        return EventHistory.builder()
                .eventId(event.getId())
                .eventName(event.getName())
                .memberId(testMember8.getId())
                .memberName(testMember8.getName())
                .eventTicketsCollected(testMember8.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember8.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory9() {
        Event event = Event.builder()
                .id(1)
                .name("Test Event 1")
                .members(testMembers)
                .build();

        return EventHistory.builder()
                .eventId(event.getId())
                .eventName(event.getName())
                .memberId(testMember9.getId())
                .memberName(testMember9.getName())
                .eventTicketsCollected(testMember9.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember9.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory10() {
        Event event = Event.builder()
                .id(2)
                .name("Test Event 2")
                .members(testMembers)
                .build();

        return EventHistory.builder()
                .eventId(event.getId())
                .eventName(event.getName())
                .memberId(testMember10.getId())
                .memberName(testMember10.getName())
                .eventTicketsCollected(testMember10.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember10.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory11() {
        Event event = Event.builder()
                .id(2)
                .name("Test Event 2")
                .members(testMembers)
                .build();

        return EventHistory.builder()
                .eventId(event.getId())
                .eventName(event.getName())
                .memberId(testMember11.getId())
                .memberName(testMember11.getName())
                .eventTicketsCollected(testMember11.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember11.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory12() {
        Event event = Event.builder()
                .id(2)
                .name("Test Event 2")
                .members(testMembers)
                .build();

        return EventHistory.builder()
                .eventId(event.getId())
                .eventName(event.getName())
                .memberId(testMember12.getId())
                .memberName(testMember12.getName())
                .eventTicketsCollected(testMember12.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMember12.getPointsCollectedCurrentEvent())
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
                testEventHistory12).collect(Collectors.toList());
    }
}
