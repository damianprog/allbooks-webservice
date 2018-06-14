package com.damianprog.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.damianprog.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

	Book findOneByMiniTitle(String title);
	List<Book> findAllByCategory(String category);
	
}
