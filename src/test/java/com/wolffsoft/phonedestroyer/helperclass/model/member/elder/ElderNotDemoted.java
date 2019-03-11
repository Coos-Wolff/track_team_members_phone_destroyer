package com.wolffsoft.phonedestroyer.helperclass.model.member.elder;

import com.wolffsoft.phonedestroyer.model.member.Member;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ElderNotDemoted {

    private final static String ROLE_ELDER = "Elder";
    private final static LocalDate SIX_WEEKS_AGO = LocalDate.now().minusWeeks(6);

    public static Member testElderNotKicked1 = getTestElderNotKicked1();
    public static Member testElderNotKicked2 = getTestElderNotKicked2();
    public static Member testElderNotKicked3 = getTestElderNotKicked3();
    public static Member testElderNotKicked4 = getTestElderNotKicked4();

    private static Member getTestElderNotKicked1() {
        return Member.builder()
                .id(123)
                .name("Member Name 1")
                .role(ROLE_ELDER)
                .dateJoinedTeam(SIX_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(1234)
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    private static Member getTestElderNotKicked2() {
        return Member.builder()
                .id(234)
                .name("Member Name 2")
                .role(ROLE_ELDER)
                .dateJoinedTeam(SIX_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(0)
                .pointsCollectedCurrentEvent(56)
                .build();
    }

    private static Member getTestElderNotKicked3() {
        return Member.builder()
                .id(123)
                .name("Member Name 1")
                .role(ROLE_ELDER)
                .dateJoinedTeam(SIX_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(1)
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    private static Member getTestElderNotKicked4() {
        return Member.builder()
                .id(234)
                .name("Member Name 2")
                .role(ROLE_ELDER)
                .dateJoinedTeam(SIX_WEEKS_AGO)
                .ticketsCollectedCurrentEvent(2)
                .pointsCollectedCurrentEvent(0)
                .build();
    }

    public static List<Member> getTestEldersNotDemoted() {
        return Stream.of(
                testElderNotKicked1,
                testElderNotKicked2,
                testElderNotKicked3,
                testElderNotKicked4
        ).collect(Collectors.toList());
    }
}
