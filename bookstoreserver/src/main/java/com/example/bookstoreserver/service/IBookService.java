package com.example.bookstoreserver.service;

import java.util.Collection;

import com.example.bookstoreserver.model.Book;

public interface IBookService {
	public abstract void addBook(Book book);
	public abstract void updateBook(String id, Book book);
	public abstract void deleteBook(String id);
	public abstract Book getBook(String id);
	public abstract Collection<Book> getAllBooks();
}
