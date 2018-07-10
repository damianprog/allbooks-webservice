package com.damianprog.controllers;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.PasswordToken;
import com.damianprog.entities.VerificationToken;
import com.damianprog.services.TokenService;

@RestController
public class TokenController {

	@Autowired
	private TokenService tokenService;
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, value = "/readers/verificationTokens")
	public VerificationToken saveVerificationToken(@RequestBody VerificationToken token) {
		return tokenService.saveVerificationToken(token);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON, value = "/verificationTokens")
	public void updateVerificationToken(@RequestBody VerificationToken token) {
		tokenService.saveVerificationToken(token);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, value = "/readers/passwordTokens")
	public PasswordToken savePasswordToken(@RequestBody PasswordToken token) {
		return tokenService.savePasswordToken(token);
	}

	@RequestMapping(method = RequestMethod.DELETE,value = "/verificationTokens/{tokenId}")
	public void deleteVerificationToken(@PathVariable int tokenId) {
		tokenService.deleteVerificationToken(tokenId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/readers/{readerId}/passwordTokens")
	public void deletePasswordToken(@PathVariable int readerId) {
		tokenService.deletePasswordToken(readerId);
	}
	
	@RequestMapping("/readers/{readerId}/verificationTokens")
	public VerificationToken getToken(@PathVariable int readerId) {
		return tokenService.getTokenByReaderId(readerId);
	}
	
	@RequestMapping("/readers/{readerId}/passwordTokens/{passwordToken}")
	public PasswordToken getPasswordTokenByCredentials(@PathVariable int readerId,@PathVariable String passwordToken) {
		return tokenService.getPasswordTokenByCredentials(readerId,passwordToken);
	}
	
	@RequestMapping("/readers/{readerId}/passwordTokens")
	public PasswordToken getPasswordToken(@PathVariable int readerId) {
		return tokenService.getPasswordTokenByReaderId(readerId);
	}
	
}
