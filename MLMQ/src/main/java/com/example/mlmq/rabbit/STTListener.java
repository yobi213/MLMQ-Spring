package com.example.mlmq.rabbit;

import com.example.mlmq.message.ReceiveMessage;
import com.example.mlmq.message.SendMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class STTListener {

    private final TextModelPublisher publisher;
    private final MLInferencer inferencer;


    @RabbitListener(queues = "stt_queue")
    public void listen(ReceiveMessage input) {

        // Send MQ 에서 input을 Consume
        log.info("Consuming : {} ", input);

        // input에서 text 부분을 모델에 전달하여 추론
        String predict = inferencer.inference(input.getText());

        // 추론 결과 output을 Receive MQ로 Publish
        publisher.sendToModel(new SendMessage(input.getId(), input.getText(), predict));
    }
}
