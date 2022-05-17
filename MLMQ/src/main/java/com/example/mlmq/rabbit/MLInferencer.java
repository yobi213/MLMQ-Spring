package com.example.mlmq.rabbit;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
@RequiredArgsConstructor
public class MLInferencer {

    private final TextModelPublisher publisher;
    private static final String MODEL_URL = "http://localhost:8000/text_classification/sentiment/{text}";

    public String inference(String text) {

        // input에서 text 부분을 모델에 전달하여 추론
        RestTemplate restTemplate = new RestTemplate();
        String predict = restTemplate.getForObject(MODEL_URL, String.class, text);
        log.info("Inference : {} ", predict);

        return predict;

    }
}
