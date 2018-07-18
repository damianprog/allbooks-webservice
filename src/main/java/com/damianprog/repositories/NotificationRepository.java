package com.damianprog.repositories;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.damianprog.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification,Integer>{

	Page<Notification> findAllByReaderId(int readerId,Pageable pageRequest);
	
	@Transactional
	void deleteByIdAndReaderId(int id,int readerId);
	
}
