package com.producer.producer.controller;

import com.producer.producer.event.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.producer.producer.event.Event.Type.CREATE;

@RestController

//@RequestMapping("producer")
public class ProducerController {

    private static final Logger LOG = LoggerFactory.getLogger(ProducerController.class);
    private final StreamBridge streamBridge;

    public ProducerController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }


    @GetMapping("hello")
    public String hello() {
        System.out.println("hello");
        return "Hello World";
    }
    @GetMapping("/producersEvent")
    public String createEvent() {
        LOG.info("createEvent");
        sendMessage("producers-out-0", new Event<>(CREATE, "A123", "123 producers"));

        return "producersEvent";
    }

    private void sendMessage(String bindingName, Event event) {
        LOG.debug("Sending a {} message to {}", event.getEventType(), bindingName);
        Message<Event> message = MessageBuilder.withPayload(event)
                .setHeader("partitionKey", event.getKey())
                .build();
        streamBridge.send(bindingName, message);
    }
}
