package com.wolffsoft.phonedestroyer.repository;

import com.wolffsoft.phonedestroyer.configuration.AbstractTestRepository;
import com.wolffsoft.phonedestroyer.model.member.Member;
import org.jooq.DSLContext;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
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
                .dateJoinedTeam(LocalDate.of(2019, 1, 1))
                .pointsCollectedCurrentEvent(111)
                .build();

        member14 = Member.builder()
                .id(14)
                .name("Team Member 14")
                .dateJoinedTeam(LocalDate.of(2019, 1, 1))
                .pointsCollectedCurrentEvent(333)
                .build();
    }

    @Test
    public void testAddMember() {
        int addedTeamMember = repository.addMember(member13);

        assertThat(addedTeamMember).isEqualTo(1);

        Optional<Member> addedMember = repository.getMemberByName(member13.getName());

        assertThat(addedMember.get().getName()).isEqualTo(member13.getName());
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
        List<Member> members = repository.getMembers();

        assertThat(members.size()).isEqualTo(14);
        assertThat(members.get(0).getId()).isEqualTo(1);
        assertThat(members.get(0).getName()).isEqualTo(MEMBER_NAME_1);
        assertThat(members.get(0).getTicketsCollectedCurrentEvent()).isEqualTo(150);
        assertThat(members.get(0).getDateJoinedTeam()).isEqualTo("2019-01-01");
        assertThat(members.get(1).getId()).isEqualTo(2);
        assertThat(members.get(1).getName()).isEqualTo(MEMBER_NAME_2);
        assertThat(members.get(1).getTicketsCollectedCurrentEvent()).isEqualTo(123);
        assertThat(members.get(1).getDateJoinedTeam()).isEqualTo("2019-02-02");
    }

    @Test
    public void testDeleteMemberByName() {
        int addedTeamMember = repository.addMember(member13);

        assertThat(addedTeamMember).isEqualTo(1);

        String name = member13.getName();
        repository.deleteMemberByName(name);

        Optional<Member> deletedTeamMember = repository.getMemberByName(name);
        assertThat(deletedTeamMember).isNull();
    }

    @Test
    public void testDeleteMembers() {
        List<Member> members = Stream.of(member13, member14).collect(Collectors.toList());

        repository.addMembers(members);
        List<Member> allMembers = repository.getMembers();

        assertThat(allMembers.size()).isEqualTo(16);

        repository.deleteMembersByName(members);

        allMembers = repository.getMembers();
        assertThat(allMembers.size()).isEqualTo(14);
    }

    @Test
    public void testGetTeamMembersByEventName() {
        String eventName = "Test Event 2";
        List<Member> members = repository.getMembersByEventName(eventName);

        assertThat(members.get(0).getName()).isEqualTo(MEMBER_NAME_1);
        assertThat(members.get(0).getTicketsCollectedCurrentEvent()).isEqualTo(150);
        assertThat(members.get(0).getDateJoinedTeam()).isEqualTo("2019-01-01");
        assertThat(members.get(1).getName()).isEqualTo(MEMBER_NAME_2);
        assertThat(members.get(1).getTicketsCollectedCurrentEvent()).isEqualTo(123);
        assertThat(members.get(1).getDateJoinedTeam()).isEqualTo("2019-02-02");
    }

    @Test
    public void testSetTicketsCollectedCurrentEventToZero() {
        repository.addMember(member13);
        repository.setTicketsAndPointsToZero(member13);

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
                .dateJoinedTeam(LocalDate.of(2019, 1, 1))
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

    @Test
    public void testUpdatePointsCollected() {
        String name = "Member 100";
        Member member = repository.getMemberByName(name).get();

        assertThat(member.getPointsCollectedCurrentEvent()).isEqualTo(61);

        member = Member.builder()
                .id(100)
                .name(name)
                .dateJoinedTeam(LocalDate.of(2019, 2, 1))
                .ticketsCollectedCurrentEvent(0)
                .pointsCollectedCurrentEvent(123)
                .build();

        repository.setPointsCollected(member);

        Optional<Member> returnedMember = repository.getMemberByName(member.getName());

        assertThat(returnedMember.get().getPointsCollectedCurrentEvent()).isEqualTo(123);

        member = Member.builder()
                .id(100)
                .name(name)
                .pointsCollectedCurrentEvent(61)
                .build();

        repository.setPointsCollected(member);

        returnedMember = repository.getMemberByName(member.getName());

        assertThat(returnedMember.get().getPointsCollectedCurrentEvent()).isEqualTo(61);
    }
}
