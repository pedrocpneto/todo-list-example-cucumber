package net.pcpinfo.todolistexemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TodoListExemploApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoListExemploApplication.class, args);
	}

}
