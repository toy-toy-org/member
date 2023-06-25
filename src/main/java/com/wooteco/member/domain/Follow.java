package com.wooteco.member.domain;

import com.wooteco.member.business.dto.FollowCreateEvent;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

@Getter
@NoArgsConstructor
@Entity
public class Follow extends AbstractAggregateRoot<Follow> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member followingMember;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member followerMember;

    public Follow(Member followingMember, Member followerMember) {
        this.followingMember = followingMember;
        this.followerMember = followerMember;
        registerEvent(new FollowCreateEvent(this.followingMember.getId(), this.followerMember.getId()));
    }
}
