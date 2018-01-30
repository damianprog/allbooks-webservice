package com.damianprog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.Review;
import com.damianprog.services.ReviewService;

@RestController
public class ReviewController {

	@Autowired
	ReviewService reviewService;
	
	@RequestMapping("/books/{bookId}/reviews")
	public List<Review> getAllBookReviews(@PathVariable int bookId) {
		return reviewService.getAllBookReviews(bookId);
	}
	
	@RequestMapping("/reviews/{reviewId}")
	public Review getReviewById(@PathVariable int reviewId) {
		return reviewService.getReviewById(reviewId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/reviews")
	public void postReview(@RequestBody Review review) {
		reviewService.postReview(review);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/reviews/{reviewId}")
	public void updateReview(@RequestBody Review review,@PathVariable int reviewId) {
		reviewService.updateReview(review);
	}
	
}
