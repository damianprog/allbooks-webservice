package com.damianprog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.Details;
import com.damianprog.repositories.DetailsRepository;

@Service
public class DetailsService {

	@Autowired
	DetailsRepository detailsRepository;
	
	public Details getReaderDetails(int readerId) {
		return detailsRepository.findOneByReaderId(readerId);
	}
	
	public void saveDetails(Details details) {
		detailsRepository.save(details);
	}
}
