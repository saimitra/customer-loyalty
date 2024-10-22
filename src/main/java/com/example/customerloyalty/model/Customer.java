package com.example.customerloyalty.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "First name is required")
	@Size(min = 2, message ="First name msut have at least 2 characters")
	@Column(nullable = false)
	private String firstName;
	
	
	@NotBlank(message="Las name is required")
	@Size(min=2, message ="Last name is required and nedd at least 2 characters")
	@Column(nullable = false)
	private String lastName;
	
	@NotBlank(message="email is required")
	@Email(message ="Email should be valid")
	@Column(nullable = false, unique =true)
	private String email;
	
	public Customer() {
		
	}
	
	public Customer(String firstName,String lastName,String email) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
        this.id = id;
    }
	
	public String getFirstName() {
        return firstName;
    }
	public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
	
	public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
	

}
