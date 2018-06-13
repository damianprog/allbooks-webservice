package com.damianprog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.damianprog.entities.Pending;

public interface PendingRepository extends CrudRepository<Pending,Integer>  {

	
	@Query("select p from Pending p where (p.recipent.id=:reader1 and p.sender.id=:reader2) or (p.recipent.id=:reader2 and p.sender.id=:reader1)")
	Pending findOneWithRecipentIdAndSenderId(@Param("reader1") int reader1,@Param("reader2") int reader2);

	@Query("select p from Pending p where (p.recipent.id=:recipentId and p.sender.id=:senderId)")
	Pending findOneByRecipentIdAndSenderId(@Param("recipentId") int recipentId,@Param("senderId") int senderId);
	
	@Query("select p from Pending p where p.recipent.id=:readerId")
	List<Pending> findAllReaderPendings(@Param("readerId") int readerId);
}
