package com.example.customerloyalty;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.customerloyalty.model.Customer;
import com.example.customerloyalty.repository.CustomerRepository;

@SpringBootApplication
public class CustomerLoyaltyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerLoyaltyApplication.class, args);
	}
	@Autowired
	private CustomerRepository customerRepository;
	
	@Bean
	public CommandLineRunner run() {
		return (args) ->{
			String email="john.11@example.com";
			
			Optional<Customer> existingCustomer = customerRepository.findByEmail(email);
			
			if (existingCustomer.isPresent()) {
                System.out.println("Customer with email " + email + " already exists.");
                	
			}else {
				
			
			Customer customer1 = new Customer("John", "Doe", "john.11@example.com");
			customerRepository.save(customer1);
			System.out.println("New customer added: " + customer1);
			}
			
			System.out.println("All Customers:"+customerRepository.findAll());
		};
	}
		
}


