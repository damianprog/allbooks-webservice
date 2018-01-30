package com.damianprog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.ProfilePics;
import com.damianprog.repositories.ProfilepicsRepository;

@Service
public class ProfilepicsService {

	@Autowired
	ProfilepicsRepository profilepicsRepository;
	
	public void saveProfilepics(ProfilePics profilepics) {
		profilepicsRepository.save(profilepics);
	}

	public ProfilePics getProfilePicsByReaderId(int readerId) {
		return profilepicsRepository.findOneByReaderId(readerId);
	}
	
}
