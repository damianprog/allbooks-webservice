package com.damianprog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.ProfilePhoto;
import com.damianprog.services.ProfilepicsService;

@RestController
public class ProfilePicsController {

	@Autowired
	ProfilepicsService profilepicsService;
	
	@RequestMapping(method=RequestMethod.POST,value="/profilepics")
	public void saveProfilepics(@RequestBody ProfilePhoto profilePics) {
		profilepicsService.saveProfilepics(profilePics);
	}
	
	
}
