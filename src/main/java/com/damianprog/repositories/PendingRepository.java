package com.damianprog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.damianprog.entities.Pending;

public interface PendingRepository extends CrudRepository<Pending,Integer>  {

	
	@Query("select p from Pending p where (p.recipentId=:reader1 and p.senderId=:reader2) or (p.recipentId=:reader2 and p.senderId=:reader1)")
	Pending findOneByRecipentIdAndSenderId(@Param("reader1") int reader1,@Param("reader2") int reader2);

	@Query("select p from Pending p where p.recipentId=:readerId")
	List<Pending> findAllReaderPendings(@Param("readerId") int readerId);
}
