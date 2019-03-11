package com.wolffsoft.phonedestroyer.helperclass.model.member;

import com.wolffsoft.phonedestroyer.model.member.Member;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MemberNotKicked {

    private final static String ROLE_MEMBER = "Member";
    private final static LocalDate SIX_WEEKS_AGO = LocalDate.now().minusWeeks(6);

    public static Member testMemberNotKicked1 = getTestMemberNotKicked1();
    public static Member testMemberNotKicked2 = getTestMemberNotKicked2();
    public static Member testMemberNotKicked3 = getTestMemberNotKicked3();
    public static Member testMemberNotKicked4 = getTestMemberNotKicked4();

    private static Member getTestMemberNotKicked1() {
        return Member.builder()
                .id(123)
                .name("Member Name 1")
                .role(ROLE_MEMBER)
                .dateJoinedTeam(SIX_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(1234)
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    private static Member getTestMemberNotKicked2() {
        return Member.builder()
                .id(234)
                .name("Member Name 2")
                .role(ROLE_MEMBER)
                .dateJoinedTeam(SIX_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(0)
                .pointsCollectedCurrentEvent(56)
                .build();
    }

    private static Member getTestMemberNotKicked3() {
        return Member.builder()
                .id(123)
                .name("Member Name 1")
                .role(ROLE_MEMBER)
                .dateJoinedTeam(SIX_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(1)
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    private static Member getTestMemberNotKicked4() {
        return Member.builder()
                .id(234)
                .name("Member Name 2")
                .role(ROLE_MEMBER)
                .dateJoinedTeam(SIX_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(2)
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    public static List<Member> getTestMembersNotKicked() {
        return Stream.of(
                testMemberNotKicked1,
                testMemberNotKicked2,
                testMemberNotKicked3,
                testMemberNotKicked4
        ).collect(Collectors.toList());
    }
}
