package com.producer.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

//@RequestMapping("producer")
public class ProducerController {

    @GetMapping("hello")
    public String hello() {
        System.out.println("hello");
        return "Hello World";
    }
    @GetMapping("hello")
    public String hello1() {
        System.out.println("hello");
        return "Hello World";
    }
}
