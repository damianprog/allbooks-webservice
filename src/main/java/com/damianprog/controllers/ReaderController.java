package com.damianprog.controllers;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.Reader;
import com.damianprog.entities.VerificationToken;
import com.damianprog.services.ReaderService;

@RestController
public class ReaderController {

	@Autowired
	ReaderService readerService;

	@RequestMapping("/readers/logins/{readerLogin}")
	public Reader getReaderByLogin(@PathVariable String readerLogin) {
		return readerService.getReaderByUsername(readerLogin);
	}

	@RequestMapping("/readers/{readerId}")
	public Reader getReaderById(@PathVariable int readerId) {
		return readerService.getReaderById(readerId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/readers")
	public void saveReader(@RequestBody Reader reader) {
		readerService.saveReader(reader);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/readers")
	public void updateReader(@RequestBody Reader reader) {
		readerService.saveReader(reader);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/readers/{readerId}")
	public void deleteReaderById(@PathVariable int readerId) {
		readerService.deleteReaderById(readerId);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, value = "/readers/verificationTokens")
	public void saveVerificationToken(@RequestBody VerificationToken token) {
		readerService.saveVerificationToken(token);
	}

	@RequestMapping(method = RequestMethod.DELETE,value = "/readers/verificationTokens/{tokenId}")
	public void deleteVerificationToken(@PathVariable int tokenId) {
		readerService.deleteVerificationToken(tokenId);
	}
	
	@RequestMapping("/readers/{readerId}/verificationTokens")
	public VerificationToken getToken(@PathVariable int readerId) {
		return readerService.getTokenByReaderId(readerId);
	}
	
}
