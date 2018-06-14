package com.damianprog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.damianprog.entities.Friends;

public interface FriendsRepository extends CrudRepository<Friends,Integer> {

	@Query("select f from Friends f where f.reader1.id=:readerId or f.reader2.id=:readerId")
	List<Friends> findAllReaderFriends(@Param("readerId") int readerId);
	
	@Query("select f from Friends f where (f.reader1.id=:reader1 and f.reader2.id=:reader2) or (f.reader1.id=:reader2 and f.reader2.id=:reader1)")
	Friends findOneFriendsByReader1IdAndReader2Id(@Param("reader1") int reader1,@Param("reader2") int reader2);
	
	@Modifying
	@Query("delete from Friends f where (f.reader1.id=:reader1 and f.reader2.id=:reader2) or (f.reader1.id=:reader2 and f.reader2.id=:reader1)")
	void deleteByReader1AndReader2(@Param("reader1") int reader1,@Param("reader2") int reader2);
	
}
         