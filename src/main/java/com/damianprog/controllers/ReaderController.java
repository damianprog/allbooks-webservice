package com.damianprog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.Reader;
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
	
	@RequestMapping(method=RequestMethod.POST, value="/readers")
	public void saveReader(@RequestBody Reader reader) {
		readerService.saveReader(reader);
	}
	
	
}
