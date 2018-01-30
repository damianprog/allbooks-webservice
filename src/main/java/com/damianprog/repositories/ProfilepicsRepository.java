package com.damianprog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.damianprog.entities.ProfilePics;

public interface ProfilepicsRepository extends CrudRepository<ProfilePics,Integer> {

	ProfilePics findOneByReaderId(int readerId);

	
}
