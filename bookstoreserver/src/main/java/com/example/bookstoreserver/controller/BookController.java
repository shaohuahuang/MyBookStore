package com.example.bookstoreserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreserver.model.Book;
import com.example.bookstoreserver.service.BookService;

@RestController
public class BookController {
	@Autowired
	BookService bookService;
	
	@RequestMapping(value="/books")
	public ResponseEntity<Object> getAllBooks(){
		return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/books/{id}")
	public ResponseEntity<Object> getBook(@PathVariable String id){
		return new ResponseEntity<>(bookService.getBook(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/books", method=RequestMethod.POST)
	public ResponseEntity<Object> addBook(@RequestBody Book book){
		bookService.addBook(book);
		return new ResponseEntity<>("Book is added successsfully", HttpStatus.OK);
	}
	
	@RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateBook(@PathVariable String id, @RequestBody Book book){
		bookService.updateBook(id, book);
		return new ResponseEntity<>("Book is updated successsfully", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
	   public ResponseEntity<Object> delete(@PathVariable("id") String id) {
	      bookService.deleteBook(id);
	      return new ResponseEntity<>("Book is deleted successsfully", HttpStatus.OK);
	   }
}
