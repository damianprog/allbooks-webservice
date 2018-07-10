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
	private FriendsRepository friendsRepository;

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

	@Transactional
	public void deleteFriendsByReadersIds(int reader1, int reader2) {
		friendsRepository.deleteByReader1AndReader2(reader1, reader2);
	}

	public Friends getFriendsByReader1IdAndReader2Id(int reader1Id, int reader2Id) {
		return friendsRepository.findOneFriendsByReader1IdAndReader2Id(reader1Id, reader2Id);
	}

}
