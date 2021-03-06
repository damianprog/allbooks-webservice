package com.damianprog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.Rating;
import com.damianprog.services.RatingService;

@RestController
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@RequestMapping("/ratings/{ratingId}")
	public Rating getRatingById(@PathVariable int ratingId) {
		return ratingService.getRatingById(ratingId);
	}
	
	@RequestMapping("/readers/{readerId}/books/{bookId}/ratings")
	public Rating getReaderRating(@PathVariable int readerId,@PathVariable int bookId) {
		return ratingService.getReaderRating(readerId, bookId);
	}
	
	@RequestMapping("/books/{bookId}/ratings")
	public List<Rating> getBookRatings(@PathVariable int bookId){
		return ratingService.getBookRatings(bookId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/ratings")
	public Rating submitRating(@RequestBody Rating rating) {
		return ratingService.submitRating(rating);
	}
	
	@RequestMapping("/ratings/latest")
	public List<Rating> find10LatestRatings(){
		return ratingService.findFirst10ByOrderByIdDesc();
	}
	
}
