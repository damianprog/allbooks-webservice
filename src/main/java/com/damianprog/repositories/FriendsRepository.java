package com.damianprog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.damianprog.entities.Friends;

public interface FriendsRepository extends CrudRepository<Friends,Integer> {

	@Query("select f from Friends f where f.reader1=:readerId or f.reader2=:readerId")
	List<Friends> findAllReaderFriends(@Param("readerId") int readerId);
	
	@Modifying
	@Query("delete from Friends f where (f.reader1=:reader1 and f.reader2=:reader2) or (f.reader1=:reader2 and f.reader2=:reader1)")
	void deleteByReader1AndReader2(@Param("reader1") int reader1,@Param("reader2") int reader2);
	
}
         