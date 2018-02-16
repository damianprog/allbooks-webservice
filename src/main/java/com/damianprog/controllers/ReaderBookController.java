package com.damianprog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.Reader;
import com.damianprog.entities.ReaderBook;
import com.damianprog.services.ReaderService;
import com.damianprog.services.ReaderbookService;

@RestController
public class ReaderBookController {

	@Autowired
	ReaderbookService readerbookService;

	@Autowired
	ReaderService readerService;

	@RequestMapping("/readers/{readerId}/readerbooks/{bookId}")
	public ReaderBook getReaderBook(@PathVariable int readerId, @PathVariable int bookId) {

		return readerbookService.getReaderBook(bookId, readerId);

	}

	@RequestMapping("/readers/{readerId}/readerbooks")
	public List<ReaderBook> getReaderBooks(@PathVariable int readerId) {

		return readerbookService.getReaderBooks(readerId);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/readerbooks")
	public void saveReaderBook(@RequestBody ReaderBook readerBook) {

		Reader reader = readerService.getReaderById(readerBook.getReaderIdentity());

		readerBook.setReader(reader);

		readerbookService.saveReaderBook(readerBook);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/readerbooks")
	public void updateReaderBook(@RequestBody ReaderBook readerBook) {
		Reader reader = readerService.getReaderById(readerBook.getReaderIdentity());

		readerBook.setReader(reader);
		
		readerbookService.saveReaderBook(readerBook);
	}

}
