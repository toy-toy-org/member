package com.wooteco.member.business.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MailSendRequest {

    private String toAddress;
    private String title;
    private String content;

    public MailSendRequest(String email, String title, String content) {
        this.toAddress = email;
        this.title = title;
        this.content = content;
    }
}
