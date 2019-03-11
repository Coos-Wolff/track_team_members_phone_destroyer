package com.wolffsoft.phonedestroyer.helperclass.model.member.elder;

import com.wolffsoft.phonedestroyer.model.member.Member;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ElderDemoted {

    private final static String ROLE_ELDER = "Elder";
    private final static LocalDate THREE_WEEKS_AGO = LocalDate.now().minusWeeks(3);

    public static Member testElderDemoted1 = getTestMemberDemoted1();
    public static Member testElderDemoted2 = getTestMemberDemoted2();
    public static Member testElderDemoted3 = getTestMemberDemoted3();
    public static Member testElderDemoted4 = getTestMemberDemoted4();

    private static Member getTestMemberDemoted1() {
        return Member.builder()
                .id(123)
                .name("Member Name 1")
                .role(ROLE_ELDER)
                .dateJoinedTeam(THREE_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(1)
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    private static Member getTestMemberDemoted2() {
        return Member.builder()
                .id(234)
                .name("Member Name 2")
                .role(ROLE_ELDER)
                .dateJoinedTeam(THREE_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(0)
                .pointsCollectedCurrentEvent(1)
                .build();
    }

    private static Member getTestMemberDemoted3() {
        return Member.builder()
                .id(123)
                .name("Member Name 1")
                .role(ROLE_ELDER)
                .dateJoinedTeam(THREE_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(1)
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    private static Member getTestMemberDemoted4() {
        return Member.builder()
                .id(234)
                .name("Member Name 2")
                .role(ROLE_ELDER)
                .dateJoinedTeam(THREE_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(1)
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    public static List<Member> getTestEldersDemoted() {
        return Stream.of(
                testElderDemoted1,
                testElderDemoted2,
                testElderDemoted3,
                testElderDemoted4
        ).collect(Collectors.toList());
    }
}
