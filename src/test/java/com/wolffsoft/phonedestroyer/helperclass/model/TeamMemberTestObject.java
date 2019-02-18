package com.wolffsoft.phonedestroyer.helperclass.model;

import com.wolffsoft.phonedestroyer.model.Member;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TeamMemberTestObject {

    public static Member testMember1 = getTestMember1();
    public static Member testMember2 = getTestMember2();
    public static Member testMember3 = getTestMember3();

    private static Member getTestMember1() {
        return Member.builder()
                .id(123)
                .name("Team Member Name 1")
                .ticketsCollectedCurrentEvent(150)
                .build();
    }

    private static Member getTestMember2() {
        return Member.builder()
                .id(234)
                .name("Team Member Name 2")
                .ticketsCollectedCurrentEvent(12)
                .build();
    }

    private static Member getTestMember3() {
        return Member.builder()
                .id(345)
                .name("Team Member Name 3")
                .ticketsCollectedCurrentEvent(1456)
                .build();
    }

    public static List<Member> getTestTeamMembers() {
        return Stream.of(testMember1, testMember2, testMember3).collect(Collectors.toList());
    }
}
