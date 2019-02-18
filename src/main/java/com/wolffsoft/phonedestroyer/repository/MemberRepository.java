package com.wolffsoft.phonedestroyer.repository;

import com.wolffsoft.phonedestroyer.model.Member;
import com.wolffsoft.phonedestroyer.repository.mapper.OptionalMemberMapper;
import com.wolffsoft.phonedestroyer.repository.mapper.MemberMapper;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.wolffsoft.phonedestroyer.persistance.repositories.jooq.Tables.*;

@Repository
public class MemberRepository {

    private DSLContext dslContext;
    private OptionalMemberMapper optionalMemberMapper;
    private MemberMapper memberMapper;

    public MemberRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
        this.optionalMemberMapper = new OptionalMemberMapper();
        this.memberMapper = new MemberMapper();
    }

    public int addMember(Member member) {
        return dslContext
                .insertInto(MEMBER, MEMBER.NAME, MEMBER.DATE_JOINED)
                .values(member.getName(), member.getJoinedTeam())
                .execute();
    }

    public void addMembers(List<Member> members) {
        members.forEach(this::addMember);
    }

    public Optional<Member> getMemberByName(String name) {
        return dslContext
                .select()
                .from(MEMBER)
                .where(MEMBER.NAME.eq(name))
                .fetchOne(optionalMemberMapper);
    }

    public List<Member> getAllMembers() {
        return dslContext
                .select()
                .from(MEMBER)
                .fetch(memberMapper);
    }

    public void deleteMemberByName(String name) {
        dslContext
                .deleteFrom(MEMBER)
                .where(MEMBER.NAME.eq(name))
                .execute();
    }

    public void deleteMembersByName(List<Member> members) {
        members.forEach(teamMember -> deleteMemberByName(teamMember.getName()));
    }

    public List<Member> getMembersByEventName(String eventName) {
        return dslContext
                .select()
                .from(MEMBER)
                .join(EVENT_MEMBER)
                .on(MEMBER.ID.eq(EVENT_MEMBER.MEMBER_ID))
                .join(EVENT)
                .on(EVENT.ID.eq(EVENT_MEMBER.EVENT_ID))
                .where(EVENT.NAME.eq(eventName))
                .orderBy(MEMBER.ID)
                .fetch(memberMapper);
    }

    public void setTicketsToZero(Member member) {
        dslContext
                .update(MEMBER)
                .set(MEMBER.TICKETS_COLLECTED_CURRENT_EVENT, 0)
                .where(MEMBER.ID.eq(member.getId()));
    }
}