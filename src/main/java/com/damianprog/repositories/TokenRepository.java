package com.damianprog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.damianprog.entities.VerificationToken;

public interface TokenRepository extends CrudRepository<VerificationToken,Integer> {

	VerificationToken findOneByReaderId(int readerId);
	
}
