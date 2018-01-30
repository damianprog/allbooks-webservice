package com.damianprog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.Book;
import com.damianprog.services.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	@RequestMapping("/books/title/{title}")
	public Book getBookByTitle(@PathVariable String title) {
		return bookService.getBookByTitle(title);
	}
	
	@RequestMapping("/books/{bookId}")
	public Book getBookById(@PathVariable int bookId) {
		return bookService.getBookById(bookId);
	}
	
}
