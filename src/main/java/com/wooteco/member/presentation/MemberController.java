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
}
