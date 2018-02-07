package com.damianprog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.Reader;
import com.damianprog.repositories.ReaderRepository;

@Service
public class ReaderService {

	@Autowired
	ReaderRepository readerRepository;
	
	public Reader getReaderByUsername(String readerLogin) {
		return readerRepository.findOneByUsername(readerLogin);
	}

	public Reader getReaderById(int readerId) {
		return readerRepository.findOne(readerId);
	}

	public void saveReader(Reader reader) {
		readerRepository.save(reader);
		
	}
	
}
