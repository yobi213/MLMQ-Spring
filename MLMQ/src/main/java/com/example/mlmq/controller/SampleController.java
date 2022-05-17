package com.example.mlmq.controller;

import com.example.mlmq.message.ReceiveMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class SampleController {

    private final RabbitTemplate rabbitTemplate;

    @GetMapping("/pub/{text}")
    public void test(@PathVariable String text) {
        ReceiveMessage msg = new ReceiveMessage(UUID.randomUUID().toString(), text);
        rabbitTemplate.convertAndSend("stt_queue", msg);
    }
}
