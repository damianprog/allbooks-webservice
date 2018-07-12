package com.damianprog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.damianprog.entities.Ban;
import com.damianprog.repositories.BanRepository;

@Service
public class BanService {

	@Autowired
	private BanRepository banRepository;

	public void saveBan(Ban ban) {
		banRepository.save(ban);
	}

	public Ban getBanById(int banId) {
		return banRepository.findOne(banId);
	}

	public Ban getBanByReaderId(int readerId) {
		return banRepository.findOneByReaderId(readerId);
	}

	public void deleteBanById(int banId) {
		banRepository.delete(banId);
	}

	public void deleteBanByReaderId(int readerId) {
		banRepository.deleteByReaderId(readerId);
	}

	public Page<Ban> getBans(Pageable pageable) {
		return banRepository.findAll(pageable);
	}
	
	
	
	
}
