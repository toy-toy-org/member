package com.wooteco.member.business.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class FollowerResponse {

    private List<Long> followerMemberIds;

    public FollowerResponse(List<Long> followerMemberIds) {
        this.followerMemberIds = followerMemberIds;
    }
}
