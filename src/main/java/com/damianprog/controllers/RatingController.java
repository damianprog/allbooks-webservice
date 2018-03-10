package com.damianprog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.Rating;
import com.damianprog.entities.Reader;
import com.damianprog.services.RatingService;
import com.damianprog.services.ReaderService;

@RestController
public class RatingController {

	@Autowired
	RatingService ratingService;
	
	@Autowired
	ReaderService readerService;
	
	@RequestMapping("/readers/{readerId}/books/{bookId}/ratings")
	public Rating getReaderRating(@PathVariable int readerId,@PathVariable int bookId) {
		
		return ratingService.getReaderRating(readerId, bookId);
		
	}
	
	@RequestMapping("/books/{bookId}/ratings")
	public List<Rating> getBookRatings(@PathVariable int bookId){
		return ratingService.getBookRatings(bookId);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/ratings")
	public void submitRating(@RequestBody Rating rating) {
		ratingService.submitRating(rating);
	}
	
}
