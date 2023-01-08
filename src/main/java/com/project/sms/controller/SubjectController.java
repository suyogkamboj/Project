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

import com.project.sms.model.Subjects;
import com.project.sms.service.SubjectsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SubjectController {
	@Autowired
	private SubjectsService subjectsService;

	// add subject
	@PostMapping("/subject/add/{courseId}")
	public Subjects addSubject(@RequestBody Subjects subject, @PathVariable int courseId) {
		System.out.println(subject);
		return subjectsService.addSubject(subject, courseId);

	}

	// get subject list
	@GetMapping("/subjects")
	public List<Subjects> getAllSubjects() {
		return subjectsService.getAllSubjects();
	}

	// get subject By Id
	@GetMapping("/subject/{subjectId}")
	public Subjects getSubjectById(@PathVariable String subjectId) {
		return subjectsService.getSubjectById(Integer.parseInt(subjectId));
	}
	
	//get subject list by courseid
	@GetMapping("/subjects/get/{courseID}")
	public List<Subjects> getSubjectsByCourseId(@PathVariable Integer courseID)
	{
		return subjectsService.getSubjectsByCourseId(courseID);
	}

	// Update subject
	@PutMapping(value = "subject/update/{subjectId}", consumes = { "application/json" })
	public Subjects updateSubject(@RequestBody Subjects subject, @PathVariable String subjectId) {
		return subjectsService.updateSubject(subject, Integer.parseInt(subjectId));
	}

	// delete subject
	@DeleteMapping("/subject/delete/{subjectId}")
	public ResponseEntity<HttpStatus> deleteSubject(@PathVariable String subjectId) {
		try {
			subjectsService.deleteSubject(Integer.parseInt(subjectId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
