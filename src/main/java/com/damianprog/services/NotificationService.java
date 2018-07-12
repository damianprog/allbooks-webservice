package com.damianprog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	public List<Notification> getNotificationsByReaderId(int readerId) {
		return notificationRepository.findAllByReaderId(readerId);
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
