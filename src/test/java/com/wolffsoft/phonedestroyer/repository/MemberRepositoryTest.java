package com.wolffsoft.phonedestroyer.repository;

import com.wolffsoft.phonedestroyer.configuration.AbstractTestRepository;
import com.wolffsoft.phonedestroyer.model.Member;
import org.jooq.DSLContext;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberRepositoryTest extends AbstractTestRepository<MemberRepository> {

    private static final String MEMBER_NAME_1 = "Member 1";
    private static final String MEMBER_NAME_2 = "Member 2";
    private Member member13;
    private Member member14;

    @Override
    protected MemberRepository createRepository(DSLContext dslContext) {
        return new MemberRepository(dslContext);
    }

    @Before
    public void setup() {
        member13 = Member.builder()
                .id(13)
                .name("Team Member 13")
                .joinedTeam("01-01-2019")
                .pointsCollectedCurrentEvent(111)
                .build();

        member14 = Member.builder()
                .id(14)
                .name("Team Member 14")
                .joinedTeam("01-01-2019")
                .pointsCollectedCurrentEvent(333)
                .build();
    }

    @Test
    public void testAddMember() {
        int addedTeamMember = repository.addMember(member13);

        assertThat(addedTeamMember).isEqualTo(1);
    }

    @Test
    public void testAddMembers() {
        List<Member> members = Stream.of(member13, member14).collect(Collectors.toList());

        repository.addMembers(members);

        Optional<Member> addedTeamMember1 = repository.getMemberByName(member13.getName());
        Optional<Member> addedTeamMember2 = repository.getMemberByName(member14.getName());

        assertThat(addedTeamMember1.get().getName()).isEqualTo(member13.getName());
        assertThat(addedTeamMember2.get().getName()).isEqualTo(member14.getName());

        repository.deleteMembersByName(members);
    }

    @Test
    public void testGetTeamMemberByName() {
        String name = "Member 1";

        Optional<Member> returnedTeamMember = repository.getMemberByName(name);

        assertThat(returnedTeamMember.get().getName()).isEqualTo(name);
    }

    @Test
    public void testGetAllTeamMembers() {
        List<Member> members = repository.getAllMembers();

        assertThat(members.size()).isEqualTo(13);
        assertThat(members.get(0).getId()).isEqualTo(1);
        assertThat(members.get(0).getName()).isEqualTo(MEMBER_NAME_1);
        assertThat(members.get(0).getTicketsCollectedCurrentEvent()).isEqualTo(150);
        assertThat(members.get(0).getJoinedTeam()).isEqualTo("01-01-2019");
        assertThat(members.get(1).getId()).isEqualTo(2);
        assertThat(members.get(1).getName()).isEqualTo(MEMBER_NAME_2);
        assertThat(members.get(1).getTicketsCollectedCurrentEvent()).isEqualTo(123);
        assertThat(members.get(1).getJoinedTeam()).isEqualTo("02-02-2019");
    }

    @Test
    public void testDeleteTeamMember() {
        int addedTeamMember = repository.addMember(member13);

        assertThat(addedTeamMember).isEqualTo(1);

        String name = member13.getName();
        repository.deleteMemberByName(name);

        Optional<Member> deletedTeamMember = repository.getMemberByName(name);
        assertThat(deletedTeamMember).isNull();
    }

    @Test
    public void testDeleteTeamMembers() {
        List<Member> members = Stream.of(member13, member14).collect(Collectors.toList());

        repository.addMembers(members);
        List<Member> allMembers = repository.getAllMembers();

        assertThat(allMembers.size()).isEqualTo(15);

        repository.deleteMembersByName(members);

        allMembers = repository.getAllMembers();
        assertThat(allMembers.size()).isEqualTo(13);
    }

    @Test
    public void testGetTeamMembersByEventName() {
        String eventName = "Test Event 2";
        List<Member> members = repository.getMembersByEventName(eventName);

        assertThat(members.get(0).getName()).isEqualTo(MEMBER_NAME_1);
        assertThat(members.get(0).getTicketsCollectedCurrentEvent()).isEqualTo(150);
        assertThat(members.get(0).getJoinedTeam()).isEqualTo("01-01-2019");
        assertThat(members.get(1).getName()).isEqualTo(MEMBER_NAME_2);
        assertThat(members.get(1).getTicketsCollectedCurrentEvent()).isEqualTo(123);
        assertThat(members.get(1).getJoinedTeam()).isEqualTo("02-02-2019");
    }

    @Test
    public void testSetTicketsCollectedCurrentEventToZero() {
        repository.addMember(member13);
        repository.setTicketsToZero(member13);

        Optional<Member> returnedTeamMember13 = repository.getMemberByName(member13.getName());

        assertThat(returnedTeamMember13.get().getTicketsCollectedCurrentEvent()).isEqualTo(0);

        repository.deleteMemberByName(member13.getName());

        Optional<Member> deletedTeamMember13 = repository.getMemberByName(member13.getName());

        assertThat(deletedTeamMember13).isNull();
    }

    @Test
    public void testUpdateTicketsCollected() {
        String name = "Member 1";
        Member member = repository.getMemberByName(name).get();

        assertThat(member.getTicketsCollectedCurrentEvent()).isEqualTo(150);

        member = Member.builder()
                .id(1)
                .name(name)
                .joinedTeam("01-01-2019")
                .ticketsCollectedCurrentEvent(190)
                .build();

        repository.setTicketsCollected(member);

        Optional<Member> returnedMember = repository.getMemberByName(member.getName());

        assertThat(returnedMember.get().getTicketsCollectedCurrentEvent()).isEqualTo(190);

        member = Member.builder()
                .id(1)
                .name(name)
                .ticketsCollectedCurrentEvent(150)
                .build();

        repository.setTicketsCollected(member);

        returnedMember = repository.getMemberByName(member.getName());

        assertThat(returnedMember.get().getTicketsCollectedCurrentEvent()).isEqualTo(150);
    }
}
