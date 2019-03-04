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
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.wolffsoft.phonedestroyer.helperclass.model.EventHistoryTestObject.getTestEventHistories;
import static com.wolffsoft.phonedestroyer.helperclass.model.EventTestObject.*;
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

    @Test
    public void test() {
        List<String> eventNames = Stream.of(
                testEvent4.getName(),
                testEvent3.getName(),
                testEvent2.getName(),
                testEvent1.getName()
        ).collect(Collectors.toList());

        assertThat(eventNames.get(0)).isEqualTo(testEvent4.getName());
    }
}
