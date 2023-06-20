package com.wooteco.member.business;

import com.wooteco.member.business.dto.MemberCreateEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@RequiredArgsConstructor
public class EventService {

    private final KafkaTemplate<Long, String> kafkaTemplate;

    @TransactionalEventListener
    public void listenCreateMemberEvent(MemberCreateEvent event) {
        kafkaTemplate.send("sign-up", event.getId(), event.getEmail());
    }
}
