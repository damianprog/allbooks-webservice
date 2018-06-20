package com.damianprog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.Pending;
import com.damianprog.repositories.PendingRepository;

@Service
public class PendingService {

	@Autowired
	private PendingRepository pendingRepository;
	
	public void savePending(Pending pending) {
		pendingRepository.save(pending);
	}

	public Pending getPendingWithRecipentIdAndSenderId(int reader1, int reader2) {
		return pendingRepository.findOneWithRecipentIdAndSenderId(reader1, reader2);
	}

	public Pending getPendingByRecipentIdAndSenderId(int recipentId, int senderId) {
		return pendingRepository.findOneByRecipentIdAndSenderId(recipentId, senderId);
	}

	public List<Pending> getReaderPendings(int readerId) {
		return pendingRepository.findAllReaderPendings(readerId);
	}

	public void deletePending(int pendingId) {
		pendingRepository.delete(pendingId);
	}

	
}
