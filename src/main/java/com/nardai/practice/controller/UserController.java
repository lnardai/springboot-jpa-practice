package com.nardai.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.security.Principal;

import com.nardai.practice.star.system.StarService;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @GetMapping("/name")
    public String userUserName(Principal principal) {
        return principal.getName();
    }

}
