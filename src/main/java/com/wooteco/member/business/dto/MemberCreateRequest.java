package com.wooteco.member.business.dto;

import com.wooteco.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberCreateRequest {

    private String name;
    private String email;

    public Member toMember() {
        return Member.builder().name(this.name).email(this.email).build();
    }
}
