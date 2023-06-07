package com.wooteco.member.presentation;

import com.wooteco.member.business.dto.MemberCreateRequest;
import com.wooteco.member.business.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public Long createMember(@RequestBody MemberCreateRequest memberCreateRequest) {
        return memberService.createMember(memberCreateRequest);
    }
}
