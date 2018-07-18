package com.damianprog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.damianprog.entities.ReadingChallange;

public interface ReadingChallangeRepository extends CrudRepository<ReadingChallange,Integer>{

	ReadingChallange findOneByReaderId(int readerId);
	
}
