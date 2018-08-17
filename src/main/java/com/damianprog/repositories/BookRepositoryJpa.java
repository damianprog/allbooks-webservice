package com.damianprog.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.damianprog.entities.Book;

public interface BookRepositoryJpa extends JpaRepository<Book,Integer>{

	Page<Book> findAllByCategory(String category,Pageable pageRequest);
	
	Page<Book> findAll(Pageable pageable);

	List<Book> findFirst10ByIdNotInAndCategory(int[] excludedIds,String category);
	
}
