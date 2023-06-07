package com.wooteco.member.business.client;

import com.wooteco.member.business.dto.MailSendRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "MailOpenFeign", url = "${mail.server.url}")
public interface MailOpenFeign {

    @PostMapping("/mail/send")
    void sendMail(@RequestBody MailSendRequest mailSendRequest);
}
