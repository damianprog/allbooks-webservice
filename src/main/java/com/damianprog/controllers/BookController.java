package com.damianprog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(method=RequestMethod.POST, value="/books")
	public void saveBook(@RequestBody Book book) {
		bookService.saveBook(book);
	}
	
	@RequestMapping("/books/categories/{category}/{page}")
	public Page<Book> getBooksByCategory(@PathVariable String category,@PathVariable int page){
		return bookService.getBooksByCategory(category,new PageRequest(page-1,3));
	}
	
}
