package com.damianprog.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.damianprog.entities.Book;

public interface BookRepositoryJpa extends JpaRepository<Book,Integer>{

	Page<Book> findAllByCategory(String category,Pageable pageRequest);
	
}
