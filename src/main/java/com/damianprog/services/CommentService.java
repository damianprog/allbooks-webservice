package com.damianprog.services;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.damianprog.entities.Comment;
import com.damianprog.repositories.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentReposiotry;
	
	public List<Comment> getReviewComments(int reviewId) {
		return commentReposiotry.findAllByReviewId(reviewId);
	}

	public List<Comment> getCommentsByReaderIdAndBookId(int readerId, int bookId) {
		return commentReposiotry.findAllByReaderIdAndBookId(readerId,bookId);
	}

	
	public void postComment(Comment comment) {
		commentReposiotry.save(comment);
	}

	public Comment getCommentById(int commentId) {
		return commentReposiotry.findOne(commentId);
	}

}
