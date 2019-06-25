package com.sgic.internal.defecttracker.defect.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sgic.internal.defecttracker.defect.entities.Comments;
import com.sgic.internal.defecttracker.defect.entities.Defect;

@Transactional
@Repository
public interface CommentRepository extends JpaRepository<Comments, Long>{
	
	@Query("SELECT c FROM Comments c WHERE c.defect.id= :defectId")
	List<Comments> findCommentsByDefectId(@Param("defectId") String defectId);
	
	List<Comments> findByDefect(Defect defect);
}
