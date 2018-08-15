package com.damianprog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.damianprog.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

	Book findOneByMiniTitle(String title);

	List<Book> findAllByCategory(String category);

}
