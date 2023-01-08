package com.project.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.project.sms.model.Faculty;
import com.project.sms.service.FacultyService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FacultyController {

	@Autowired
	private FacultyService facultyService;

	// get all faculty list
	@GetMapping("/faculties")
	@ResponseBody
	public List<Faculty> getAllFaculty() {
		return facultyService.getAllFaculty();
	}

	// add new faculty          (this is used in react)
	@PostMapping(value = "/faculty/add", consumes = { "application/json" })
	public boolean addFaculty(@RequestBody Faculty faculty) {
		return facultyService.addFaculty(faculty);
	}

	// add new faculty with subject as path variable and course as object
	@PostMapping(value = "/faculty/add/{subjectID}", consumes = { "application/json" })
	public boolean addFaculty(@RequestBody Faculty faculty, @PathVariable int subjectID) {
		return facultyService.addFacultybySubject(faculty, subjectID);
	}

	// get faculty by id
	@GetMapping("/faculty/{facultyId}")
	public Faculty getFacultyById(@PathVariable String facultyId) {
		return facultyService.getFacultyById(Integer.parseInt(facultyId));
	}

	// get faculty by courseID
	@GetMapping("/faculties/get/{courseID}")
	public List<Faculty> getFacultyByCourseId(@PathVariable Integer courseID) {
		return facultyService.getFacultyByCourseId(courseID);
	}

	// update faculty by id
	@PutMapping(value = "/faculty/update/{facultyId}", consumes = { "application/json" })
	public Faculty updateFaculty(@RequestBody Faculty faculty, @PathVariable String facultyId) {
		return facultyService.updateFaculty(faculty, Integer.parseInt(facultyId));
	}
	
	// delete faculty by id
	@DeleteMapping("/faculty/delete/{facultyId}")
	public boolean deleteFaculty(@PathVariable String facultyId) {
		return facultyService.deleteFaculty(Integer.parseInt(facultyId));
	}

	// login
	@GetMapping("/facultylogin")
	public boolean validateFaculty(@RequestParam String email, @RequestParam String password) {
		return facultyService.validateFaculty(email, password);
	}
}
