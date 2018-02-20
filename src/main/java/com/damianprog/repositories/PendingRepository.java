package com.damianprog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.damianprog.entities.Pending;

public interface PendingRepository extends CrudRepository<Pending,Integer>  {

	Pending findOneByRecipentIdAndSenderId(int reader1, int reader2);

	@Query("select p from Pending p where p.recipentId=:readerId")
	List<Pending> findAllReaderPendings(@Param("readerId") int readerId);
}
