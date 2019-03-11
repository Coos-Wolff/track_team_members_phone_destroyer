package com.wolffsoft.phonedestroyer.service;

import com.wolffsoft.phonedestroyer.model.member.Member;
import com.wolffsoft.phonedestroyer.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void addMember(Member member) {
        memberRepository.addMember(member);
    }

    public List<Member> getMembersByEventName(String eventName) {
        return memberRepository.getMembersByEventName(eventName);
    }

    public void setTicketsCollected(Member member) {
        memberRepository.setTicketsCollected(member);
    }

    public void deleteMemberByName(String memberName) {
        memberRepository.deleteMemberByName(memberName);
    }

    public void deleteMemberById(int id) {
        memberRepository.deleteMemberById(id);
    }

    public void kickMember(List<String> members) {
        members.forEach(member -> memberRepository.deleteMemberByName(member));
    }
}
