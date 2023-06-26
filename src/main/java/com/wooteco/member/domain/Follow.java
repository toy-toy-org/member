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
    private Member following;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member follower;

    public Follow(Member following, Member follower) {
        this.following = following;
        this.follower = follower;
        registerEvent(new FollowCreateEvent(this.following.getId(), this.follower.getId()));
    }
}
