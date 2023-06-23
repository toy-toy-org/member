package com.wooteco.member.business;

import com.wooteco.member.business.client.MailOpenFeign;
import com.wooteco.member.business.dto.MailSendRequest;
import com.wooteco.member.business.dto.MemberCreateRequest;
import com.wooteco.member.domain.Member;
import com.wooteco.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MailOpenFeign mailOpenFeign;

    public Long createMember(MemberCreateRequest request) {
        Member member = memberRepository.save(request.toMember());
        mailOpenFeign.sendMail(new MailSendRequest(member.getEmail(), "만나서", "반갑습니다"));
        return member.getId();
    }
}
