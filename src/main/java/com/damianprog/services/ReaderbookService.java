package com.damianprog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.damianprog.entities.Book;
import com.damianprog.entities.ReaderBook;
import com.damianprog.repositories.ReaderbookRepository;

@Service
public class ReaderbookService {

	@Autowired
	ReaderbookRepository readerbookRepository;
	
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
	
}
