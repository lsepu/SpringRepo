package com.lsepu.jpa;

import com.lsepu.jpa.models.Author;
import com.lsepu.jpa.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository authorRepository
	) {
		return args -> {
			var author = Author.builder()
					.firstName("luis")
					.lastName("sepulveda")
					.email("luisz@gmail.com")
					.build();
			authorRepository.save(author);
		};
	}
}
