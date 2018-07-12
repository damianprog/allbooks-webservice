package com.damianprog.repositories;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.damianprog.entities.Ban;

public interface BanRepository extends JpaRepository<Ban,Integer>{

	Ban findOneByReaderId(int readerId);
	
	@Transactional
	void deleteByReaderId(int readerId);
	
	Page<Ban> findAll(Pageable pageRequest);
	
}
