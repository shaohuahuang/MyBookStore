package com.example.bookstoreserver.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.bookstoreserver.model.Book;

@Service
public class BookService implements IBookService{
	private static Map<String, Book> bookRepo = new HashMap<>();
	static {
		Book math = new Book();
		math.setId("1");
		math.setName("Math");
		math.setAuthor("Tom");
		bookRepo.put(math.getId(), math);
		
		Book physics = new Book();
		physics.setId("2");
		physics.setName("Physics");
		physics.setAuthor("Newton");
		bookRepo.put(physics.getId(), physics);
	}
	
	
	@Override
	public void addBook(Book book) {
		bookRepo.put(book.getId(), book);		
	}

	@Override
	public void updateBook(String id, Book book) {
		bookRepo.remove(id);
		bookRepo.put(book.getId(), book);
	}

	@Override
	public void deleteBook(String id) {
		bookRepo.remove(id);
	}

	@Override
	public Book getBook(String id) {
		return bookRepo.get(id);
	}

	@Override
	public Collection<Book> getAllBooks() { 
		return bookRepo.values();
	}

}
