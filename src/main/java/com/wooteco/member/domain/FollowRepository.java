package com.wooteco.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    int deleteByFollowingAndFollower(Member following, Member follower);

    @Query("SELECT f.follower.id FROM Follow f WHERE f.following.id = :followingId")
    List<Long> findFollowerIdsByFollowingId(Long followingId);
}
