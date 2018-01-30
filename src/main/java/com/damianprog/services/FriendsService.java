package com.damianprog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.Friends;
import com.damianprog.repositories.FriendsRepository;

@Service
public class FriendsService {

	@Autowired
	FriendsRepository friendsRepository;

	public List<Friends> getReaderFriends(int readerId) {
		return friendsRepository.findAllReaderFriends(readerId);
	}

	public void saveFriends(Friends friends) {
		friendsRepository.save(friends);

	}

	public Friends getFriendsById(int id) {
		return friendsRepository.findOne(id);
	}

	public void deleteFriends(int id) {
		friendsRepository.delete(id);
		
	}

}
