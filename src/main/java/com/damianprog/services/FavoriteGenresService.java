package com.damianprog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damianprog.entities.FavouriteGenres;
import com.damianprog.repositories.FavoriteGenresRepository;

@Service
public class FavoriteGenresService {

	@Autowired
	private FavoriteGenresRepository favoriteGenresRepository;
	
	public void saveFavoriteGenres(FavouriteGenres favoriteGenres) {
		favoriteGenresRepository.save(favoriteGenres);
	} 
	
	public FavouriteGenres getByReaderId(int readerId) {
		return favoriteGenresRepository.findOneByReaderId(readerId);
	}
	
	public FavouriteGenres getById(int id) {
		return favoriteGenresRepository.findOne(id);
	}
	
}
