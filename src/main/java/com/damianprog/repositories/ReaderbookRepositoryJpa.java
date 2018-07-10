package com.damianprog.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.damianprog.entities.Book;
import com.damianprog.entities.ReaderBook;
import com.damianprog.entities.ShelvesStates;

public interface ReaderbookRepositoryJpa extends JpaRepository<ReaderBook,Integer>{

	Page<ReaderBook> findAllByReaderId(int readerId, Pageable pageable);

	Page<ReaderBook> findAllByReaderIdAndShelvesStates(int readerId, ShelvesStates shelvesStates, Pageable pageable);

	
}
