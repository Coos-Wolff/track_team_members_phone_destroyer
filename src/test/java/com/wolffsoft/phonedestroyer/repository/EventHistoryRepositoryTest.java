package com.wolffsoft.phonedestroyer.repository;

import com.wolffsoft.phonedestroyer.configuration.AbstractTestRepository;
import com.wolffsoft.phonedestroyer.model.Event;
import com.wolffsoft.phonedestroyer.model.EventHistory;
import com.wolffsoft.phonedestroyer.model.Member;
import org.jooq.DSLContext;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EventHistoryRepositoryTest extends AbstractTestRepository<EventHistoryRepository> {

    private static final String EVENT_NAME = "Test Event 123456789";
    private static final String MEMBER_NAME = "Member 123456789";
    private static final int TEAM_MEMBER_ID = 123456789;
    private static final int EVENT_ID = 123456789;

    @Override
    protected EventHistoryRepository createRepository(DSLContext dslContext) {
        return new EventHistoryRepository(dslContext);
    }

    @Test
    public void storeEventHistoryByEventName() {
        Member member = Member.builder()
                .id(TEAM_MEMBER_ID)
                .name(MEMBER_NAME)
                .ticketsCollectedCurrentEvent(160)
                .build();

        List<Member> members = Collections.singletonList(member);
        Event event = Event.builder()
                .id(EVENT_ID)
                .name(EVENT_NAME)
                .members(members)
                .build();

        repository.storeEventHistory(member, event);

        List<EventHistory> returnedEventHistories = repository.getEventHistoryByEventName(EVENT_NAME);

        assertThat(returnedEventHistories.size()).isEqualTo(1);
        assertThat(returnedEventHistories.get(0).getMemberName()).isEqualTo(MEMBER_NAME);
    }

    @Test
    public void testGetAllEventHistory() {
        List<EventHistory> eventHistories = repository.getAllEventHistories();

        assertThat(eventHistories.get(0).getId()).isEqualTo(1);
        assertThat(eventHistories.get(0).getMemberId()).isEqualTo(1);
        assertThat(eventHistories.get(0).getEventId()).isEqualTo(1);
        assertThat(eventHistories.get(0).getEventTicketsCollected()).isEqualTo(150);
        assertThat(eventHistories.get(0).getEventName()).isEqualTo("Test Event 1");

        assertThat(eventHistories.get(1).getId()).isEqualTo(2);
        assertThat(eventHistories.get(1).getMemberId()).isEqualTo(1);
        assertThat(eventHistories.get(1).getEventId()).isEqualTo(2);
        assertThat(eventHistories.get(1).getEventTicketsCollected()).isEqualTo(1543);
        assertThat(eventHistories.get(1).getEventName()).isEqualTo("Test Event 2");

        assertThat(eventHistories.get(2).getId()).isEqualTo(3);
        assertThat(eventHistories.get(2).getMemberId()).isEqualTo(2);
        assertThat(eventHistories.get(2).getEventId()).isEqualTo(1);
        assertThat(eventHistories.get(2).getEventTicketsCollected()).isEqualTo(443);
        assertThat(eventHistories.get(2).getEventName()).isEqualTo("Test Event 1");
    }

    @Test
    public void testGetEventHistoryByEventName() {
        String eventName = "Test Event 1";
        List<EventHistory> eventHistories = repository.getEventHistoryByEventName(eventName);

        assertThat(eventHistories.size()).isEqualTo(2);
        assertThat(eventHistories.get(0).getMemberName()).isEqualTo("Member 1");
    }
}
