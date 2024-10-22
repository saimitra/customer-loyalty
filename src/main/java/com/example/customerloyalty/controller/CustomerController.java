package com.example.customerloyalty.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customerloyalty.exception.CustomerNotFoundException;
import com.example.customerloyalty.model.Customer;
import com.example.customerloyalty.repository.CustomerRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer){
		Customer savedCustomer = customerRepository.save(customer);
		
		return ResponseEntity.status(201).body(savedCustomer);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customers = customerRepository.findAll();
		
		return ResponseEntity.ok(customers);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
		
		Customer customer = customerRepository.findById(id)
		        .orElseThrow(() -> new CustomerNotFoundException(id));

		
		return ResponseEntity.ok(customer);
		
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,@Valid @RequestBody Customer updatedCustomerDetails){
		
	
	Optional<Customer> customerOptional = customerRepository.findById(id);
	
	if(customerOptional.isPresent()) {
		Customer existingCustomer = customerOptional.get();
		
		existingCustomer.setFirstName(updatedCustomerDetails.getFirstName());
		existingCustomer.setLastName(updatedCustomerDetails.getLastName());
		existingCustomer.setEmail(updatedCustomerDetails.getEmail());
		
		Customer updatedCustomer = customerRepository.save(existingCustomer);
		return ResponseEntity.ok(updatedCustomer);
	}
	
	return ResponseEntity.notFound().build();
	
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
		Customer customer = customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException(id));
		
		
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
