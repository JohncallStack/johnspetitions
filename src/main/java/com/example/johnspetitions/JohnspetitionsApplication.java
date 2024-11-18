package com.example.johnspetitions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RestController
public class JohnspetitionsApplication {

//	@RequestMapping("/")
//	public String hello1() {
//		return "Hello, checking to see if my webhook has connecting correctly, maybe this time??";
//	}
//
//	@RequestMapping("/hello")
//	public String hello2() {
//		return "Hello Again, it seems the webhook has connected correctly!";
//	}

	public static void main(String[] args) {
		SpringApplication.run(JohnspetitionsApplication.class, args);
	}

}
