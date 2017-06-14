package com.nardai.practice;

import com.nardai.practice.controller.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class PracticeApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void greetingTest() throws Exception{
		mockMvc.perform(post("/greetings"))
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().string("Greetings from Spring Boot!"));
	}

	@Test
	public void goodbyeTest() throws Exception{
		mockMvc.perform(post("/goodbye"))
				.andExpect(status().is2xxSuccessful())
				.andExpect(content().string("Goodbye!"));
	}

}
