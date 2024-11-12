package com.incb.store_content_manager.configuration;

import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaBootStrapUrl;

    @Value("${spring.kafka.consumer.group-id}")
    private String consumerGroupId;

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> kafkaConsumerConfig = new HashMap<>();
        kafkaConsumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBootStrapUrl);
        kafkaConsumerConfig.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);
        kafkaConsumerConfig.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        kafkaConsumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        kafkaConsumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(kafkaConsumerConfig);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> listenerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        listenerFactory.setConsumerFactory(consumerFactory());
        return listenerFactory;
    }
}
