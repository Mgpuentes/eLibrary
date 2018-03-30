package com.puentes.elibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.puentes.elibrary.backend.persistance.repositories"})
@EntityScan(basePackages = {"com.puentes.elibrary.backend.persistance.domain"})
public class ElibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElibraryApplication.class, args);
	}
}
