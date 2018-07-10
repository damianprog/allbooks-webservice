package com.damianprog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.Rating;
import com.damianprog.repositories.RatingRepository;

@Service
public class RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	public Rating getReaderRating(int readerId,int bookId) {
		return ratingRepository.findOneByReaderIdAndBookId(readerId, bookId);
	}

	public List<Rating> getBookRatings(int bookId) {
		return ratingRepository.findAllByBookId(bookId);
	}

	public Rating submitRating(Rating rating) {
		return ratingRepository.save(rating);
		
	}

	public Rating getRatingById(int ratingId) {
		return ratingRepository.findOne(ratingId);
	}
	
}
