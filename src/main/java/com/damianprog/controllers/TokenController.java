package com.damianprog.controllers;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.Token;
import com.damianprog.enumeration.TokenType;
import com.damianprog.services.TokenService;

@RestController
public class TokenController {

	@Autowired
	private TokenService tokenService;
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, value = "/tokens")
	public Token saveToken(@RequestBody Token token) {
		return tokenService.saveToken(token);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON, value = "/tokens")
	public void updateToken(@RequestBody Token token) {
		tokenService.saveToken(token);
	}

	@RequestMapping(method = RequestMethod.DELETE,value = "/readers/{readerId}/tokens/types/{tokenType}")
	public void deleteTokenByReaderId(@PathVariable int readerId,@PathVariable String tokenType) {
		tokenService.deleteTokenByReaderId(readerId,tokenType);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/tokens/{tokenId}")
	public void deleteTokenById(@PathVariable int tokenId) {
		tokenService.deleteTokenById(tokenId);
	}
	
	@RequestMapping("/readers/{readerId}/tokens/types/{tokenType}")
	public Token getTokenByReaderId(@PathVariable int readerId,@PathVariable String tokenType) {
		return tokenService.getTokenByReaderId(readerId,tokenType);
	}
	
	@RequestMapping("/readers/{readerId}/tokens/{token}/types/{tokenType}")
	public Token getTokenByCredentials(@PathVariable int readerId,@PathVariable String token,@PathVariable String tokenType) {
		
		TokenType tokenTypeEnum = TokenType.valueOf(tokenType);
		
		return tokenService.getTokenByCredentials(readerId,token,tokenTypeEnum);
	}
	
}
