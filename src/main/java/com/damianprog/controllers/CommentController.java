package com.damianprog.controllers;

import java.util.List;

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
	private CommentService commentService;

	@RequestMapping("/comments/{commentId}")
	public Comment getCommentById(@PathVariable int commentId) {
		return commentService.getCommentById(commentId);
	}

	
	@RequestMapping("/reviews/{reviewId}/comments")
	public List<Comment> getReviewComments(@PathVariable int reviewId) {
		return commentService.getReviewComments(reviewId);
	}

	@RequestMapping("/readers/{readerId}/books/{bookId}/reviews/comments")
	public List<Comment> getCommentsByReaderIdAndBookId(@PathVariable int readerId, @PathVariable int bookId) {
		return commentService.getCommentsByReaderIdAndBookId(readerId,bookId);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/comments")
	public void postComment(@RequestBody Comment comment) {
		commentService.postComment(comment);
	}

	@RequestMapping(method = RequestMethod.DELETE,value = "/comments/{commentId}")
	public void deleteCommentById(@PathVariable int commentId) {
		commentService.deleteCommentById(commentId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/readers/{readerId}/comments/{commentId}")
	public void deleteCommentByIdAndReaderId(@PathVariable int readerId,@PathVariable int commentId) {
		commentService.deleteCommentByIdAndReaderId(commentId,readerId);
	}
}
