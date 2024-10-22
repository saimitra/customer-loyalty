package com.example.customerloyalty.exception;

public class CustomerNotFoundException extends RuntimeException {
	
	public  CustomerNotFoundException(Long id) {
		super("customer with id" + id +"not found");
	}

}
