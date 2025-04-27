package com.bala.databasePostgres;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class DatabasePostgresApplication implements CommandLineRunner {

	final DataSource dataSource;

	public DatabasePostgresApplication(final DataSource dataSource){this.dataSource = dataSource;}

	public static void main(String[] args) {
		SpringApplication.run(DatabasePostgresApplication.class, args);
	}

	@Override
	public void run(final String... args){
		log.info("DataSource: " + dataSource.toString());
		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		restTemplate.execute("select 1");
	}
}
