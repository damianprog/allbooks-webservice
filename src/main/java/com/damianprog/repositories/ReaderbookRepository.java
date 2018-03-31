package com.damianprog.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.damianprog.entities.ReaderBook;

public interface ReaderbookRepository extends CrudRepository<ReaderBook,Integer> {

	ReaderBook findOneByBookIdAndReaderId(int bookId,int readerId);

	List<ReaderBook> findAllByReaderId(int readerId);
	
	@Transactional
	public void deleteByReaderIdAndBookId(int readerId,int bookId);
}
