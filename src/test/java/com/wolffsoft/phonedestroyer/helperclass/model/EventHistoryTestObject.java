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
    private static List<Member> testMembers = getTestTeamMembers();

    public static List<EventHistory> getTestEventHistories() {
        return Stream.of(testEventHistory1, testEventHistory2, testEventHistory3, testEventHistory4, testEventHistory5, testEventHistory6).collect(Collectors.toList());
    }

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
                .build();
    }
}
