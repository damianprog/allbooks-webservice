package com.damianprog.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.PasswordToken;
import com.damianprog.entities.VerificationToken;
import com.damianprog.repositories.PasswordTokenRepository;
import com.damianprog.repositories.TokenRepository;

@Service
public class TokenService {

	@Autowired
	TokenRepository tokenRepository;

	@Autowired
	PasswordTokenRepository passwordTokenRepository;

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

	public void saveVerificationToken(VerificationToken token) {
		tokenRepository.save(token);
	}

	public void deleteVerificationToken(int tokenId) {
		tokenRepository.delete(tokenId);
	}

}
