package com.wolffsoft.phonedestroyer;

import com.wolffsoft.phonedestroyer.calculate.Calculate;
import com.wolffsoft.phonedestroyer.model.EventHistory;
import com.wolffsoft.phonedestroyer.repository.EventHistoryRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.wolffsoft.phonedestroyer.helperclass.model.EventHistoryTestObject.getTestEventHistories;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculateTest {

    @Mock
    private EventHistoryRepository eventHistoryRepository;

    private Calculate calculate;
    private List<EventHistory> testEventHistories;

    @Before
    public void setup() {
        testEventHistories = getTestEventHistories();
        calculate = new Calculate(eventHistoryRepository);
    }

    @Test
    public void testCalculateMembersToBeKicked() {
        when(eventHistoryRepository.getEventHistories()).thenReturn(testEventHistories);

        List<String> memberNames = calculate.membersToBeKicked();

        assertThat(memberNames.size()).isEqualTo(3);
    }

    @Test
    public void testGetEventHistoryFromLastFourEvents() {
        when(eventHistoryRepository.getEventHistories()).thenReturn(testEventHistories);

        List<EventHistory> returnedEventHistories = calculate.getEventHistoryLastFourEvents();

        assertThat(returnedEventHistories.size()).isEqualTo(16);
    }
}
