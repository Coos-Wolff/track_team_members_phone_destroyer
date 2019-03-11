package com.wolffsoft.phonedestroyer.model.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class MemberName {

    private String name;
}
