package com.damianprog.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.damianprog.entities.Comment;

public interface CommentRepository extends CrudRepository<Comment,Integer> {

	List<Comment> findAllByReviewIdentity(int reviewId);
}
