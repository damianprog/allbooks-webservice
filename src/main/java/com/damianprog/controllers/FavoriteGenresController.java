package com.damianprog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damianprog.entities.FavouriteGenres;
import com.damianprog.services.FavoriteGenresService;

@RestController
public class FavoriteGenresController {

	@Autowired
	private FavoriteGenresService favoriteGenresService;
	
	@RequestMapping("/favoriteGenres")
	public void saveFavoriteGenres(@RequestBody FavouriteGenres favoriteGenres) {
		favoriteGenresService.saveFavoriteGenres(favoriteGenres);
	}
	
	@RequestMapping("/readers/{readerId}/favoriteGenres")
	public FavouriteGenres getByReaderId(@PathVariable int readerId) {
		return favoriteGenresService.getByReaderId(readerId);
	}
	
	@RequestMapping("/favoriteGenres/{favoriteGenresId}")
	public FavouriteGenres getById(@PathVariable int favoriteGenresId) {
		return favoriteGenresService.getById(favoriteGenresId);
	}
	
}
