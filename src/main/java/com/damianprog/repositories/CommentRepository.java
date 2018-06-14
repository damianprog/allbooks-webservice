package com.damianprog.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.damianprog.entities.Comment;

public interface CommentRepository extends CrudRepository<Comment,Integer> {

	List<Comment> findAllByReviewId(int reviewId);

	List<Comment> findAllByReaderIdAndBookId(int readerId, int bookId);
}
