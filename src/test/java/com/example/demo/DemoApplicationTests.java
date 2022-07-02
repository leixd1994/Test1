package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileWriter;
import java.util.Properties;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private Person person;
	@Test
	void contextLoads() {
		System.out.println(person);
	}

}
