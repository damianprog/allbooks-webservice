package com.damianprog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.damianprog.entities.ReadingChallangeComment;

public interface ReadingChallangeCommentRepository extends JpaRepository<ReadingChallangeComment,Integer>{

	@Query("select c from ReadingChallangeComment c where c.challangeReader.id = :challangeReaderId")
	List<ReadingChallangeComment> findAllByChallangeReaderId(@Param("challangeReaderId") int challangeReaderId);

}
