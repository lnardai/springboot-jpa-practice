package com.nardai.practice.controller;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/test/resources/spring-root-context-test.xml")
@WebMvcTest
public class UserControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	@WithMockUser
	public void getRandomStar() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get("/v1/stars/random").with(csrf()))
				.andDo(print())
				.andExpect(status().is2xxSuccessful())
				.andExpect(jsonPath("$.name", is(not(""))))
				.andExpect(jsonPath("$.id", is(not(""))));
	}

}
