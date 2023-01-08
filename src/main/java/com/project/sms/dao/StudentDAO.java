package com.project.sms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.sms.model.Faculty;
import com.project.sms.model.Students;

@Repository
public interface StudentDAO extends JpaRepository<Students, Integer> {
	
	@Query("select s from Students s where s.email= ?1 and s.password= ?2")
	Students findByStudentEmailAndStudentPassword(String email, String password);
	
	@Query("select s ,c from Students s JOIN s.course c where c.courseID=:courseID")
	List<Students> findStudentsByCourseId(@Param("courseID")int courseID);
	
	@Query("select s from Students s where s.email=:email")
	Students findStudentByEmail(@Param("email") String email);
	
}
