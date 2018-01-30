package com.damianprog.controllers;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.Comment;
import com.damianprog.services.CommentService;

@RestController
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@RequestMapping("/reviews/{reviewId}/comments")
	public List<Comment> getReviewComments(@PathVariable int reviewId){
		return commentService.getReviewComments(reviewId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/comments")
	public void postComment (@RequestBody Comment comment) {
		commentService.postComment(comment);
	}
	
}
