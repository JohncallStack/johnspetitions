package com.example.johnspetitions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class JohnspetitionsApplication {

	@RequestMapping("/")
	public String hello1() {
		return "Hello";
	}

	@RequestMapping("/hello")
	public String hello2() {
		return "Hello Again";
	}


	public static void main(String[] args) {
		SpringApplication.run(JohnspetitionsApplication.class, args);
	}

}
