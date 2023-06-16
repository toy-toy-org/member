package com.wooteco.member.business;

import com.wooteco.member.business.dto.MemberCreateEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class InternalEventListener {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @TransactionalEventListener
    public void listenCreateMember(MemberCreateEvent event) {
        kafkaTemplate.send("test", event.getEmail());
    }
}
