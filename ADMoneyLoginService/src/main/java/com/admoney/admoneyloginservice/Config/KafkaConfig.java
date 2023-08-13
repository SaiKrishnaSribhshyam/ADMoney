package com.admoney.admoneyloginservice.Config;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

@Configuration
public class KafkaConfig {
    private final KafkaProperties kafkaProperties;
    public KafkaConfig(KafkaProperties kafkaProperties){
        this.kafkaProperties=kafkaProperties;
    }

    public ProducerFactory<String,String> getProducerFactory(){
        Map<String,Object> producerProperties=kafkaProperties.buildProducerProperties();
        return new DefaultKafkaProducerFactory<>(producerProperties);
    }

    @Bean
    public KafkaTemplate<String,String> getKafkaTemplate(){
        return new KafkaTemplate<>(getProducerFactory());
    }
}
