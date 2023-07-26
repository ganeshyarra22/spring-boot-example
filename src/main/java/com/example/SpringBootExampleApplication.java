package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootExampleApplication {


	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootExampleApplication.class, args);


//		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//
//		for (String beanDefinitionName : beanDefinitionNames) {
//			System.out.println(beanDefinitionName);

//		}
	}

	@Bean
	public Foo getFoo()
	{
		return new Foo("bar");
	}


	record Foo(String name)
	{

	}



}
