package com.damianprog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.Like;
import com.damianprog.services.LikeService;

@RestController
public class LikeController {

	@Autowired
	private LikeService likeService;
	
	@RequestMapping("/review/{reviewId}/likes/readers/{readerId}")
	public Like getLikeByReviewIdAndReaderId(@PathVariable int reviewId,@PathVariable int readerId) {
		
		return likeService.getLikeByReviewIdAndReaderId(reviewId,readerId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/likes/{likeId}")
	public void deleteLikeById(@PathVariable int likeId) {
		
		likeService.deleteLikeById(likeId);
	}
	
}
