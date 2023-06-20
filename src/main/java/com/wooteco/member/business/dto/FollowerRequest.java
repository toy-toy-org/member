package com.wooteco.member.business.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FollowerRequest {

    private Long memberId;
    private Long followerId;
}
