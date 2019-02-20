package com.wolffsoft.phonedestroyer.service;

import com.wolffsoft.phonedestroyer.model.Member;
import com.wolffsoft.phonedestroyer.repository.MemberRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static com.wolffsoft.phonedestroyer.helperclass.model.MemberTestObject.getTestTeamMembers;
import static com.wolffsoft.phonedestroyer.helperclass.model.MemberTestObject.testMember1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest {

    private static final String EVENT_NAME = "Test Event 1";

    private List<Member> members;
    private Member member1;

    @Mock
    private MemberRepository memberRepository;

    private MemberService memberService;

    @Before
    public void setup() {
        memberService = new MemberService(memberRepository);
        members = getTestTeamMembers();
        member1 = testMember1;
    }

    @Test
    public void testAddMember() {
        ArgumentCaptor<Member> argumentCaptor = ArgumentCaptor.forClass(Member.class);

        memberService.addMember(member1);

        verify(memberRepository, times(1)).addMember(argumentCaptor.capture());

        Member capturedMember = argumentCaptor.getValue();

        assertThat(capturedMember).isEqualTo(member1);
    }

    @Test
    public void testGetMembersByEvent() {
        when(memberRepository.getMembersByEventName(EVENT_NAME)).thenReturn(members);

        List<Member> returnedMembers = memberService.getMembersByEventName(EVENT_NAME);

        assertThat(returnedMembers).isEqualTo(members);
    }

    @Test
    public void testSetTicketsCollected() {
        ArgumentCaptor<Member> argumentCaptor = ArgumentCaptor.forClass(Member.class);

        members.forEach(member -> memberService.setTicketsCollected(member));

        verify(memberRepository, times(3)).setTicketsCollected(argumentCaptor.capture());

        List<Member> capturedMembers = argumentCaptor.getAllValues();

        assertThat(capturedMembers).isEqualTo(members);
    }

    @Test
    public void testDeleteMember() {
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        memberService.deleteMemberByName(member1.getName());

        verify(memberRepository).deleteMemberByName(argumentCaptor.capture());

        String capturedMemberName = argumentCaptor.getValue();

        assertThat(capturedMemberName).isEqualTo(member1.getName());
    }
}
