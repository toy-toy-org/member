package com.wooteco.member.business.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberCreateEvent {

    private String email;

    public MemberCreateEvent(String email) {
        this.email = email;
    }
}
