package com.damianprog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.damianprog.entities.Like;

public interface LikeRepository extends CrudRepository<Like,Integer>{

	Like findOneByReviewIdAndReaderId(int reviewId,int readerId);
	
}
