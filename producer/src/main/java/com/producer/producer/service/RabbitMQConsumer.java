package com.producer.producer.service;

import com.producer.producer.configuration.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {
    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receive(String message) {

        System.out.println("Received: " + message);
    }}