package com.wolffsoft.phonedestroyer.service;

import com.wolffsoft.phonedestroyer.model.Member;
import com.wolffsoft.phonedestroyer.repository.MemberRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.wolffsoft.phonedestroyer.helperclass.model.MemberTestObject.getTestTeamMembers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest {

    private static final String EVENT_NAME = "Test Event 1";

    private List<Member> members;

    @Mock
    private MemberRepository memberRepository;

    private MemberService memberService;

    @Before
    public void setup() {
        memberService = new MemberService(memberRepository);
        members = getTestTeamMembers();
    }

    @Test
    public void testGetMembersByEvent() {
        when(memberRepository.getMembersByEventName(EVENT_NAME)).thenReturn(members);

        List<Member> returnedMembers = memberService.getMembersByEvent(EVENT_NAME);

        assertThat(returnedMembers).isEqualTo(members);
    }

    @Test
    public void testUpdateTickets() {
        when(memberRepository.getMembersByEventName(EVENT_NAME)).thenReturn(members);

        Member member1;
        Member member2;
        Member member3;

        member1 = Member.builder()
                .id(members.get(0).getId())
                .ticketsCollectedCurrentEvent(1)
                .build();
        member2 = Member.builder()
                .id(members.get(1).getId())
                .ticketsCollectedCurrentEvent(2)
                .build();
        member3 = Member.builder()
                .id(members.get(0).getId())
                .ticketsCollectedCurrentEvent(3)
                .build();

        List<Member> updatedMembers = Stream.of(member1, member2, member3).collect(Collectors.toList());

        when(memberRepository.getMembersByEventName(EVENT_NAME)).thenReturn(updatedMembers);

        updatedMembers.forEach(member -> memberService.setTicketsCollected(member));
        List<Member> returnedMembers = memberService.getMembersByEvent(EVENT_NAME);

        assertThat(returnedMembers.get(0).getTicketsCollectedCurrentEvent()).isEqualTo(1);
        assertThat(returnedMembers.get(1).getTicketsCollectedCurrentEvent()).isEqualTo(2);
        assertThat(returnedMembers.get(2).getTicketsCollectedCurrentEvent()).isEqualTo(3);
    }
}
