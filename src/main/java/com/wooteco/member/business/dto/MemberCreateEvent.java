package com.wooteco.member.business.dto;

public class MemberCreateEvent {

    private final Long id;
    private final String email;

    public MemberCreateEvent(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
