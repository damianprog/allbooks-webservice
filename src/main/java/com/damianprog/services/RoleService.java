package com.damianprog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.ReaderRole;
import com.damianprog.entities.Role;
import com.damianprog.repositories.ReaderRoleRepository;
import com.damianprog.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	ReaderRoleRepository readerRoleRepository;

	public Role getRoleByRole(String role) {
		return roleRepository.getRoleByRole(role);
	}

	public Role getRoleById(int id) {
		return roleRepository.findOne(id);
	}

	public void createReaderRole(ReaderRole readerRole) {
		readerRoleRepository.save(readerRole);
	}
	
	
	
}
