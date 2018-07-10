package com.damianprog.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.damianprog.entities.ReaderBook;
import com.damianprog.entities.ShelvesStates;

public interface ReaderbookRepository extends CrudRepository<ReaderBook,Integer> {

	ReaderBook findOneByBookIdAndReaderId(int bookId,int readerId);

	List<ReaderBook> findAllByReaderId(int readerId);
	
	List<ReaderBook> findAllByReaderIdAndShelvesStates(int readerId,ShelvesStates shelvesStates);
	
	@Transactional
	void deleteByReaderIdAndBookId(int readerId,int bookId);
	
}
