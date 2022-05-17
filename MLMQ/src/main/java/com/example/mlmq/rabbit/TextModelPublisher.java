package com.example.mlmq.rabbit;

import com.example.mlmq.message.SendMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class TextModelPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void sendToModel(SendMessage output) {

        // 추론 결과 output을 Receive MQ로 Publish
        rabbitTemplate.convertAndSend("result_queue", output);
        log.info("Publishing : {} ", output);
    }
}
