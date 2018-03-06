package com.damianprog.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.PasswordToken;
import com.damianprog.entities.Reader;
import com.damianprog.entities.VerificationToken;
import com.damianprog.repositories.PasswordTokenRepository;
import com.damianprog.repositories.ReaderRepository;
import com.damianprog.repositories.TokenRepository;

@Service
public class ReaderService {

	@Autowired
	ReaderRepository readerRepository;
	
	@Autowired
	TokenRepository tokenRepository;
	
	@Autowired
	PasswordTokenRepository passwordTokenRepository;
	
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

	public Reader getReaderByEmail(String email) {
		return readerRepository.findOneByEmail(email);
	}
	
	public VerificationToken getTokenByReaderId(int readerId) {
		return tokenRepository.findOneByReaderId(readerId);
	}

	public PasswordToken getPasswordTokenByReaderId(int readerId) {
		return passwordTokenRepository.findOneByReaderId(readerId);
	}

	public void savePasswordToken(PasswordToken token) {
		passwordTokenRepository.save(token);
	}

	public PasswordToken getPasswordTokenByCredentials(int readerId, String passwordToken) {
		return passwordTokenRepository.findOneByReaderIdAndToken(readerId, passwordToken);
	}

	@Transactional
	public void deletePasswordToken(int readerId) {
		passwordTokenRepository.deleteByReaderId(readerId);
	}
	
}
