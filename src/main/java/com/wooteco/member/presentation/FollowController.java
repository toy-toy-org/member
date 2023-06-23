package com.wooteco.member.presentation;

import com.wooteco.member.business.FollowService;
import com.wooteco.member.business.dto.FollowerRequest;
import com.wooteco.member.business.dto.FollowerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class FollowController {

    private final FollowService followService;

    @PostMapping("/follow")
    @ResponseStatus(HttpStatus.CREATED)
    public void followMember(@RequestBody FollowerRequest followerRequest) {
        followService.createFollower(followerRequest);
    }

    @DeleteMapping("/follow")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unfollowMember(@RequestBody FollowerRequest followerRequest) {
        followService.deleteFollower(followerRequest);
    }

    @GetMapping("/followers/{memberId}")
    public FollowerResponse findFollowers(@PathVariable("memberId") Long memberId) {
        return followService.getFollowers(memberId);
    }
}
