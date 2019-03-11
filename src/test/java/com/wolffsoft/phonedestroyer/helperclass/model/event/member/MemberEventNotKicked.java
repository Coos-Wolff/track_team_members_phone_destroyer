package com.wolffsoft.phonedestroyer.helperclass.model.event.member;

import com.wolffsoft.phonedestroyer.model.member.Member;
import com.wolffsoft.phonedestroyer.model.event.Event;

import java.util.List;

import static com.wolffsoft.phonedestroyer.helperclass.model.member.MemberNotKicked.getTestMembersNotKicked;
import static com.wolffsoft.phonedestroyer.model.InstantNow.localDateNow;

public class MemberEventNotKicked {

    public static Event memberEventNotKicked1 = getMemberEventNotKicked1();
    public static Event memberEventNotKicked2 = getMemberEventNotKicked2();
    public static List<Member> testMembersNotKicked = getTestMembersNotKicked();

    public static Event getMemberEventNotKicked1() {
        return Event.builder()
                .id(1)
                .name("Test Event 1")
                .eventDate(localDateNow().minusWeeks(1))
                .members(testMembersNotKicked)
                .build();
    }

    public static Event getMemberEventNotKicked2() {
        return Event.builder()
                .id(2)
                .name("Test Event 2")
                .eventDate(localDateNow())
                .members(testMembersNotKicked)
                .build();
    }
}
