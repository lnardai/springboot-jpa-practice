package com.nardai.practice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class HelloController {

    @GetMapping("/greetings")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "Goodbye!";
    }

}
