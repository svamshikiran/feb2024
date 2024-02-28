package com.example.feb2024.kafka;

import com.example.feb2024.model.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class KafkaProducerService {

    private static String topicName = "student.feb2024.queue";

    @Autowired
    KafkaTemplate<String, Student> kafkaTemplate;

    public String sendSimpleMessage(Student student) throws JsonProcessingException {

        Message<Student> message = MessageBuilder
                .withPayload(student)
                .setHeader(KafkaHeaders.TOPIC, topicName)
                .build();

        CompletableFuture future = kafkaTemplate.send(message);
        return "Success";
    }
}
