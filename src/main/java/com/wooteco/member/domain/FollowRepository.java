package com.wooteco.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    int deleteByFollowingMemberAndFollowerMember(Member followingMember, Member followerMember);

    @Query("SELECT f.followerMember.id FROM Follow f WHERE f.followingMember.id = :followingMemberId")
    List<Long> findFollowerMemberIdsByFollowingMemberId(Long followingMemberId);
}
