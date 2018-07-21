package com.damianprog.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.damianprog.entities.Review;

public interface ReviewRepository extends CrudRepository<Review,Integer> {

	List<Review> findAllByBookId(int bookId);
	
	List<Review> findAllByPostingReaderId(int postingReaderId);
	
	@Transactional
	void deleteByIdAndPostingReader(int id,int postingReader);

	@Query("select r from Review r where r.postingReader.id=:readerId order by r.id desc")
	List<Review> findFirst10ByOrderByIdDescAndReaderId(@Param("readerId") int readerId);
}
