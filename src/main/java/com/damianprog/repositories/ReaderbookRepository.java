package com.damianprog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.damianprog.entities.Book;
import com.damianprog.entities.ReaderBook;

public interface ReaderbookRepository extends CrudRepository<ReaderBook,Integer> {

	ReaderBook findOneByBookIdAndReaderId(int bookId,int readerId);

	List<ReaderBook> findAllByReaderId(int readerId);
}
