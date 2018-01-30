package com.damianprog.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.damianprog.entities.Review;

public interface ReviewRepository extends CrudRepository<Review,Integer> {

	List<Review> findAllByBookId(int bookId);
	
}
