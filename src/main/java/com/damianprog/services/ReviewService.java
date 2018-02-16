package com.damianprog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.Review;
import com.damianprog.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	ReviewRepository reviewRepository;
	
	public List<Review> getAllBookReviews(int bookId){
		return reviewRepository.findAllByBookId(bookId);
	}

	public Review getReviewById(int reviewId) {
		return reviewRepository.findOne(reviewId);
	}

	public void postReview(Review review) {
		reviewRepository.save(review);
	}

	public void updateReview(Review review) {
		reviewRepository.save(review);
	}

	public void deleteReview(int reviewId) {
		reviewRepository.delete(reviewId);
	}
	
}
