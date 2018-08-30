package com.damianprog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.damianprog.entities.FavouriteGenres;

public interface FavoriteGenresRepository extends CrudRepository<FavouriteGenres,Integer>{

	FavouriteGenres findOneByReaderId(int readerId);
	
}
