package com.example.bookstoreserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class BookstoreserverApplication extends SpringBootServletInitializer {
  
  @Override
   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
      return application.sources(BookstoreserverApplication.class);
   }
  
	public static void main(String[] args) {
		SpringApplication.run(BookstoreserverApplication.class, args);
	}
}

//public class BookstoreserverApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(BookstoreserverApplication.class, args);
//	}
//}
