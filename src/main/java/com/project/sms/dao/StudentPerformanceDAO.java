package com.project.sms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.sms.model.StudentPerformance;

@Repository
public interface StudentPerformanceDAO extends JpaRepository<StudentPerformance, Integer> {

	@Transactional
	@Query(value = "SELECT * FROM student_performance s WHERE s.subjects_subject_id = :subjectID ", 
	nativeQuery = true)
	List<StudentPerformance> findAllBySubjectID(Integer subjectID);
	
	
	@Transactional
	@Query(value = "SELECT * FROM student_performance s WHERE s.student_student_id = :studentID ", 
	nativeQuery = true)
	List<StudentPerformance> findMarksByStudentID(Integer studentID);
	
	
}
