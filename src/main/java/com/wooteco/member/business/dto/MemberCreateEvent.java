package com.wooteco.member.business.dto;

public class MemberCreateEvent {

    private final String name;
    private final String email;

    public MemberCreateEvent(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
