package com.producer.producer.controller;

import com.producer.producer.service.SagaServiceA;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final SagaServiceA sagaServiceA;

    public ApiController(SagaServiceA sagaServiceA) {
        this.sagaServiceA = sagaServiceA;
    }

    @GetMapping("/invoke")
    public String invokeApisInSaga() {
        sagaServiceA.send("Hello");
        return "APIs invoked";
    }
}