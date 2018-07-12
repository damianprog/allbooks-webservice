package com.damianprog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.Notification;
import com.damianprog.services.NotificationService;

@RestController
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	@RequestMapping("/notifications/{notificationId}")
	public Notification getNotificationById(@PathVariable int notificationId) {
		return notificationService.getNotificationById(notificationId);
	}

	@RequestMapping(method = RequestMethod.DELETE,value = "/readers/{readerId}/notifications/{notificationId}")
	public void deleteNotificationByReaderIdAndNotificationId(@PathVariable int readerId,
			@PathVariable int notificationId) {
		notificationService.deleteNotificationByNotificationIdAndReaderId(notificationId,readerId);
	}

	@RequestMapping("/readers/{readerId}/notifications")
	public List<Notification> getNotificationsByReaderId(@PathVariable int readerId) {
		return notificationService.getNotificationsByReaderId(readerId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/notifications/{notificationId}")
	public void deleteNotificationById(@PathVariable int notificationId) {
		notificationService.deleteNotificationById(notificationId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/notifications")
	public void saveNotification(@RequestBody Notification notification) {
		notificationService.saveNotification(notification);
	}

}
