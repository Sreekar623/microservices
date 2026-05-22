package com.project.DepartmentService.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "employee-topic", groupId = "group-id")
    public void consume(String message) {
        System.out.println("Message Received: " + message);
    }
}