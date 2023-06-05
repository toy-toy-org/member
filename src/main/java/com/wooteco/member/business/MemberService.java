package com.wooteco.member.business;

import com.wooteco.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public Long createMember(MemberCreateRequest request) {
        return memberRepository.save(request.toMember()).getId();
    }
}
