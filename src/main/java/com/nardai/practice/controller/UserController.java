package com.nardai.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nardai.practice.authentication.UserContext;

@RestController
@RequestMapping("/v1/user")
public class UserController {

	@Autowired
	private UserContext userContext;

	@GetMapping("/name")
	public UserInfo userUserName() {
		return new UserInfo(userContext.getUserId(), userContext.getUserName());
	}

}
