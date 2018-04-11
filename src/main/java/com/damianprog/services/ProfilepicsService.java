package com.damianprog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.ProfilePhoto;
import com.damianprog.repositories.ProfilepicsRepository;

@Service
public class ProfilepicsService {

	@Autowired
	ProfilepicsRepository profilepicsRepository;
	
	public void saveProfilepics(ProfilePhoto profilepics) {
		profilepicsRepository.save(profilepics);
	}

}
