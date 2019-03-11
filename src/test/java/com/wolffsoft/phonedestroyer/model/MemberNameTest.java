package com.wolffsoft.phonedestroyer.model;

import com.wolffsoft.phonedestroyer.model.member.MemberName;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberNameTest {

    private static final String NAME = "Test Name";
    private MemberName testMemberName;

    @Before
    public void setup() {
        testMemberName = MemberName.builder()
                .name(NAME)
                .build();
    }

    @Test
    public void testMemberName() {
        MemberName memberName = MemberName.builder()
                .name(NAME)
                .build();

        assertThat(memberName).isEqualTo(testMemberName);
    }
}
