package com.project.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sms.model.StudentPerformance;
import com.project.sms.model.Students;
import com.project.sms.service.StudentPerformanceService;
import com.project.sms.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PerformanceController {
	
	@Autowired
	private StudentPerformanceService studentPerformanceService;
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/subjects/{subjectID}/students/{studentID}/{marks}")
	public StudentPerformance addStudentSubjectMarks(
			@PathVariable String subjectID, @PathVariable String studentID, @PathVariable String marks) {
		
		return studentPerformanceService.addSubjectMarks(
				Integer.parseInt(subjectID), Integer.parseInt(studentID), Integer.parseInt(marks));
	}
	
//	// fetching student marks according to subject
//	@GetMapping("/students/subject/{subjectID}")
//	public  List<StudentPerformance> getAllStudentsSubjectMarks(@PathVariable String subjectID){
//				
//		return studentPerformanceService.getAllStudentStudentList(Integer.parseInt(subjectID));
//	}
//	
//	@GetMapping("/students/subject/performance")
//	public  List<Students> getAllStudentsSubjectMarks(){
//		
//		return studentService.getAllStudent();
//	}
	
}
