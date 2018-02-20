package com.damianprog.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

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
	FriendsService friendsService;
	
	@RequestMapping("/friends/{id}")
	public Friends getFriendsById(@PathVariable("id") int id) {
		return friendsService.getFriendsById(id);
	}
	
	@RequestMapping("/readers/{readerId}/friends")
	public List<Friends> getReaderFriends(@PathVariable int readerId){
		return friendsService.getReaderFriends(readerId);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/friends")
	public void saveFriends(@RequestBody Friends friends) {
		friendsService.saveFriends(friends);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/friends/{friendsId}")
	public void deleteFriends(@PathVariable("friendsId") int id) {
		friendsService.deleteFriendsById(id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/readers/{reader1Id}/friends/{reader2Id}")
	public void deleteFriends(@PathVariable("reader1Id") int reader1Id,@PathVariable("reader2Id") int reader2Id) {
		friendsService.deleteFriendsByReadersIds(reader1Id,reader2Id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/friends/pending")
	public void savePending(@RequestBody Pending pending) {
		friendsService.savePending(pending);
	}
	
	@RequestMapping("/readers/{reader1}/friends/{reader2}/pending")
	public Pending getPending(@PathVariable("reader1") int reader1,@PathVariable("reader2") int reader2) {
		return friendsService.getPending(reader1,reader2);
	}
	
	@RequestMapping("/readers/{readerId}/friends/pending")
	public List<Pending> getReaderPendings(@PathVariable int readerId){
		return friendsService.getReaderPendings(readerId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/pending/{pendingId}")
	public void deletePending(@PathVariable("pendingId") int pendingId) {
		friendsService.deletePending(pendingId);
	}
}
