package com.wolffsoft.phonedestroyer.helperclass.model;

import com.wolffsoft.phonedestroyer.model.Member;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MemberTestObject {

    private final static String ROLE_MEMBER = "Member";
    private final static String ROLE_ELDER = "Elder";

    private final static LocalDate ONE_WEEK_AGO = LocalDate.now().minusWeeks(1);
    private final static LocalDate FOUR_WEEKS_AGO = LocalDate.now().minusWeeks(4);
    private final static LocalDate SIX_WEEKS_AGO = LocalDate.now().minusWeeks(6);

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
    public static Member testMember13 = getTestMember13();
    public static Member testMember14 = getTestMember14();
    public static Member testMember15 = getTestMember15();
    public static Member testMember16 = getTestMember16();

    private static Member getTestMember1() {
        return Member.builder()
                .id(123)
                .name("Member Name 1")
                .role(ROLE_ELDER)
                .dateJoinedTeam(SIX_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(151)
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    private static Member getTestMember2() {
        return Member.builder()
                .id(234)
                .name("Member Name 2")
                .role(ROLE_ELDER)
                .dateJoinedTeam(SIX_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(0)
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    private static Member getTestMember3() {
        return Member.builder()
                .id(345)
                .name("Member Name 3")
                .role(ROLE_MEMBER)
                .dateJoinedTeam(FOUR_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(1456)
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    private static Member getTestMember4() {
        return Member.builder()
                .id(456)
                .name("Member Name 4")
                .role(ROLE_MEMBER)
                .dateJoinedTeam(ONE_WEEK_AGO)
                .ticketsCollectedCurrentEvent(1)
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    private static Member getTestMember5() {
        return Member.builder()
                .id(123)
                .name("Member Name 1")
                .role(ROLE_ELDER)
                .dateJoinedTeam(SIX_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(2)
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    private static Member getTestMember6() {
        return Member.builder()
                .id(234)
                .name("Member Name 2")
                .role(ROLE_ELDER)
                .dateJoinedTeam(SIX_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(3)
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    private static Member getTestMember7() {
        return Member.builder()
                .id(345)
                .name("Member Name 3")
                .role(ROLE_MEMBER)
                .dateJoinedTeam(FOUR_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(0)
                .pointsCollectedCurrentEvent(5)
                .build();
    }

    private static Member getTestMember8() {
        return Member.builder()
                .id(567)
                .name("Member Name 5")
                .role(ROLE_MEMBER)
                .dateJoinedTeam(FOUR_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(0)
                .pointsCollectedCurrentEvent(6)
                .build();
    }

    private static Member getTestMember9() {
        return Member.builder()
                .id(123)
                .name("Member Name 1")
                .role(ROLE_ELDER)
                .dateJoinedTeam(SIX_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(0)
                .pointsCollectedCurrentEvent(50)
                .build();
    }

    private static Member getTestMember10() {
        return Member.builder()
                .id(234)
                .name("Member Name 2")
                .role(ROLE_ELDER)
                .dateJoinedTeam(SIX_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(0)
                .pointsCollectedCurrentEvent(1)
                .build();
    }

    private static Member getTestMember11() {
        return Member.builder()
                .id(345)
                .name("Member Name 3")
                .role(ROLE_MEMBER)
                .dateJoinedTeam(FOUR_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(0)
                .pointsCollectedCurrentEvent(16)
                .build();
    }

    private static Member getTestMember12() {
        return Member.builder()
                .id(567)
                .name("Member Name 5")
                .role(ROLE_MEMBER)
                .dateJoinedTeam(FOUR_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(0)
                .pointsCollectedCurrentEvent(2)
                .build();
    }

    private static Member getTestMember13() {
        return Member.builder()
                .id(123)
                .name("Member Name 1")
                .role(ROLE_ELDER)
                .dateJoinedTeam(SIX_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(0)
                .pointsCollectedCurrentEvent(12)
                .build();
    }

    private static Member getTestMember14() {
        return Member.builder()
                .id(234)
                .name("Member Name 2")
                .role(ROLE_ELDER)
                .dateJoinedTeam(SIX_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(0)
                .pointsCollectedCurrentEvent(2)
                .build();
    }

    private static Member getTestMember15() {
        return Member.builder()
                .id(345)
                .name("Member Name 3")
                .role(ROLE_MEMBER)
                .dateJoinedTeam(FOUR_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(0)
                .pointsCollectedCurrentEvent(2)
                .build();
    }

    private static Member getTestMember16() {
        return Member.builder()
                .id(567)
                .name("Member Name 5")
                .role(ROLE_MEMBER)
                .dateJoinedTeam(FOUR_WEEKS_AGO)
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
                testMember12,
                testMember13,
                testMember14,
                testMember15,
                testMember16
                ).collect(Collectors.toList());
    }
}
