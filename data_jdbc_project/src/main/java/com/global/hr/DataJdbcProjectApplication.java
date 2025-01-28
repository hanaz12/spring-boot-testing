package com.global.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataJdbcProjectApplication {

	public static void main(String[] args) {
		System.out.println("In main method");
		SpringApplication.run(DataJdbcProjectApplication.class, args);
		System.out.println("In main method");
	}

}
