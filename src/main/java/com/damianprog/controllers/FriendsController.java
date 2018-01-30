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
		friendsService.deleteFriends(id);
		
	}
	
}
