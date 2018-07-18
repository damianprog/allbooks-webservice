package com.damianprog.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.damianprog.entities.Comment;

public interface CommentRepository extends CrudRepository<Comment,Integer> {

	List<Comment> findAllByReviewId(int reviewId);

	List<Comment> findAllByPostingReaderIdAndBookId(int postingReaderId, int bookId);

	@Transactional
	void deleteByIdAndPostingReaderId(int id,int postingReaderId);
}
