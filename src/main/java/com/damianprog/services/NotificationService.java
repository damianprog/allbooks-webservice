package com.damianprog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.damianprog.entities.Notification;
import com.damianprog.repositories.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;
	
	public Notification getNotificationById(int notificationId) {
		return notificationRepository.findOne(notificationId);
	}

	public Page<Notification> getNotificationsByReaderId(int readerId,Pageable pageable) {
		return notificationRepository.findAllByReaderId(readerId,pageable);
	}

	public void deleteNotificationById(int notificationId) {
		notificationRepository.delete(notificationId);
	}

	public void saveNotification(Notification notification) {
		notificationRepository.save(notification);
	}

	public void deleteNotificationByNotificationIdAndReaderId(int notificationId,int readerId) {
		notificationRepository.deleteByIdAndReaderId(notificationId, readerId);
	}

	
	
}
