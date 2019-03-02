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
    public static Member testMember7 = getTestMember7();
    public static Member testMember8 = getTestMember8();
    public static Member testMember9 = getTestMember9();
    public static Member testMember10 = getTestMember10();
    public static Member testMember11 = getTestMember11();
    public static Member testMember12 = getTestMember12();

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
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    private static Member getTestMember7() {
        return Member.builder()
                .id(678)
                .name("Member Name 4")
                .ticketsCollectedCurrentEvent(0)
                .pointsCollectedCurrentEvent(5)
                .build();
    }

    private static Member getTestMember8() {
        return Member.builder()
                .id(789)
                .name("Member Name 5")
                .ticketsCollectedCurrentEvent(0)
                .pointsCollectedCurrentEvent(6)
                .build();
    }

    private static Member getTestMember9() {
        return Member.builder()
                .id(890)
                .name("Member Name 6")
                .ticketsCollectedCurrentEvent(0)
                .pointsCollectedCurrentEvent(50)
                .build();
    }

    private static Member getTestMember10() {
        return Member.builder()
                .id(678)
                .name("Member Name 4")
                .ticketsCollectedCurrentEvent(0)
                .pointsCollectedCurrentEvent(1)
                .build();
    }

    private static Member getTestMember11() {
        return Member.builder()
                .id(789)
                .name("Member Name 5")
                .ticketsCollectedCurrentEvent(0)
                .pointsCollectedCurrentEvent(1)
                .build();
    }

    private static Member getTestMember12() {
        return Member.builder()
                .id(890)
                .name("Member Name 6")
                .ticketsCollectedCurrentEvent(0)
                .pointsCollectedCurrentEvent(2)
                .build();
    }

    public static List<Member> getTestTeamMembers() {
        return Stream.of(
                testMember1,
                testMember2,
                testMember3,
                testMember4,
                testMember5,
                testMember6,
                testMember7,
                testMember8,
                testMember9,
                testMember10,
                testMember11,
                testMember12).collect(Collectors.toList());
    }
}
