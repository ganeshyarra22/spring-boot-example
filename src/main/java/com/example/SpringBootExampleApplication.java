package com.example;

import com.example.customer.Customer;
import com.example.customer.CustomerRepository;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class SpringBootExampleApplication {


	public static void main(String[] args) {

         SpringApplication.run(SpringBootExampleApplication.class, args);

	}

	@Bean
	CommandLineRunner runner(CustomerRepository customerRepository){
		return args-> {
			var faker = new Faker();
			Random random = new Random();
			Name name = faker.name();
			String firstName = name.firstName();
			String lastName = name.lastName();
			Customer customer = new Customer(
					firstName + " " + lastName,
					firstName.toLowerCase()+ "." + lastName.toLowerCase() + "@amigoscode.com",
					random.nextInt(16,99)
			);
			customerRepository.save(customer);

		};
	}




}
