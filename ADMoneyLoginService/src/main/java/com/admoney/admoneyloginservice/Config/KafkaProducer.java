package com.admoney.admoneyloginservice.Config;

import com.admoney.admoneyloginservice.Models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
    private final String kafkaTopic="UserLogin";
    private final KafkaTemplate<String,String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public KafkaProducer(KafkaTemplate<String,String> kafkaTemplate,ObjectMapper objectMapper){
        this.kafkaTemplate=kafkaTemplate;
        this.objectMapper=objectMapper;
    }

    public void sendMessage(User user){
        try {
            String userAsString=objectMapper.writeValueAsString(user);
            kafkaTemplate.send(kafkaTopic,userAsString);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
