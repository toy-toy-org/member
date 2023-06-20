package com.wooteco.member.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Follow {

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
    }
}
