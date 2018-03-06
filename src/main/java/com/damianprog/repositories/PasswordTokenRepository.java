package com.damianprog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.damianprog.entities.PasswordToken;

public interface PasswordTokenRepository extends CrudRepository<PasswordToken,Integer> {
	PasswordToken findOneByReaderId(int readerId);
	
	PasswordToken findOneByReaderIdAndToken(int readerId,String token);
	
	void deleteByReaderId(int readerId);
}
