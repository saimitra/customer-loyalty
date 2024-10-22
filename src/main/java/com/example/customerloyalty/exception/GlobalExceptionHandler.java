package com.example.customerloyalty.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException ex,WebRequest request){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGlobalException(
			Exception ex,WebRequest request){
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("an unexcepted error occured"+ex.getMessage());
	}
	

}
