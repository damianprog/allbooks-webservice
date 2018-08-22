package com.damianprog.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.damianprog.entities.Token;
import com.damianprog.enumeration.TokenType;

public interface TokenRepository extends CrudRepository<Token,Integer> {

	@Transactional
	void deleteByReaderIdAndTokenType(int readerId, TokenType tokenType);

	Token findOneByReaderIdAndTokenType(int readerId, TokenType tokenType);

	Token findOneByReaderIdAndToken(int readerId, String token);

	Token findOneByReaderIdAndTokenAndTokenType(int readerId, String token, TokenType tokenType);	
	
}
