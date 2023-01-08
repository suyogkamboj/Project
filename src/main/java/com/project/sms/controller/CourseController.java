package com.project.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.sms.model.Course;
import com.project.sms.service.CourseService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {
	@Autowired
	private CourseService courseService;

	// get all course
	@GetMapping("/courses")
	public List<Course> getAllCourse() {
		return courseService.getAllCourse();
	}

	// get course By Id
	@GetMapping("/course/{courseID}")
	public Course getCourseById(@PathVariable String courseID) {
		return courseService.getCourseById(Integer.parseInt(courseID));
	}

	// Add course
	@PostMapping(value = "/course/add", consumes = { "application/json" })
	public Course addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}

	// Update Course
	@PutMapping(value = "/course/update/{courseId}", consumes = { "application/json" })
	public Course updateCourse(@RequestBody Course course, @PathVariable String courseId) {
		return courseService.updateCourse(course, Integer.parseInt(courseId));
	}

	// delete Course
	@DeleteMapping("/course/delete/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
			courseService.deleteCourse(Integer.parseInt(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
