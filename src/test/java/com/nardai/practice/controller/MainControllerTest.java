package com.nardai.practice.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/test/resources/spring-root-context-test.xml")
@WebMvcTest
public class MainControllerTest {
	@Autowired
	private MockMvc mvc;

	@Test
	public void testGreetings() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.post("/v1/user/greetings"));
	}


	@Test
	public void testUser() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.post("/v1/user/goodBye"));
	}
}
