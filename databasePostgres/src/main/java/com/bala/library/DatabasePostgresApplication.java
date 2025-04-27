package com.bala.library;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Log
public class DatabasePostgresApplication  {

	public static void main(String[] args) {
		SpringApplication.run(DatabasePostgresApplication.class, args);
	}
}
