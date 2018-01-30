package com.damianprog.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.damianprog.entities.Rating;

public interface RatingRepository  extends CrudRepository<Rating,Integer>{

	Rating findOneByReaderIdAndBookId(int readerId,int bookId);
	List<Rating> findAllByBookId(int bookId);
}
