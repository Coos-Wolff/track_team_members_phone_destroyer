package com.wolffsoft.phonedestroyer.helperclass.model.event.member;

import com.wolffsoft.phonedestroyer.model.event.EventHistory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.wolffsoft.phonedestroyer.helperclass.model.event.member.MemberEventNotKicked.memberEventNotKicked1;
import static com.wolffsoft.phonedestroyer.helperclass.model.event.member.MemberEventNotKicked.memberEventNotKicked2;
import static com.wolffsoft.phonedestroyer.helperclass.model.member.MemberNotKicked.*;

public class MemberHistoryNotKicked {

    public static EventHistory testMemberHistoryNotKicked1 = getTestMemberHistoryNotKicked1();
    public static EventHistory testMemberHistoryNotKicked2 = getTestMemberHistoryNotKicked2();
    public static EventHistory testMemberHistoryNotKicked3 = getTestMemberHistoryNotKicked3();
    public static EventHistory testMemberHistoryNotKicked4 = getTestMemberHistoryNotKicked4();

    private static EventHistory getTestMemberHistoryNotKicked1() {
        return EventHistory.builder()
                .id(1)
                .eventId(memberEventNotKicked1.getId())
                .eventName(memberEventNotKicked1.getName())
                .eventDate(memberEventNotKicked1.getEventDate())
                .memberId(testMemberNotKicked1.getId())
                .memberName(testMemberNotKicked1.getName())
                .dateJoinedTeam(testMemberNotKicked1.getDateJoinedTeam())
                .role(testMemberNotKicked1.getRole())
                .eventTicketsCollected(testMemberNotKicked1.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMemberNotKicked1.getPointsCollectedCurrentEvent())
                .build();
    }
    private static EventHistory getTestMemberHistoryNotKicked2() {
        return EventHistory.builder()
                .id(2)
                .eventId(memberEventNotKicked2.getId())
                .eventName(memberEventNotKicked2.getName())
                .eventDate(memberEventNotKicked2.getEventDate())
                .memberId(testMemberNotKicked2.getId())
                .memberName(testMemberNotKicked2.getName())
                .dateJoinedTeam(testMemberNotKicked2.getDateJoinedTeam())
                .role(testMemberNotKicked2.getRole())
                .eventTicketsCollected(testMemberNotKicked2.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMemberNotKicked2.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestMemberHistoryNotKicked3() {
        return EventHistory.builder()
                .id(3)
                .eventId(memberEventNotKicked1.getId())
                .eventName(memberEventNotKicked1.getName())
                .eventDate(memberEventNotKicked1.getEventDate())
                .memberId(testMemberNotKicked3.getId())
                .memberName(testMemberNotKicked3.getName())
                .dateJoinedTeam(testMemberNotKicked3.getDateJoinedTeam())
                .role(testMemberNotKicked3.getRole())
                .eventTicketsCollected(testMemberNotKicked3.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMemberNotKicked3.getPointsCollectedCurrentEvent())
                .build();
    }

    private static EventHistory getTestMemberHistoryNotKicked4() {
        return EventHistory.builder()
                .id(4)
                .eventId(memberEventNotKicked2.getId())
                .eventName(memberEventNotKicked2.getName())
                .eventDate(memberEventNotKicked2.getEventDate())
                .memberId(testMemberNotKicked4.getId())
                .memberName(testMemberNotKicked4.getName())
                .dateJoinedTeam(testMemberNotKicked4.getDateJoinedTeam())
                .role(testMemberNotKicked4.getRole())
                .eventTicketsCollected(testMemberNotKicked4.getTicketsCollectedCurrentEvent())
                .pointsCollected(testMemberNotKicked4.getPointsCollectedCurrentEvent())
                .build();
    }

    public static List<EventHistory> getMembersHistoryNotKicked() {
        return Stream.of(
                testMemberHistoryNotKicked1,
                testMemberHistoryNotKicked2,
                testMemberHistoryNotKicked3,
                testMemberHistoryNotKicked4
        ).collect(Collectors.toList());
    }
}
