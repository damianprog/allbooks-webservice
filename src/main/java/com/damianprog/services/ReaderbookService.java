package com.damianprog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.damianprog.entities.ReaderBook;
import com.damianprog.entities.ShelvesStates;
import com.damianprog.repositories.ReaderbookRepository;
import com.damianprog.repositories.ReaderbookRepositoryJpa;

@Service
public class ReaderbookService {

	@Autowired
	private ReaderbookRepository readerbookRepository;
	
	@Autowired
	private ReaderbookRepositoryJpa readerbookRepositoryJpa;
	
	public ReaderBook getReaderBook(int bookId,int readerId ) {
		return readerbookRepository.findOneByBookIdAndReaderId(bookId,readerId);
	}

	public List<ReaderBook> getReaderBooks(int readerId) {
		return readerbookRepository.findAllByReaderId(readerId);
	}

	public void saveReaderBook(ReaderBook readerBook) {
		readerbookRepository.save(readerBook);
		
	}

	public void deleteReaderBookByReaderIdAndBookId(int readerId,int bookId) {
		readerbookRepository.deleteByReaderIdAndBookId(readerId,bookId);
		
	}

	public ReaderBook getReaderBookById(int readerBookId) {
		return readerbookRepository.findOne(readerBookId);
	}

	public List<ReaderBook> getReaderBooksByShelves(int readerId, ShelvesStates shelves) {
		return readerbookRepository.findAllByReaderIdAndShelvesStates(readerId, shelves);
	}

	public Page<ReaderBook> getReaderBooksPages(int readerId, Pageable pageable) {
		return readerbookRepositoryJpa.findAllByReaderId(readerId,pageable);
	}

	public Page<ReaderBook> getReaderBooksByShelvesPages(int readerId, ShelvesStates shelves, Pageable pageable) {
		return readerbookRepositoryJpa.findAllByReaderIdAndShelvesStates(readerId,shelves,pageable);
	}
	
}
