package com.damianprog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.Rating;
import com.damianprog.repositories.RatingRepository;

@Service
public class RatingService {

	@Autowired
	RatingRepository ratingRepository;
	
	public Rating getReaderRating(int readerId,int bookId) {
		return ratingRepository.findOneByReaderIdAndBookId(readerId, bookId);
	}

	public List<Rating> getBookRatings(int bookId) {
		return ratingRepository.findAllByBookId(bookId);
	}

	public void submitRating(Rating rating) {
		ratingRepository.save(rating);
		
	}
	
}
