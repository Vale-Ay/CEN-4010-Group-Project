package com.Group3.GeekText;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//Test

@SpringBootApplication(scanBasePackages = {"com.Group3.GeekText"})
@EnableJpaRepositories(basePackages = {"com.Group3.GeekText"})
public class GeekTextApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeekTextApplication.class, args);
	}

}
