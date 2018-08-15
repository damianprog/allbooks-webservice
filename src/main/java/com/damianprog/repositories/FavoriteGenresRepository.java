package com.damianprog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.damianprog.entities.FavoriteGenres;

public interface FavoriteGenresRepository extends CrudRepository<FavoriteGenres,Integer>{

	FavoriteGenres findOneByReaderId(int readerId);
	
}
