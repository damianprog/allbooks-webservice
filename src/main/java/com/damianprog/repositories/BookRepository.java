package com.damianprog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.damianprog.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

	Book findOneByMiniTitle(String title);
	
}
