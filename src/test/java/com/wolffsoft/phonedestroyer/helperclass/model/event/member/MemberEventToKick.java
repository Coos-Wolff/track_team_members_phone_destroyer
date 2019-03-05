package com.wolffsoft.phonedestroyer.helperclass.model.event.member;

import com.wolffsoft.phonedestroyer.model.Member;
import com.wolffsoft.phonedestroyer.model.event.Event;

import java.util.List;

import static com.wolffsoft.phonedestroyer.helperclass.model.member.MemberToKick.getTestMembersToKick;
import static com.wolffsoft.phonedestroyer.model.InstantNow.localDateNow;

public class MemberEventToKick {

    public static Event memberEventToKick1 = getMemberEventToKick1();
    public static Event memberEventToKick2 = getMemberEventToKick2();
    public static List<Member> testMembersToKick = getTestMembersToKick();

    public static Event getMemberEventToKick1() {
        return Event.builder()
                .id(1)
                .name("Test Event 1")
                .eventDate(localDateNow().minusWeeks(1))
                .members(testMembersToKick)
                .build();
    }

    public static Event getMemberEventToKick2() {
        return Event.builder()
                .id(2)
                .name("Test Event 2")
                .eventDate(localDateNow())
                .members(testMembersToKick)
                .build();
    }
}
