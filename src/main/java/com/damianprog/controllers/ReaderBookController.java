package com.damianprog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.ReaderBook;
import com.damianprog.services.ReaderbookService;

@RestController
public class ReaderBookController {

	@Autowired
	ReaderbookService readerbookService;

	@RequestMapping("/readers/{readerId}/readerbooks/{bookId}")
	public ReaderBook getReaderBook(@PathVariable int readerId, @PathVariable int bookId) {

		return readerbookService.getReaderBook(bookId, readerId);

	}

	@RequestMapping("/readers/{readerId}/readerbooks")
	public List<ReaderBook> getReaderBooks(@PathVariable int readerId) {

		return readerbookService.getReaderBooks(readerId);

	}

	@RequestMapping(method=RequestMethod.PUT,value="/readerbooks")
	public void saveReaderBook(@RequestBody ReaderBook readerBook) {
		readerbookService.saveReaderBook(readerBook);
	}
	
}
