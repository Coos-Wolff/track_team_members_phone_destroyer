package com.wolffsoft.phonedestroyer.helperclass.model.event.member;

import com.wolffsoft.phonedestroyer.model.event.EventHistory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.wolffsoft.phonedestroyer.helperclass.model.event.member.MemberEventToKick.memberEventToKick1;
import static com.wolffsoft.phonedestroyer.helperclass.model.event.member.MemberEventToKick.memberEventToKick2;
import static com.wolffsoft.phonedestroyer.helperclass.model.member.MemberToKick.*;

public class MemberHistoryToKick {

    public static EventHistory testMemberHistoryToKick1 = getTestMemberHistoryToKick1();
    public static EventHistory testMemberHistoryToKick2 = getTestMemberHistoryToKick2();
    public static EventHistory testMemberHistoryToKick3 = getTestMemberHistoryToKick3();
    public static EventHistory testMemberHistoryToKick4 = getTestMemberHistoryToKick4();

    private static EventHistory getTestMemberHistoryToKick1() {
        return EventHistory.builder()
                .id(1)
                .eventId(memberEventToKick1.getId())
                .eventName(memberEventToKick1.getName())
                .eventDate(memberEventToKick1.getEventDate())
                .memberId(testMemberToKick1.getId())
                .memberName(testMemberToKick1.getName())
                .dateJoinedTeam(testMemberToKick1.getDateJoinedTeam())
                .role(testMemberToKick1.getRole())
                .eventTicketsCollected(testMemberToKick1.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMemberToKick1.getPointsCollectedCurrentEvent())
                .build();
    }
    private static EventHistory getTestMemberHistoryToKick2() {
        return EventHistory.builder()
                .id(2)
                .eventId(memberEventToKick2.getId())
                .eventName(memberEventToKick2.getName())
                .eventDate(memberEventToKick2.getEventDate())
                .memberId(testMemberToKick2.getId())
                .memberName(testMemberToKick2.getName())
                .dateJoinedTeam(testMemberToKick2.getDateJoinedTeam())
                .role(testMemberToKick2.getRole())
                .eventTicketsCollected(testMemberToKick2.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMemberToKick2.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestMemberHistoryToKick3() {
        return EventHistory.builder()
                .id(3)
                .eventId(memberEventToKick1.getId())
                .eventName(memberEventToKick1.getName())
                .eventDate(memberEventToKick1.getEventDate())
                .memberId(testMemberToKick3.getId())
                .memberName(testMemberToKick3.getName())
                .dateJoinedTeam(testMemberToKick3.getDateJoinedTeam())
                .role(testMemberToKick3.getRole())
                .eventTicketsCollected(testMemberToKick3.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMemberToKick3.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestMemberHistoryToKick4() {
        return EventHistory.builder()
                .id(4)
                .eventId(memberEventToKick2.getId())
                .eventName(memberEventToKick2.getName())
                .eventDate(memberEventToKick2.getEventDate())
                .memberId(testMemberToKick4.getId())
                .memberName(testMemberToKick4.getName())
                .dateJoinedTeam(testMemberToKick4.getDateJoinedTeam())
                .role(testMemberToKick4.getRole())
                .eventTicketsCollected(testMemberToKick4.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMemberToKick4.getPointsCollectedCurrentEvent())
                .build();
    }

    public static List<EventHistory> getMembersHistoryToKick() {
        return Stream.of(
                testMemberHistoryToKick1,
                testMemberHistoryToKick2,
                testMemberHistoryToKick3,
                testMemberHistoryToKick4
        ).collect(Collectors.toList());
    }
}
