package com.wolffsoft.phonedestroyer.helperclass.model;

import com.wolffsoft.phonedestroyer.model.Member;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MemberTestObject {

    public static Member testMember1 = getTestMember1();
    public static Member testMember2 = getTestMember2();
    public static Member testMember3 = getTestMember3();
    public static Member testMember4 = getTestMember4();
    public static Member testMember5 = getTestMember5();
    public static Member testMember6 = getTestMember6();

    private static Member getTestMember1() {
        return Member.builder()
                .id(123)
                .name("Member Name 1")
                .ticketsCollectedCurrentEvent(15)
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    private static Member getTestMember2() {
        return Member.builder()
                .id(234)
                .name("Member Name 2")
                .ticketsCollectedCurrentEvent(12)
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    private static Member getTestMember3() {
        return Member.builder()
                .id(345)
                .name("Member Name 3")
                .ticketsCollectedCurrentEvent(1456)
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    private static Member getTestMember4() {
        return Member.builder()
                .id(123)
                .name("Member Name 1")
                .ticketsCollectedCurrentEvent(1)
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    private static Member getTestMember5() {
        return Member.builder()
                .id(234)
                .name("Member Name 2")
                .ticketsCollectedCurrentEvent(2)
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    private static Member getTestMember6() {
        return Member.builder()
                .id(456)
                .name("Member Name 3")
                .ticketsCollectedCurrentEvent(3)
                .build();
    }

    public static List<Member> getTestTeamMembers() {
        return Stream.of(testMember1, testMember2, testMember3, testMember4, testMember5, testMember6).collect(Collectors.toList());
    }
}
