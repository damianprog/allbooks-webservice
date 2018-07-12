package com.damianprog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.Ban;
import com.damianprog.services.BanService;

@RestController
public class BanController {

	@Autowired
	private BanService banService;
	
	@RequestMapping("/bans/pages/{page}")
	public Page<Ban> getBans(@PathVariable int page) {
		return banService.getBans(new PageRequest(page-1,10));
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/bans")
	public void saveBan(@RequestBody Ban ban) {
		banService.saveBan(ban);
	}
	
	@RequestMapping("/bans/{banId}")
	public Ban getBanById(@PathVariable int banId) {
		return banService.getBanById(banId);
	}
	
	@RequestMapping("/readers/{readerId}/bans")
	public Ban getBanByReaderId(@PathVariable int readerId) {
		return banService.getBanByReaderId(readerId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/bans/{banId}")
	public void deleteBan(@PathVariable int banId) {
		banService.deleteBanById(banId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/readers/{readerId}/bans")
	public void deleteBanByReaderId(@PathVariable int readerId) {
		banService.deleteBanByReaderId(readerId);
	}
	
}
