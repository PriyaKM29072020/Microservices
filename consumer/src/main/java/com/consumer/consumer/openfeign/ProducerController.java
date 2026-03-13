package com.consumer.consumer.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "producer-service", url = "http://localhost:9090")
public interface ProducerController {
    @GetMapping("hello")
    String hello();
}
