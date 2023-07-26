package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Period;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/person")
public class SpringBootExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExampleApplication.class, args);
	}

	@GetMapping("")
	public GreetResponse greet()
	{
		return new GreetResponse(
				"Hello",
				List.of("java","c++","python"),
				new Person("gani")
		);
	}


	record Person(String name)
	{}


	record GreetResponse(String greet,
						 List<String> favProgrammingLanguages,
						 Person person
	)
	{

	}

}
