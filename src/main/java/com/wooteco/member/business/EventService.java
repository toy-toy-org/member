package com.wooteco.member.business;

import com.wooteco.member.business.dto.FollowCreateEvent;
import com.wooteco.member.business.dto.MemberCreateEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class EventService {

    private final KafkaTemplate<Long, String> kafkaTemplate;

    @TransactionalEventListener
    public void listenCreateMemberEvent(MemberCreateEvent event) {
        kafkaTemplate.send("sign-up", event.id(), event.email());
    }

    @TransactionalEventListener
    public void listenCreateFollowEvent(FollowCreateEvent event) {
        kafkaTemplate.send("follow", event.followingId(), String.valueOf(event.followerId()));
    }
}
