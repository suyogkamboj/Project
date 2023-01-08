package com.project.sms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sms.dao.FacultyDAO;
import com.project.sms.dao.SubjectDAO;
import com.project.sms.exceptions.NotFoundException;
import com.project.sms.model.Faculty;
import com.project.sms.model.Subjects;

@Service
@Transactional
public class FacultyService {

	@Autowired
	private FacultyDAO facultyDao;

	@Autowired
	private SubjectDAO subjectDao;

	// get all faculty list
	public List<Faculty> getAllFaculty() {
		List<Faculty> faculties = new ArrayList<>();
		faculties = facultyDao.findAll();
		if (faculties.size() == 0) {
			throw new NotFoundException("Faculty not found");
		} else {
			return faculties;
		}
	}

	// get faculty by id
	public Faculty getFacultyById(Integer id) {
		Optional<Faculty> faculty = facultyDao.findById(id);
		if (faculty.isPresent())
			return faculty.get();
		else
			throw new NotFoundException("faculty not found!!!");
	}

	// get faculties by courseID
	public List<Faculty> getFacultyByCourseId(Integer courseID) {
		return facultyDao.findFacultyByCourseId(courseID);
	}

	// update faculty by id
	public Faculty updateFaculty(Faculty facultyToUpdate, Integer id) {
		Optional<Faculty> foundFaculty = facultyDao.findById(id);
		if (foundFaculty.isPresent()) {
			return facultyDao.save(facultyToUpdate);
		} else
			throw new NotFoundException("faculty Not Found!!!");
	}

	// delete faculty by id
	public boolean deleteFaculty(Integer id) {
		Optional<Faculty> foundFaculty = facultyDao.findById(id);
		if (foundFaculty.isPresent()) {
			facultyDao.deleteById(id);
			return true;
		} else
			return false;
	}

	// add faculty      (this is used in react)
	public boolean addFaculty(Faculty faculty) {
		Optional<Faculty> foundfaculty = facultyDao.findById(faculty.getFacultyID());
		if (foundfaculty.isPresent()) {
			return false;
		} else {
			facultyDao.save(faculty);
			return true;
		}
	}

	// add faculty by subjectID
	public boolean addFacultybySubject(Faculty faculty, int subjectID) {
		Optional<Faculty> foundfaculty = facultyDao.findById(faculty.getFacultyID());
		if (foundfaculty.isPresent()) {
			return false;
		} else {
			facultyDao.save(faculty);
			int facultyID = faculty.getFacultyID();
			assignsubjectToFaculty(facultyID, subjectID);
			return true;
		}
	}

	public Faculty assignsubjectToFaculty(int faculty_id, int subjectID) {
		Faculty faculty = facultyDao.findById(faculty_id).get();
		Subjects subject = subjectDao.findById(subjectID).get();
		faculty.assignSubject(subject);
		return facultyDao.save(faculty);
	}

	// Faculty login
	public boolean validateFaculty(String email, String password) {
		Faculty faculty = facultyDao.findFacultyByEmail(email);
		if (faculty == null) {
			return false;
		} else {
			if (faculty.getPassword().equals(password)) {
				return true;
			} else
				return false;
		}
	}
}
