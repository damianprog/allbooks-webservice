package com.damianprog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.Like;
import com.damianprog.repositories.LikeRepository;

@Service
public class LikeService {

	@Autowired
	private LikeRepository likeRepository;

	public Like getLikeByReviewIdAndReaderId(int reviewId, int readerId) {
		return likeRepository.findOneByReviewIdAndReaderId(reviewId, readerId);
	}

	public void deleteLikeById(int likeId) {
		
		likeRepository.delete(likeId);
	}
	
	
	
}
