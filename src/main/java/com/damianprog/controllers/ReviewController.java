package com.damianprog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.Reader;
import com.damianprog.entities.Review;
import com.damianprog.services.ReaderService;
import com.damianprog.services.ReviewService;

@RestController
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping("/books/{bookId}/reviews")
	public List<Review> getAllBookReviews(@PathVariable int bookId) {
		return reviewService.getAllBookReviews(bookId);
	}
	
	@RequestMapping("/readers/{readerId}/books/reviews")
	public List<Review> getReaderReviews(@PathVariable int readerId){
		return reviewService.getReaderReviews(readerId);
	}
	
	@RequestMapping("/reviews/{reviewId}")
	public Review getReviewById(@PathVariable int reviewId) {
		return reviewService.getReviewById(reviewId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/reviews")
	public void postReview(@RequestBody Review review) {
		
		reviewService.postReview(review);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/reviews")
	public void updateReview(@RequestBody Review review) {
		reviewService.updateReview(review);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/reviews/{reviewId}")
	public void deleteReview(@PathVariable int reviewId) {
		reviewService.deleteReview(reviewId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/readers/{readerId}/books/reviews/{reviewId}")
	public void deleteReviewByIdAndReaderId(@PathVariable int readerId,@PathVariable int reviewId) {
		reviewService.deleteReviewByIdAndReaderId(reviewId,readerId);
	}
}
