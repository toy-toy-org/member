package com.wooteco.member.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class FollowRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private FollowRepository followRepository;

    private Member eden;
    private Member nede;
    private Follow follow;

    @BeforeEach
    void setup() {
        eden = new Member("eden", "eden@email");
        nede = new Member("nede", "nede@email");
        memberRepository.save(eden);
        memberRepository.save(nede);
        follow = followRepository.save(new Follow(eden, nede));
    }

    @Test
    void 언팔로우한다() {
        int affectedQuery = followRepository.deleteByFollowingMemberAndFollowerMember(eden, nede);
        assertThat(affectedQuery).isOne();
    }

    @Test
    void 팔로잉_id로_팔로워들을_조회한다() {
        List<Long> followerIds = followRepository.findFollowerMemberIdsByFollowingMemberId(eden.getId());
        Assertions.assertAll(
                () -> assertThat(followerIds).hasSize(1),
                () -> assertThat(followerIds.get(0)).isEqualTo(nede.getId())
        );
    }
}
