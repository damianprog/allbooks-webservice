package com.damianprog.services;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.Comment;
import com.damianprog.repositories.CommentRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentReposiotry;
	
	public List<Comment> getReviewComments(int reviewId) {
		return commentReposiotry.findAllByReviewId(reviewId);
	}

	public void postComment(Comment comment) {
		commentReposiotry.save(comment);
	}

}
