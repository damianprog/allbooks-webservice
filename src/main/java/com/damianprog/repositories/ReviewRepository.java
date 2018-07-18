package com.damianprog.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.damianprog.entities.Review;

public interface ReviewRepository extends CrudRepository<Review,Integer> {

	List<Review> findAllByBookId(int bookId);
	
	List<Review> findAllByPostingReaderId(int postingReaderId);
	
	@Transactional
	void deleteByIdAndPostingReader(int id,int postingReader);
}
