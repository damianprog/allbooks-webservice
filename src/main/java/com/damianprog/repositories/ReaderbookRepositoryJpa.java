package com.damianprog.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.damianprog.entities.ReaderBook;
import com.damianprog.enumeration.ShelvesStates;

public interface ReaderbookRepositoryJpa extends JpaRepository<ReaderBook,Integer>{

	Page<ReaderBook> findAllByReaderId(int readerId, Pageable pageable);

	Page<ReaderBook> findAllByReaderIdAndShelvesStates(int readerId, ShelvesStates shelvesStates, Pageable pageable);

	ReaderBook findOneByBookIdAndReaderId(int bookId,int readerId);

	List<ReaderBook> findAllByReaderId(int readerId);
	
	List<ReaderBook> findAllByReaderIdAndShelvesStates(int readerId,ShelvesStates shelvesStates);
	
	@Transactional
	void deleteByReaderIdAndBookId(int readerId,int bookId);
	
	List<ReaderBook> findFirst10ByOrderByIdDesc();

	@Query("select rb from ReaderBook rb where rb.reader.id=:readerId and rb.book.category=:category")
	List<ReaderBook> findAllByReaderIdAndCategory(@Param("readerId") int readerId,@Param("category") String category);

	@Query("select rb.book.id from ReaderBook rb where rb.reader.id=:readerId and rb.book.category=:category")
	List<Integer> getReaderBooksBooksIdsByReaderIdAndCategory(@Param("readerId") int readerId,@Param("category") String category);
	
}
