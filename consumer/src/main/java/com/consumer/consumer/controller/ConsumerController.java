package com.consumer.consumer.controller;

import com.consumer.consumer.openfeign.ProducerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer")
public class ConsumerController {
    @Autowired
    private ProducerController producerController;

    @GetMapping("hello")
    public String hello() {
      System.out.println(  producerController.hello());

        return "Hello consumer";
    }
}
