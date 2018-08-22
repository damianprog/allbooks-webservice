package com.damianprog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.damianprog.entities.ReaderBook;
import com.damianprog.enumeration.ShelvesStates;
import com.damianprog.repositories.ReaderbookRepositoryJpa;

@Service
public class ReaderbookService {
	
	@Autowired
	private ReaderbookRepositoryJpa readerbookRepositoryJpa;
	
	public ReaderBook getReaderBook(int bookId,int readerId ) {
		return readerbookRepositoryJpa.findOneByBookIdAndReaderId(bookId,readerId);
	}

	public List<ReaderBook> getReaderBooks(int readerId) {
		return readerbookRepositoryJpa.findAllByReaderId(readerId);
	}

	public void saveReaderBook(ReaderBook readerBook) {
		readerbookRepositoryJpa.save(readerBook);
		
	}

	public void deleteReaderBookByReaderIdAndBookId(int readerId,int bookId) {
		readerbookRepositoryJpa.deleteByReaderIdAndBookId(readerId,bookId);
		
	}

	public ReaderBook getReaderBookById(int readerBookId) {
		return readerbookRepositoryJpa.findOne(readerBookId);
	}

	public List<ReaderBook> getReaderBooksByShelves(int readerId, ShelvesStates shelves) {
		return readerbookRepositoryJpa.findAllByReaderIdAndShelvesStates(readerId, shelves);
	}

	public Page<ReaderBook> getReaderBooksPages(int readerId, Pageable pageable) {
		return readerbookRepositoryJpa.findAllByReaderId(readerId,pageable);
	}

	public Page<ReaderBook> getReaderBooksByShelvesPages(int readerId, ShelvesStates shelves, Pageable pageable) {
		return readerbookRepositoryJpa.findAllByReaderIdAndShelvesStates(readerId,shelves,pageable);
	}

	public List<ReaderBook> find10LatestReaderBooks() {
		return readerbookRepositoryJpa.findFirst10ByOrderByIdDesc();
	}

	public List<ReaderBook> getReaderBooksByCategory(int readerId, String category) {
		return readerbookRepositoryJpa.findAllByReaderIdAndCategory(readerId,category);
	}

	public List<Integer> getReaderBooksBooksIdsByReaderIdAndCategory(int readerId, String category) {
		return readerbookRepositoryJpa.getReaderBooksBooksIdsByReaderIdAndCategory(readerId,category);
	}
	
}
