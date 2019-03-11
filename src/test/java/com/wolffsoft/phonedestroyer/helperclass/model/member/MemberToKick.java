package com.wolffsoft.phonedestroyer.helperclass.model.member;

import com.wolffsoft.phonedestroyer.model.member.Member;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MemberToKick {

    private final static String ROLE_MEMBER = "Member";
    private final static LocalDate THREE_WEEKS_AGO = LocalDate.now().minusWeeks(3);

    public static Member testMemberToKick1 = getTestMemberToKick1();
    public static Member testMemberToKick2 = getTestMemberToKick2();
    public static Member testMemberToKick3 = getTestMemberToKick3();
    public static Member testMemberToKick4 = getTestMemberToKick4();

    private static Member getTestMemberToKick1() {
        return Member.builder()
                .id(123)
                .name("Member Name 1")
                .role(ROLE_MEMBER)
                .dateJoinedTeam(THREE_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(1)
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    private static Member getTestMemberToKick2() {
        return Member.builder()
                .id(234)
                .name("Member Name 2")
                .role(ROLE_MEMBER)
                .dateJoinedTeam(THREE_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(0)
                .pointsCollectedCurrentEvent(1)
                .build();
    }

    private static Member getTestMemberToKick3() {
        return Member.builder()
                .id(123)
                .name("Member Name 1")
                .role(ROLE_MEMBER)
                .dateJoinedTeam(THREE_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(1)
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    private static Member getTestMemberToKick4() {
        return Member.builder()
                .id(234)
                .name("Member Name 2")
                .role(ROLE_MEMBER)
                .dateJoinedTeam(THREE_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(1)
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    public static List<Member> getTestMembersToKick() {
        return Stream.of(
                testMemberToKick1,
                testMemberToKick2,
                testMemberToKick3,
                testMemberToKick4
        ).collect(Collectors.toList());
    }
}
