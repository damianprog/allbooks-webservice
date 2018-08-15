package com.damianprog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.FavoriteGenres;
import com.damianprog.repositories.FavoriteGenresRepository;

@Service
public class FavoriteGenresService {

	@Autowired
	private FavoriteGenresRepository favoriteGenresRepository;
	
	public void saveFavoriteGenres(FavoriteGenres favoriteGenres) {
		favoriteGenresRepository.save(favoriteGenres);
	} 
	
	public FavoriteGenres getByReaderId(int readerId) {
		return favoriteGenresRepository.findOneByReaderId(readerId);
	}
	
	public FavoriteGenres getById(int id) {
		return favoriteGenresRepository.findOne(id);
	}
	
}
