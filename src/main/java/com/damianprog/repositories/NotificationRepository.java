package com.damianprog.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.damianprog.entities.Notification;

public interface NotificationRepository extends CrudRepository<Notification,Integer>{

	List<Notification> findAllByReaderId(int readerId);
	
	@Transactional
	void deleteByIdAndReaderId(int id,int readerId);
	
}
