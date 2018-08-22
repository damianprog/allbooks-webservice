package com.damianprog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.Token;
import com.damianprog.enumeration.TokenType;
import com.damianprog.repositories.TokenRepository;

@Service
public class TokenService {

	@Autowired
	private TokenRepository tokenRepository;

	public Token saveToken(Token token) {
		return tokenRepository.save(token);
	}

	public void deleteTokenByReaderId(int readerId, String tokenType) {
		
		tokenRepository.deleteByReaderIdAndTokenType(readerId,TokenType.valueOf(tokenType));
	}

	public void deleteTokenById(int tokenId) {
		tokenRepository.delete(tokenId);
	}

	public Token getTokenByReaderId(int readerId, String tokenType) {
		return tokenRepository.findOneByReaderIdAndTokenType(readerId,TokenType.valueOf(tokenType));
	}

	public Token getTokenByCredentials(int readerId, String token, TokenType tokenTypeEnum) {
		return tokenRepository.findOneByReaderIdAndTokenAndTokenType(readerId,token,tokenTypeEnum);
	}

	
}
