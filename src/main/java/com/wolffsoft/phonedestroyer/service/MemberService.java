package com.wolffsoft.phonedestroyer.service;

import com.wolffsoft.phonedestroyer.model.Member;
import com.wolffsoft.phonedestroyer.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getMembersByEvent(String eventName) {
        return memberRepository.getMembersByEventName(eventName);
    }

    public void setTicketsCollected(Member member) {
        memberRepository.setTicketsCollected(member);
    }
}
