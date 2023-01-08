package com.project.sms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.sms.model.Faculty;

@Repository
public interface FacultyDAO extends JpaRepository<Faculty, Integer> {

	@Query("select f ,c from Faculty f JOIN f.course c where c.courseID=:courseID")
	List<Faculty> findFacultyByCourseId(@Param("courseID")int courseID);
	
	@Query("select f from Faculty f where f.email=:email")
	Faculty findFacultyByEmail(@Param("email") String email);
}
