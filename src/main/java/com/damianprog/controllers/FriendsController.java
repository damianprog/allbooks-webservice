package com.damianprog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.Friends;
import com.damianprog.entities.Pending;
import com.damianprog.services.FriendsService;

@RestController
public class FriendsController {

	@Autowired
	private FriendsService friendsService;

	@RequestMapping("/friends/{id}")
	public Friends getFriendsById(@PathVariable("id") int id) {
		return friendsService.getFriendsById(id);
	}

	@RequestMapping("/readers/{readerId}/friends")
	public List<Friends> getReaderFriends(@PathVariable int readerId) {
		return friendsService.getReaderFriends(readerId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/readers/{reader1Id}/friends/readers/{reader2Id}")
	public Friends getFriendsByReader1IdAndReader2Id(@PathVariable int reader1Id, @PathVariable int reader2Id) {
		return friendsService.getFriendsByReader1IdAndReader2Id(reader1Id, reader2Id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/friends")
	public void saveFriends(@RequestBody Friends friends) {
		friendsService.saveFriends(friends);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/friends/{friendsId}")
	public void deleteFriends(@PathVariable("friendsId") int id) {
		friendsService.deleteFriendsById(id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/readers/{reader1Id}/friends/readers/{reader2Id}")
	public void deleteFriends(@PathVariable("reader1Id") int reader1Id, @PathVariable("reader2Id") int reader2Id) {
		friendsService.deleteFriendsByReadersIds(reader1Id, reader2Id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/friends/pendings")
	public void savePending(@RequestBody Pending pending) {
		friendsService.savePending(pending);
	}

	@RequestMapping("/readers/{reader1}/friends/{reader2}/pendings")
	public Pending getPendingWithRecipentIdAndSenderId(@PathVariable("reader1") int reader1,
			@PathVariable("reader2") int reader2) {
		return friendsService.getPendingWithRecipentIdAndSenderId(reader1, reader2);
	}

	@RequestMapping("/pendings/readers/{recipentId}/{senderId}")
	public Pending getPendingByRecipentIdAndSenderId(@PathVariable("recipentId") int recipentId,
			@PathVariable("senderId") int senderId) {
		return friendsService.getPendingByRecipentIdAndSenderId(recipentId, senderId);
	}

	@RequestMapping("/readers/{readerId}/friends/pendings")
	public List<Pending> getReaderPendings(@PathVariable int readerId) {
		return friendsService.getReaderPendings(readerId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/pendings/{pendingId}")
	public void deletePending(@PathVariable("pendingId") int pendingId) {
		friendsService.deletePending(pendingId);
	}
}
