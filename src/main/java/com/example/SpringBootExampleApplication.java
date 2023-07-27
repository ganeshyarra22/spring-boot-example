package com.example;

import com.example.customer.Customer;
import com.example.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringBootExampleApplication {


	public static void main(String[] args) {

         SpringApplication.run(SpringBootExampleApplication.class, args);

	}

	@Bean
	CommandLineRunner runner(CustomerRepository customerRepository){

		return args-> {
			Customer alex = new Customer(
					"Alex",
					"alex@gmail.com",
					21
			);
			Customer jamila = new Customer(
					"jamila",
					"jamila@gmail.com",
					19
			);

			List<Customer> customers = List.of(alex, jamila);
			customerRepository.saveAll(customers);

		};
	}




}
