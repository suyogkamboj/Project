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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.sms.model.Authenticate;
import com.project.sms.model.Students;
import com.project.sms.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {
	@Autowired
	private StudentService studentService;

	// get all Students
	@GetMapping("/students")
	@ResponseBody
	public List<Students> getAllstudent() {
		return studentService.getAllStudent();
	}

	// get student By Id
	@GetMapping("/student/{studentId}")
	public Students getstudentById(@PathVariable String studentId) {
		return studentService.getStudentById(Integer.parseInt(studentId));
	}

	// get all students by courseID
	@GetMapping("/students/get/{courseID}")
	public List<Students> getStudentsByCourseId(@PathVariable Integer courseID) {
		return studentService.getStudentsByCourseId(courseID);
	}

	// Add students (course with request body)  (used this one in react)
	@PostMapping(value = "/student/add", consumes = { "application/json" })
	public Students addStudent(@RequestBody Students student) {
		return studentService.addStudent(student);
	}

//	// Add students with CourseID(path variable)
//	@PostMapping(value = "/student/add/{courseID}", consumes = { "application/json" })
//	public Students addStudent(@RequestBody Students student, @PathVariable int courseID) {
//		return studentService.addStudentbyCourse(student, courseID);
//	}

	// Update Student by id
	@PutMapping(value = "student/update/{studentId}", consumes = { "application/json" })
	public Students updateStudent(@RequestBody Students student, @PathVariable String studentId) {
		return studentService.updateStudent(student, Integer.parseInt(studentId));
	}

	// delete student by id
	@DeleteMapping("/student/delete/{studentId}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable String studentId) {
		try {
			studentService.deleteStudent(Integer.parseInt(studentId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/studentlogin")
	public boolean validateStudent(@RequestParam String email, @RequestParam String password) {
		return studentService.validateStudent(email, password);
	}

}
