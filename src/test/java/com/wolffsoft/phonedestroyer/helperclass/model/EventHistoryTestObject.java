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
    private static List<Member> testMembers = getTestTeamMembers();

    public static List<EventHistory> getTestEventHistories() {
        return Stream.of(testEventHistory1, testEventHistory2, testEventHistory3).collect(Collectors.toList());
    }

    private static EventHistory getTestEventHistory1() {
        Event event = Event.builder()
                .id(1)
                .name("Test Event")
                .members(testMembers)
                .build();

        return EventHistory.builder()
                .eventId(event.getId())
                .eventName(event.getName())
                .memberId(testMember1.getId())
                .eventTicketsCollected(testMember1.getTicketsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory2() {
        Event event = Event.builder()
                .id(1)
                .name("Test Event")
                .members(testMembers)
                .build();

        return EventHistory.builder()
                .eventId(event.getId())
                .eventName(event.getName())
                .memberId(testMember2.getId())
                .eventTicketsCollected(testMember2.getTicketsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestEventHistory3() {
        Event event = Event.builder()
                .id(1)
                .name("Test Event")
                .members(testMembers)
                .build();

        return EventHistory.builder()
                .eventId(event.getId())
                .eventName(event.getName())
                .memberId(testMember3.getId())
                .eventTicketsCollected(testMember3.getTicketsCollectedCurrentEvent())
                .build();
    }
}
