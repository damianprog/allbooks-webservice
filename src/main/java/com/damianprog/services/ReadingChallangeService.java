package com.damianprog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.ReadingChallange;
import com.damianprog.repositories.ReadingChallangeRepository;

@Service
public class ReadingChallangeService {

	@Autowired
	private ReadingChallangeRepository readingChallangeRepository;
	
	public void saveReadingChallange(ReadingChallange readingChallange) {
		readingChallangeRepository.save(readingChallange);
	}

	public ReadingChallange getReadingChallangeById(int readingChallangeId) {
		return readingChallangeRepository.findOne(readingChallangeId);
	}

	public ReadingChallange getReadingChallangeByReaderId(int readerId) {
		return readingChallangeRepository.findOneByReaderId(readerId);
	}

	
	
}
