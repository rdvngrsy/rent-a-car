package com.example.rentacar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RentACarApplication {
	// Entities -> DTOS -> Repositories -> Services -> Controller  Bu sırayla projeyi kur.

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}

}
