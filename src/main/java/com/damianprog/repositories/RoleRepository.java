package com.damianprog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.damianprog.entities.Role;

public interface RoleRepository extends CrudRepository<Role,Integer> {

	Role getRoleByRole(String role);
	
}
