package com.wooteco.member.business;

import com.wooteco.member.business.dto.FollowerRequest;
import com.wooteco.member.business.dto.FollowerResponse;
import com.wooteco.member.domain.Follow;
import com.wooteco.member.domain.FollowRepository;
import com.wooteco.member.domain.Member;
import com.wooteco.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final MemberRepository memberRepository;
    private final FollowRepository followRepository;

    public void createFollower(FollowerRequest request) {
        Member following = memberRepository.findById(request.getMemberId()).orElseThrow();
        Member follower = memberRepository.findById(request.getFollowerId()).orElseThrow();
        followRepository.save(new Follow(following, follower));
    }

    public void deleteFollower(FollowerRequest request) {
        Member following = memberRepository.findById(request.getMemberId()).orElseThrow();
        Member follower = memberRepository.findById(request.getFollowerId()).orElseThrow();
        followRepository.deleteByFollowingAndFollower(follower, follower);
    }

    public FollowerResponse getFollowers(Long memberId) {
        return new FollowerResponse(followRepository.findFollowerIdsByFollowingId(memberId));
    }
}
