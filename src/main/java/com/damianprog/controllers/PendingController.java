package com.damianprog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.Pending;
import com.damianprog.services.PendingService;

@RestController
public class PendingController {

	@Autowired
	private PendingService pendingService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/friends/pendings")
	public void savePending(@RequestBody Pending pending) {
		pendingService.savePending(pending);
	}

	@RequestMapping("/readers/{reader1}/friends/{reader2}/pendings")
	public Pending getPendingWithRecipentIdAndSenderId(@PathVariable("reader1") int reader1,
			@PathVariable("reader2") int reader2) {
		return pendingService.getPendingWithRecipentIdAndSenderId(reader1, reader2);
	}

	@RequestMapping("/pendings/readers/{recipentId}/{senderId}")
	public Pending getPendingByRecipentIdAndSenderId(@PathVariable("recipentId") int recipentId,
			@PathVariable("senderId") int senderId) {
		return pendingService.getPendingByRecipentIdAndSenderId(recipentId, senderId);
	}

	@RequestMapping("/readers/{readerId}/friends/pendings")
	public List<Pending> getReaderPendings(@PathVariable int readerId) {
		return pendingService.getReaderPendings(readerId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/pendings/{pendingId}")
	public void deletePending(@PathVariable("pendingId") int pendingId) {
		pendingService.deletePending(pendingId);
	}
	
}
