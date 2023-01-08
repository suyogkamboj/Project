package com.project.sms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sms.dao.CourseDAO;
import com.project.sms.dao.SubjectDAO;
import com.project.sms.exceptions.NotFoundException;
import com.project.sms.model.Course;
import com.project.sms.model.Subjects;

@Service
@Transactional
public class SubjectsService {
	@Autowired
	private SubjectDAO subjetDao;

	@Autowired
	private CourseDAO courseDAO;

	// get all subject list
	public List<Subjects> getAllSubjects() {
		List<Subjects> subject = new ArrayList<>();
		subject = subjetDao.findAll();
		if (subject.size() == 0) {
			throw new NotFoundException(" subjects  Not Found!!!");
		} else {
			return subject;
		}
	}

	// get subject by id
	public Subjects getSubjectById(Integer id) {
		Optional<Subjects> subject = subjetDao.findById(id);
		if (subject.isPresent())
			return subject.get();
		else
			throw new NotFoundException("subject Not Found!!!");
	}

	// get subject list by courseID
	public List<Subjects> getSubjectsByCourseId(Integer courseID) {
		return subjetDao.findSubjectsByCourseId(courseID);
	}

	// add subject
	public Subjects addSubject(Subjects subject) {
		return subjetDao.save(subject);
	}

	//add subject and pass course id as path variable
	public Subjects addSubject(Subjects subject, int courseID) {

		System.out.println("called");
		int subjectID = subject.getSubjectID();
		System.out.println(subjectID);
		subjetDao.save(subject);
		return assignSubjectToCourse(subjectID, courseID);
	}

	// update subject
	public Subjects updateSubject(Subjects subjectToUpdate, Integer id) {
		Optional<Subjects> foundsubject = subjetDao.findById(id);
		if (foundsubject.isPresent()) {
			return subjetDao.save(subjectToUpdate);
		} else
			throw new NotFoundException("Subject Not Found!!!");
	}

	// delete subject
	public void deleteSubject(Integer id) {
		Optional<Subjects> foundSubject = subjetDao.findById(id);
		if (foundSubject.isPresent()) {
			subjetDao.deleteById(id);
		} else
			throw new NotFoundException("subject Not Found!!!");
	}

	public Subjects assignSubjectToCourse(int subjectID, int courseID) {
		System.out.println("assign called");
		Subjects subject = subjetDao.findById(subjectID).get();
		Course course = courseDAO.findById(courseID).get();
		subject.assignCourse(course);

		return subjetDao.save(subject);

	}

}
