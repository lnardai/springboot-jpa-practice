package com.nardai.practice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PracticeApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGreetings() {
		this.restTemplate.getForEntity(
				"/greetings", String.class);
	}


	@Test
	public void testUser() {
		this.restTemplate.getForEntity(
				"/user", String.class);
	}

}
