package com.damianprog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void deleteCommentById(int commentId) {
		commentReposiotry.delete(commentId);
	}

	public void deleteCommentByIdAndReaderId(int commentId, int readerId) {
		commentReposiotry.deleteByIdAndReaderId(commentId, readerId);
	}

}
