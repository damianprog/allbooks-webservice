package com.damianprog.services;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.Book;
import com.damianprog.entities.ErrorMessage;
import com.damianprog.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	public Book getBookByTitle(String title) {
		return bookRepository.findOneByTitle(title);
	}

	public Book getBookById(int bookId) {
		
		return bookRepository.findOne(bookId);
	}

	public void saveBook(Book book) {
		bookRepository.save(book);
	}

	
	
}
