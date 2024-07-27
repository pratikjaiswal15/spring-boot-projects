package com.spring.boot.spring_security_learning.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    private String helloWorld() {
        return "hello-world";
    }
}
