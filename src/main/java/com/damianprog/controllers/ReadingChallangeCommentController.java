package com.damianprog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.ReadingChallangeComment;
import com.damianprog.services.ReadingChallangeCommentService;

@RestController
public class ReadingChallangeCommentController {

	@Autowired
	private ReadingChallangeCommentService readingChallangeCommentService;

	@RequestMapping(method = RequestMethod.PUT,value = "/readingChallangeComments")
	public void saveReadingChallangeComment(@RequestBody ReadingChallangeComment readingChallangeComment) {
		readingChallangeCommentService.saveReadingChallangeComment(readingChallangeComment);
	}

	@RequestMapping("/readers/{challangeReaderId}/readingChallange/readingChallangeComments")
	public List<ReadingChallangeComment> getReadingChallangeCommentsByChallangeReaderId(
			@PathVariable int challangeReaderId) {
		return readingChallangeCommentService.getReadingChallangeCommentsByChallangeReaderId(challangeReaderId);
	}

	@RequestMapping("/readingChallangeComments/{commentId}")
	public ReadingChallangeComment getReadingChallangeCommentById(@PathVariable int commentId) {
		return readingChallangeCommentService.getReadingChallangeCommentById(commentId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/readingChallangeComments/{commentId}")
	public void deleteReadingChallangeCommentById(@PathVariable int commentId) {
		readingChallangeCommentService.deleteReadingChallangeCommentById(commentId);
	}
	
}
