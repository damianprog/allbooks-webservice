package com.damianprog.controllers;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.Book;
import com.damianprog.services.BookService;
import com.damianprog.services.HibernateSearchService;
import com.damianprog.utils.ArrayOfIntsGetter;

@RestController
public class BookController {

	@Autowired
	private HibernateSearchService searchService;

	@Autowired
	private BookService bookService;

	@Autowired
	private ArrayOfIntsGetter arrayOfIntsGetter;
	
	@RequestMapping("/books/title/{title}")
	public Book getBookByTitle(@PathVariable String title) {
		return bookService.getBookByTitle(title);
	}

	@RequestMapping("/books/{bookId}")
	public Book getBookById(@PathVariable int bookId) {
		return bookService.getBookById(bookId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/books")
	public void saveBook(@RequestBody Book book) {
		bookService.saveBook(book);
	}

	@RequestMapping("/books/categories/{category}/{page}")
	public Page<Book> getBooksByCategory(@PathVariable String category, @PathVariable int page) {
		return bookService.getBooksByCategory(category, new PageRequest(page - 1, 3, Direction.DESC, "id"));
	}

	@RequestMapping("/books/categories/{category}/exclude/{excludedIds}")
	public Book getBookByCategoryExceptBooksWithIds(@PathVariable String category,
			@PathVariable("excludedIds") String excludedIds) {
		
		int[] excludedIdsArray = arrayOfIntsGetter.get(excludedIds);
		
		List<Book> books = bookService.getBookByCategoryExceptBooksWithIds(category,excludedIdsArray);
	
		Random rand = new Random();
		
		if(!books.isEmpty())
			return books.get(rand.nextInt(books.size()));
		else
			return null;
	}

	@RequestMapping("/books/search/{phrase}")
	public List<Book> searchBooksWithPhrase(@PathVariable String phrase) {
		return searchService.fuzzySearch(phrase);
	}

}
