package com.example.springspock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSpockApplicationTests {

	@Autowired
	SpringSpockApplication springSpockApplication;

	@Test
	void contextLoads() {

		Assertions.assertEquals("hello world", springSpockApplication.hello());
	}


}
