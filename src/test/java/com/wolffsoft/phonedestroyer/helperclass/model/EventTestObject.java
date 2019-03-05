package com.wolffsoft.phonedestroyer.helperclass.model;

import com.wolffsoft.phonedestroyer.model.event.Event;
import com.wolffsoft.phonedestroyer.model.Member;

import java.util.List;

import static com.wolffsoft.phonedestroyer.helperclass.model.MemberTestObject.getTestTeamMembers;
import static com.wolffsoft.phonedestroyer.model.InstantNow.localDateNow;

public class EventTestObject {

    public static Event testEvent1 = getEvent1();
    public static Event testEvent2 = getEvent2();
    public static Event testEvent3 = getEvent3();
    public static Event testEvent4 = getEvent4();
    public static Event testEvent5 = getEvent5();
    private static List<Member> testMembers = getTestTeamMembers();

    public static Event getEvent1() {
        return Event.builder()
                .id(1)
                .name("Test Event 1")
                .eventDate(localDateNow().minusWeeks(4))
                .members(testMembers)
                .build();
    }

    public static Event getEvent2() {
        return Event.builder()
                .id(2)
                .name("Test Event 2")
                .eventDate(localDateNow().minusWeeks(3))
                .members(testMembers)
                .build();
    }

    public static Event getEvent3() {
        return Event.builder()
                .id(3)
                .name("Test Event 3")
                .eventDate(localDateNow().minusWeeks(2))
                .members(testMembers)
                .build();
    }

    public static Event getEvent4() {
        return Event.builder()
                .id(4)
                .name("Test Event 4")
                .eventDate(localDateNow().minusWeeks(1))
                .members(testMembers)
                .build();
    }

    public static Event getEvent5() {
        return Event.builder()
                .id(5)
                .name("Test Event 5")
                .eventDate(localDateNow())
                .members(testMembers)
                .build();
    }
}
