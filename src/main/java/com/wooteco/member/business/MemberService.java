package com.wooteco.member.business;

import com.wooteco.member.business.dto.MemberCreateEvent;
import com.wooteco.member.business.dto.MemberCreateRequest;
import com.wooteco.member.domain.Member;
import com.wooteco.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final ApplicationEventPublisher eventPublisher;

    public Long createMember(MemberCreateRequest request) {
        Member member = memberRepository.save(request.toMember());
        eventPublisher.publishEvent(new MemberCreateEvent(member.getName(), member.getEmail()));
        return member.getId();
    }
}
