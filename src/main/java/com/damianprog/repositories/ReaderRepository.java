package com.damianprog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.damianprog.entities.Reader;

public interface ReaderRepository extends CrudRepository<Reader,Integer> {

	Reader findOneByUsername(String username);
	Reader findOneByEmail(String email);
	
}
