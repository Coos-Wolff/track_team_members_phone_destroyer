package com.wolffsoft.phonedestroyer.helperclass.model.event.elder;

import com.wolffsoft.phonedestroyer.model.member.Member;
import com.wolffsoft.phonedestroyer.model.event.Event;

import java.util.List;

import static com.wolffsoft.phonedestroyer.helperclass.model.member.elder.ElderDemoted.getTestEldersDemoted;
import static com.wolffsoft.phonedestroyer.model.InstantNow.localDateNow;

public class ElderEventDemoted {

    public static Event elderEventDemoted1 = getElderEventDemoted1();
    public static Event elderEventDemoted2 = getElderEventDemoted2();
    public static List<Member> testEldersDemoted = getTestEldersDemoted();

    public static Event getElderEventDemoted1() {
        return Event.builder()
                .id(1)
                .name("Test Event 1")
                .eventDate(localDateNow().minusWeeks(1))
                .members(testEldersDemoted)
                .build();
    }

    public static Event getElderEventDemoted2() {
        return Event.builder()
                .id(2)
                .name("Test Event 2")
                .eventDate(localDateNow())
                .members(testEldersDemoted)
                .build();
    }
}
