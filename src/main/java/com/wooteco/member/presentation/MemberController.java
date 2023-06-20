package com.wooteco.member.presentation;

import com.wooteco.member.business.dto.FollowerRequest;
import com.wooteco.member.business.dto.FollowerResponse;
import com.wooteco.member.business.dto.MemberCreateRequest;
import com.wooteco.member.business.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public Long createMember(@RequestBody MemberCreateRequest memberCreateRequest) {
        return memberService.createMember(memberCreateRequest);
    }

    @PostMapping("/follow")
    @ResponseStatus(HttpStatus.CREATED)
    public void followMember(@RequestBody FollowerRequest followerRequest) {
        memberService.createFollower(followerRequest);
    }

    @DeleteMapping("/follow")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unfollowMember(@RequestBody FollowerRequest followerRequest) {
        memberService.deleteFollower(followerRequest);
    }

    @GetMapping("/followers/{memberId}")
    public FollowerResponse findFollowers(@PathVariable("memberId") Long memberId) {
        return memberService.getFollowers(memberId);
    }
}
