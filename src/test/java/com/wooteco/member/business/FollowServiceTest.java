package com.wooteco.member.business;

import com.wooteco.member.business.dto.FollowerRequest;
import com.wooteco.member.business.dto.FollowerResponse;
import com.wooteco.member.domain.Follow;
import com.wooteco.member.domain.FollowRepository;
import com.wooteco.member.domain.Member;
import com.wooteco.member.domain.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@Import(FollowService.class)
class FollowServiceTest {


    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private FollowService followService;

    private Member eden;
    private Member nede;

    @BeforeEach
    void setup() {
        eden = memberRepository.save(new Member("eden", "eden@email"));
        nede = memberRepository.save(new Member("nede", "nede@email"));
        followRepository.save(new Follow(eden, nede));
    }

    @Test
    void 팔로우를_추가한다() {
        Member member = memberRepository.save(new Member("eedd", "email"));
        FollowerRequest request = new FollowerRequest(eden.getId(), member.getId());
        assertDoesNotThrow(() -> followService.createFollower(request));
    }

    @Test
    void 팔로우할_때_잘못된_팔로워_id면_예외를_발생한다() {
        FollowerRequest request = new FollowerRequest(eden.getId(), -1L);
        assertThrows(NoSuchElementException.class, () -> followService.createFollower(request));
    }

    @Test
    void 팔로우를_취소한다() {
        FollowerRequest request = new FollowerRequest(eden.getId(), nede.getId());
        assertDoesNotThrow(() -> followService.deleteFollower(request));
    }

    @Test
    void 언팔로우할_때_잘못된_팔로워_id면_예외를_발생한다() {
        FollowerRequest request = new FollowerRequest(eden.getId(), -1L);
        assertThrows(NoSuchElementException.class, () -> followService.deleteFollower(request));
    }

    @Test
    void 팔로워를_조회한다() {
        FollowerResponse response = followService.getFollowers(eden.getId());
        assertThat(response.getFollowerMemberIds()).hasSize(1);
    }
}
