package com.project.sms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.sms.model.Subjects;

@Repository
public interface SubjectDAO extends JpaRepository<Subjects, Integer> {
	
	@Query("select subjects ,course from Subjects subjects  JOIN subjects.course course where course.courseID=:courseID")
	List<Subjects> findSubjectsByCourseId(@Param("courseID")int courseID);
}
