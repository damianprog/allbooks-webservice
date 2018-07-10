package com.damianprog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.damianprog.entities.Book;
import com.damianprog.repositories.BookRepository;
import com.damianprog.repositories.BookRepositoryJpa;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookRepositoryJpa bookRepositoryJpa;
	
	public Book getBookByTitle(String title) {
		return bookRepository.findOneByMiniTitle(title);
	}

	public Book getBookById(int bookId) {
		
		return bookRepository.findOne(bookId);
	}

	public void saveBook(Book book) {
		bookRepository.save(book);
	}

	public Page<Book> getBooksByCategory(String category,Pageable pageable) {
		return bookRepositoryJpa.findAllByCategory(category,pageable);
	}

	
	
}
