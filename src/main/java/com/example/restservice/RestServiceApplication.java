package com.example.restservice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

/**
 * A RESTful API that extends https://sverigesradio.se/api/documentation/v2/ 
 * to enable searching for radio shows.
 * */
@SpringBootApplication
public class RestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}
}
