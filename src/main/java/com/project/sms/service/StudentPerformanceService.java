package com.project.sms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sms.dao.StudentDAO;
import com.project.sms.dao.StudentPerformanceDAO;
import com.project.sms.dao.SubjectDAO;
import com.project.sms.model.StudentPerformance;
import com.project.sms.model.Students;
import com.project.sms.model.Subjects;

@Transactional
@Service
public class StudentPerformanceService {

	@Autowired
	private StudentPerformanceDAO studentPerformanceDAO;

	@Autowired
	private SubjectDAO subjectDAO;

	@Autowired
	private StudentDAO studentsDAO;

	public StudentPerformance addSubjectMarks(int subjectID, int studentID, int marks) {
		
		Students student = studentsDAO.findById(studentID).get();
		Subjects subject = subjectDAO.findById(subjectID).get();
		
		StudentPerformance studentPerformance = new StudentPerformance();
		studentPerformance.setStudent(student);
		studentPerformance.setSubjects(subject);
		studentPerformance.setMarks(marks);
		
		return studentPerformanceDAO.save(studentPerformance);
	}

	
	public List<StudentPerformance> getAllStudentStudentList(int subjectID) {
		
		List<StudentPerformance> studentPerformanceList = 
				studentPerformanceDAO.findAll();
//		studentPerformanceDAO.findAllBySubjectID(subjectID);
		return studentPerformanceList;
	}


	public List<StudentPerformance> getAllStudentList() {
		List<StudentPerformance> studentPerformanceList = 
				studentPerformanceDAO.findAll();
		return studentPerformanceList;
	}

}
