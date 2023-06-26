package com.wooteco.member.business;

import com.wooteco.member.business.dto.FollowerRequest;
import com.wooteco.member.business.dto.FollowerResponse;
import com.wooteco.member.domain.Follow;
import com.wooteco.member.domain.FollowRepository;
import com.wooteco.member.domain.Member;
import com.wooteco.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final MemberRepository memberRepository;
    private final FollowRepository followRepository;

    @Transactional
    public void createFollower(FollowerRequest request) {
        Member following = memberRepository.findById(request.getMemberId()).orElseThrow();
        Member follower = memberRepository.findById(request.getFollowerId()).orElseThrow();
        followRepository.save(new Follow(following, follower));
    }

    @Transactional
    public void deleteFollower(FollowerRequest request) {
        Member following = memberRepository.findById(request.getMemberId()).orElseThrow();
        Member follower = memberRepository.findById(request.getFollowerId()).orElseThrow();
        followRepository.deleteByFollowingAndFollower(follower, follower);
    }

    @Transactional(readOnly = true)
    public FollowerResponse getFollowers(Long memberId) {
        return new FollowerResponse(followRepository.findFollowerIdsByFollowingId(memberId));
    }
}
