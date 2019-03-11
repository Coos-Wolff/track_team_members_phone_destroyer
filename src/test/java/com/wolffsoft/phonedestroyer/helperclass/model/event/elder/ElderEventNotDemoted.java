package com.wolffsoft.phonedestroyer.helperclass.model.event.elder;

import com.wolffsoft.phonedestroyer.model.member.Member;
import com.wolffsoft.phonedestroyer.model.event.Event;

import java.util.List;

import static com.wolffsoft.phonedestroyer.helperclass.model.member.elder.ElderNotDemoted.getTestEldersNotDemoted;
import static com.wolffsoft.phonedestroyer.model.InstantNow.localDateNow;

public class ElderEventNotDemoted {

    public static Event elderEventNotDemoted1 = getElderEventNotDemoted1();
    public static Event elderEventNotDemoted2 = getElderEventNotDemoted2();
    public static List<Member> testEldersNotDemoted = getTestEldersNotDemoted();

    public static Event getElderEventNotDemoted1() {
        return Event.builder()
                .id(1)
                .name("Test Event 1")
                .eventDate(localDateNow().minusWeeks(1))
                .members(testEldersNotDemoted)
                .build();
    }

    public static Event getElderEventNotDemoted2() {
        return Event.builder()
                .id(2)
                .name("Test Event 2")
                .eventDate(localDateNow())
                .members(testEldersNotDemoted)
                .build();
    }
}
