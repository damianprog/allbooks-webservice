package com.damianprog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.Details;
import com.damianprog.repositories.DetailsRepository;

@Service
public class DetailsService {

	@Autowired
	private DetailsRepository detailsRepository;
	
	public void saveDetails(Details details) {
		detailsRepository.save(details);
	}
}
