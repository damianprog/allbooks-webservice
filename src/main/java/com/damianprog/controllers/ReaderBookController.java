package com.damianprog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.ReaderBook;
import com.damianprog.entities.ShelvesStates;
import com.damianprog.services.ReaderService;
import com.damianprog.services.ReaderbookService;

@RestController
public class ReaderBookController {

	@Autowired
	private ReaderbookService readerbookService;

	@Autowired
	private ReaderService readerService;

	@RequestMapping("/readers/{readerId}/readerbooks/{bookId}")
	public ReaderBook getReaderBook(@PathVariable int readerId, @PathVariable int bookId) {

		return readerbookService.getReaderBook(bookId, readerId);

	}

	@RequestMapping("/readerbooks/{readerBookId}")
	public ReaderBook getReaderBookById(@PathVariable int readerBookId) {

		return readerbookService.getReaderBookById(readerBookId);

	}
	
	@RequestMapping("/readers/{readerId}/readerbooks")
	public List<ReaderBook> getReaderBooks(@PathVariable int readerId) {

		return readerbookService.getReaderBooks(readerId);

	}

	@RequestMapping("/readers/{readerId}/readerbooks/shelves/{shelves}")
	public List<ReaderBook> getReaderBooksByShelves(@PathVariable int readerId,@PathVariable String shelves) {

		ShelvesStates shelvesState = ShelvesStates.enumValueOf(shelves);
		
		return readerbookService.getReaderBooksByShelves(readerId,shelvesState);

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/readerbooks")
	public void saveReaderBook(@RequestBody ReaderBook readerBook) {

		readerbookService.saveReaderBook(readerBook);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/readerbooks")
	public void updateReaderBook(@RequestBody ReaderBook readerBook) {
		
		readerbookService.saveReaderBook(readerBook);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/readers/{readerId}/readerbooks/books/{bookId}")
	public void deleteReaderBookByReaderIdAndBookId(@PathVariable int readerId,@PathVariable int bookId) {
		readerbookService.deleteReaderBookByReaderIdAndBookId(readerId,bookId);
	}
	
	@RequestMapping("/readers/{readerId}/readerbooks/pages/{page}")
	public Page<ReaderBook> getReaderBooksPages(@PathVariable int readerId,@PathVariable int page){
		return readerbookService.getReaderBooksPages(readerId,new PageRequest(page-1,10));
	}
	
	@RequestMapping("/readers/{readerId}/readerbooks/shelves/{shelves}/pages/{page}")
	public Page<ReaderBook> getReaderBooksByShelvesPages(@PathVariable int readerId,@PathVariable String shelves,@PathVariable int page){
		
		ShelvesStates shelvesState = ShelvesStates.enumValueOf(shelves);
		
		return readerbookService.getReaderBooksByShelvesPages(readerId,shelvesState,new PageRequest(page-1,10));
	}
}
