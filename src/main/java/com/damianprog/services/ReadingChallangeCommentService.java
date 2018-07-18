package com.damianprog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.ReadingChallangeComment;
import com.damianprog.repositories.ReadingChallangeCommentRepository;

@Service
public class ReadingChallangeCommentService {

	@Autowired
	private ReadingChallangeCommentRepository readingChallangeCommentRepository;

	public void saveReadingChallangeComment(ReadingChallangeComment readingChallangeComment) {
		readingChallangeCommentRepository.save(readingChallangeComment);
	}

	public List<ReadingChallangeComment> getReadingChallangeCommentsByChallangeReaderId(int challangeReaderId) {
		return readingChallangeCommentRepository.findAllByChallangeReaderId(challangeReaderId);
	}

	public ReadingChallangeComment getReadingChallangeCommentById(int commentId) {
		return readingChallangeCommentRepository.findOne(commentId);
	}

	public void deleteReadingChallangeCommentById(int commentId) {
		readingChallangeCommentRepository.delete(commentId);
	}
	
	
	
}
