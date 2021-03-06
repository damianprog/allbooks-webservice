package com.damianprog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.Details;
import com.damianprog.services.DetailsService;

@RestController
public class DetailsController {

	@Autowired
	private DetailsService detailsService;
	
	@RequestMapping(method=RequestMethod.PUT,value="/details")
	public void saveDetails(@RequestBody Details details) {
		detailsService.saveDetails(details);
	}
}
