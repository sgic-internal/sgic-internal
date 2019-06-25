package com.sgic.internal.defecttracker.defect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sgic.internal.defecttracker.defect.entities.DBFile;

@Repository
@Transactional
public interface DBFileRepository extends JpaRepository<DBFile,Long> {

//	//DBFile findOne(Long fileId);
//	@Query("SELECT d FROM DBFile d WHERE d.defect.id= :defectId")
//	List<DBFile> findDBFileByDefectId(@Param("defectId") Long defectId);
//	
}
