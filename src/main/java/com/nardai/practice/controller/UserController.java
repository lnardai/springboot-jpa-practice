package com.nardai.practice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.security.Principal;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @RequestMapping("/details")
    public Principal user(Principal principal) {
        return principal;
    }

}
