package com.damianprog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.Reader;
import com.damianprog.repositories.ReaderRepository;

@Service
public class ReaderService {

	@Autowired
	private ReaderRepository readerRepository;

	public Reader getReaderByUsername(String readerLogin) {
		return readerRepository.findOneByUsername(readerLogin);
	}

	public Reader getReaderById(int readerId) {
		return readerRepository.findOne(readerId);
	}

	public Reader saveReader(Reader reader) {
		return readerRepository.save(reader);

	}

	public void deleteReaderById(int readerId) {
		readerRepository.delete(readerId);
	}

	public Reader getReaderByEmail(String email) {
		return readerRepository.findOneByEmail(email);
	}

}
