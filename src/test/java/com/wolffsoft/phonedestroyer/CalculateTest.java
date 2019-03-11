package com.wolffsoft.phonedestroyer;

import com.wolffsoft.phonedestroyer.calculate.Calculate;
import com.wolffsoft.phonedestroyer.model.event.EventHistory;
import com.wolffsoft.phonedestroyer.repository.EventHistoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.wolffsoft.phonedestroyer.helperclass.model.event.elder.ElderHistoryNotDemoted.getEldersHistoryNotKicked;
import static com.wolffsoft.phonedestroyer.helperclass.model.event.elder.ElderHistoryDemoted.getEldersHistoryToKick;
import static com.wolffsoft.phonedestroyer.helperclass.model.event.EventHistoryTestObject.getTestEventHistories;
import static com.wolffsoft.phonedestroyer.helperclass.model.event.member.MemberHistoryNotKicked.getMembersHistoryNotKicked;
import static com.wolffsoft.phonedestroyer.helperclass.model.event.member.MemberHistoryToKick.getMembersHistoryToKick;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculateTest {

    @Mock
    private EventHistoryRepository eventHistoryRepository;

    private Calculate calculate;
    private List<EventHistory> testEventHistories;
    private List<EventHistory> testElderHistoryToKick;
    private List<EventHistory> testElderHistoryNotKicked;
    private List<EventHistory> testMemberHistoryToKick;
    private List<EventHistory> testMemberHistoryNotKicked;

    @Before
    public void setup() {
        testEventHistories = getTestEventHistories();
        testElderHistoryToKick = getEldersHistoryToKick();
        testElderHistoryNotKicked = getEldersHistoryNotKicked();
        testMemberHistoryToKick = getMembersHistoryToKick();
        testMemberHistoryNotKicked = getMembersHistoryNotKicked();
        calculate = new Calculate(eventHistoryRepository);
    }

    // TODO make more test cases for this test. Refactor the test data in such a way it is easier to use.

    @Test
    public void testCalculateMemberToBeKicked() {
        when(eventHistoryRepository.getEventHistories()).thenReturn(testMemberHistoryToKick);

        List<String> memberNames = calculate.kickMembers();

        assertThat(memberNames.size()).isEqualTo(2);
    }

    @Test
    public void testMembersNotKicked() {
        when(eventHistoryRepository.getEventHistories()).thenReturn(testMemberHistoryNotKicked);

        List<String> memberNames = calculate.kickMembers();

        assertThat(memberNames.size()).isEqualTo(0);
    }

    @Test
    public void testMembersKicked() {
        when(eventHistoryRepository.getEventHistories()).thenReturn(testMemberHistoryToKick);

        List<String> memberNames = calculate.kickMembers();

        assertThat(memberNames.size()).isEqualTo(2);
    }

    @Test
    public void testDemoteElderToMember() {
        when(eventHistoryRepository.getEventHistories()).thenReturn(testElderHistoryToKick);

        List<String> memberNames = calculate.calculateEldersToDemote();

        assertThat(memberNames.size()).isEqualTo(2);
    }

    @Test
    public void testNoElderToDemoteToMember() {
        when(eventHistoryRepository.getEventHistories()).thenReturn(testElderHistoryNotKicked);

        List<String> memberNames = calculate.calculateEldersToDemote();

        assertThat(memberNames.size()).isEqualTo(0);
    }
}
