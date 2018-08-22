package com.example.bookstoreclient.controller;

import com.example.bookstoreclient.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class ConsumeBookController {
	private final String serverURL = "http://localhost:8080/bookstoreserver-0.0.1-SNAPSHOT";
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(value="/books")
	public String getAllBooks(){
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange(serverURL + "/books", HttpMethod.GET, entity, String.class).getBody();
	}
	
	@RequestMapping(value="/books/{id}")
	public String getBook(@PathVariable String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange(serverURL + "/books/" + id, HttpMethod.GET, entity, String.class).getBody();
	}
	
	@RequestMapping(value="/books", method=RequestMethod.POST)
	public String addBook(@RequestBody Book book) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Book> entity = new HttpEntity<Book>(book,headers);
        return restTemplate.exchange(serverURL + "/books", HttpMethod.POST, entity, String.class).getBody();
	}
	
	@RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
	public String updateBook(@PathVariable String id, @RequestBody Book book) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Book> entity = new HttpEntity<Book>(book,headers);
        return restTemplate.exchange(serverURL + "/books/" + id, HttpMethod.PUT, entity, String.class).getBody();
	}
	
	@RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
	   public String deleteProduct(@PathVariable("id") String id) {
	      HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Book> entity = new HttpEntity<Book>(headers);
	      
	      return restTemplate.exchange(
	         serverURL + "/books/" + id, HttpMethod.DELETE, entity, String.class).getBody();
	   }
}
