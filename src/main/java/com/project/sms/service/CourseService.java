package com.project.sms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sms.dao.CourseDAO;
import com.project.sms.exceptions.NotFoundException;
import com.project.sms.model.Course;

@Service
@Transactional
public class CourseService 
{

	@Autowired
	private CourseDAO courseDao;
	
	//get all course
	public List<Course> getAllCourse() {
		List<Course> course = new ArrayList<>();
		course = courseDao.findAll();
		if (course.size() == 0) {
			throw new NotFoundException(" course Not Found!!!");
		} else {
			return course;
		}
	}
	
	// find course by id
	public Course getCourseById(Integer id) {
		Optional<Course> course = courseDao.findById(id);
		if (course.isPresent())
			return course.get();
		else
			throw new NotFoundException("course Not Found!!!");
	}
	
	// update course
	public Course updateCourse(Course courseToUpdate, Integer id) {
		Optional<Course> foundCourse = courseDao.findById(id);
		if (foundCourse.isPresent()) {
			return courseDao.save(courseToUpdate);
		} else
			throw new NotFoundException("Course Not Found!!!");
	}
	
	// delete course
	public void deleteCourse(Integer id) {
		Optional<Course> foundCourse = courseDao.findById(id);
		if (foundCourse.isPresent()) {
			courseDao.deleteById(id);
		} else
			throw new NotFoundException("course Not Found!!!");

	}
	
	//Add course
	public Course addCourse(Course course) {
		
		return courseDao.save(course);
	}
	
	
}
