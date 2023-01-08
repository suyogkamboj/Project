package com.project.sms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.sms.model.Course;
@Repository
public interface CourseDAO extends JpaRepository<Course, Integer>{

}
