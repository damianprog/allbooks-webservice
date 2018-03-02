package com.damianprog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.Pending;
import com.damianprog.entities.Reader;
import com.damianprog.entities.VerificationToken;
import com.damianprog.repositories.PendingRepository;
import com.damianprog.repositories.ReaderRepository;
import com.damianprog.repositories.TokenRepository;

@Service
public class ReaderService {

	@Autowired
	ReaderRepository readerRepository;
	
	@Autowired
	TokenRepository tokenRepository;
	
	public Reader getReaderByUsername(String readerLogin) {
		return readerRepository.findOneByUsername(readerLogin);
	}

	public Reader getReaderById(int readerId) {
		return readerRepository.findOne(readerId);
	}

	public void saveReader(Reader reader) {
		readerRepository.save(reader);
		
	}

	public void deleteReaderById(int readerId) {
		readerRepository.delete(readerId);
	}

	public void saveVerificationToken(VerificationToken token) {
		tokenRepository.save(token);
	}

	public void deleteVerificationToken(int tokenId) {
		tokenRepository.delete(tokenId);
	}

	public VerificationToken getTokenByReaderId(int readerId) {
		return tokenRepository.findOneByReaderId(readerId);
	}
	
}
