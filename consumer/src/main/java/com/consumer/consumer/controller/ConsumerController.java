package com.consumer.consumer.controller;

import com.consumer.consumer.event.Event;
import com.consumer.consumer.openfeign.ProducerController;
//import com.rabbitmq.client.amqp.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.consumer.consumer.event.Event.Type.CREATE;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    private static final Logger LOG = LoggerFactory.getLogger(ConsumerController.class);
    @Autowired
    private ProducerController producerController;

    /*private final StreamBridge streamBridge;

    public ConsumerController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }*/

    @GetMapping("hello")
    public String hello() {
      System.out.println(  producerController.hello());

        return "Hello consumer";
    }

}
