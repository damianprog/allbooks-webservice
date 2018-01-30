package com.damianprog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.ProfilePics;
import com.damianprog.services.ProfilepicsService;

@RestController
public class ProfilePicsController {

	@Autowired
	ProfilepicsService profilepicsService;
	
	@RequestMapping(method=RequestMethod.POST,value="/profilepics")
	public void saveProfilepics(@RequestBody ProfilePics profilePics) {
		profilepicsService.saveProfilepics(profilePics);
	}
	
	@RequestMapping("/readers/{readerId}/profilepics")
	public ProfilePics getProfilePics(@PathVariable int readerId) {
		return profilepicsService.getProfilePicsByReaderId(readerId);
	}
	
}
