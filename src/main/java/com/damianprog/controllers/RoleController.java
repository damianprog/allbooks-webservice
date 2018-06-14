package com.damianprog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.ReaderRole;
import com.damianprog.entities.Role;
import com.damianprog.services.RoleService;

@RestController
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@RequestMapping("/roles/names/{role}")
	public Role getRoleByName(@PathVariable String role) {
		return roleService.getRoleByRole(role);
	}
	
	@RequestMapping("/roles/{id}")
	public Role getRoleById(@PathVariable int id) {
		return roleService.getRoleById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/readerrole")
	public void createReaderRole (@RequestBody ReaderRole readerRole) {
		roleService.createReaderRole(readerRole);
	}
}
