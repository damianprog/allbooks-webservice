package com.damianprog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.ReadingChallange;
import com.damianprog.services.ReadingChallangeService;

@RestController
public class ReadingChallangeController {

	@Autowired
	private ReadingChallangeService readingChallangeService;
	
	@RequestMapping(method = RequestMethod.POST,value = "/readingChallanges")
	public void saveReadingChallange(@RequestBody ReadingChallange readingChallange) {
		readingChallangeService.saveReadingChallange(readingChallange);
	}
	
	
	@RequestMapping("/readingChallanges/{readingChallangeId}")
	public ReadingChallange getReadingChallangeById(@PathVariable int readingChallangeId) {
		return readingChallangeService.getReadingChallangeById(readingChallangeId);
	}
	
	@RequestMapping("/readers/{readerId}/readingChallanges")
	public ReadingChallange getReadingChallangeByReaderId(@PathVariable int readerId) {
		return readingChallangeService.getReadingChallangeByReaderId(readerId);
	}
	
}
