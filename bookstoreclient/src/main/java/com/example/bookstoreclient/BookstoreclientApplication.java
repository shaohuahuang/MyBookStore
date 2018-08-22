package com.example.bookstoreclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BookstoreclientApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BookstoreclientApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreclientApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
      return new RestTemplate();
    }
}


