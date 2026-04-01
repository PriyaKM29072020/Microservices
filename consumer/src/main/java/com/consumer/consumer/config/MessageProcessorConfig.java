package com.consumer.consumer.config;

import com.consumer.consumer.event.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class MessageProcessorConfig {
    private static final Logger LOG = LoggerFactory.getLogger(MessageProcessorConfig.class);
    @Bean
    public Consumer<Event<Integer, String>> messageProcessor() {
        return event -> {
            LOG.info("Process message created at {}...", event.getEventCreatedAt());

            switch (event.getEventType()) {

                case CREATE:
                    String product = event.getData();
                    LOG.info("Create  with ID: {}",product );
                   // productService.createProduct(product).block();
                    break;

                case DELETE:
                    int key =event.getKey() ;
                    LOG.info("Delete product with ProductID: {}", key);
                   // productService.deleteProduct(productId).block();
                    break;

                default:
                    String errorMessage = "Incorrect event type: " + event.getEventType() + ", expected a CREATE or DELETE event";
                    LOG.warn(errorMessage);
                    try {
                        throw new Exception(errorMessage);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
            }

            LOG.info("Message processing done!");

        };
    }


}
