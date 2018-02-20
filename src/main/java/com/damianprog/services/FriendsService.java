package com.damianprog.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.Friends;
import com.damianprog.entities.Pending;
import com.damianprog.repositories.FriendsRepository;
import com.damianprog.repositories.PendingRepository;

@Service
public class FriendsService {

	@Autowired
	FriendsRepository friendsRepository;

	@Autowired
	PendingRepository pendingRepository;

	public List<Friends> getReaderFriends(int readerId) {
		return friendsRepository.findAllReaderFriends(readerId);
	}

	public void saveFriends(Friends friends) {
		friendsRepository.save(friends);

	}

	public Friends getFriendsById(int id) {
		return friendsRepository.findOne(id);
	}

	public void deleteFriendsById(int id) {
		friendsRepository.delete(id);

	}

	public void savePending(Pending pending) {
		pendingRepository.save(pending);
	}

	public Pending getPending(int reader1, int reader2) {
		return pendingRepository.findOneByRecipentIdAndSenderId(reader1, reader2);
	}

	public List<Pending> getReaderPendings(int readerId) {
		return pendingRepository.findAllReaderPendings(readerId);
	}

	public void deletePending(int pendingId) {
		pendingRepository.delete(pendingId);
	}

	@Transactional
	public void deleteFriendsByReadersIds(int reader1, int reader2) {
		friendsRepository.deleteByReader1AndReader2(reader1, reader2);
	}

}
