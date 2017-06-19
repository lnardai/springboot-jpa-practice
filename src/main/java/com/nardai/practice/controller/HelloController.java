package com.nardai.practice.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1/secret")
public class HelloController {

    @RequestMapping("/greetings")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/goodbye")
    public String goodbye() {
        return "Goodbye!";
    }

}
