package com.damianprog.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.damianprog.entities.Review;

public interface ReviewRepository extends CrudRepository<Review,Integer> {

	List<Review> findAllByBookId(int bookId);
	
	List<Review> findAllByReaderId(int readerId);
	
	@Transactional
	void deleteByIdAndReaderId(int id,int readerId);
}
