package com.project.sms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sms.dao.CourseDAO;
import com.project.sms.dao.StudentDAO;
import com.project.sms.exceptions.NotFoundException;
import com.project.sms.model.Course;
import com.project.sms.model.Faculty;
import com.project.sms.model.Students;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentDAO studentDao;

	@Autowired
	private CourseDAO courseDao;
	// Can be accessed by admin and Faculty

	// get all student list
	public List<Students> getAllStudent() {
		List<Students> student = new ArrayList<>();
		student = studentDao.findAll();
		if (student.size() == 0) {
			throw new NotFoundException("Student Not Found!!!");
		} else {
			return student;
		}
	}

	// Can be accessed by admin and Faculty by Id
	public Students getStudentById(Integer id) {
		Optional<Students> student = studentDao.findById(id);
		if (student.isPresent())
			return student.get();
		else
			throw new NotFoundException("student Not Found!!!");
	}

	// update student by id
	public Students updateStudent(Students studentToUpdate, Integer id) {
		Optional<Students> foundstudent = studentDao.findById(id);
		if (foundstudent.isPresent()) {
			return studentDao.save(studentToUpdate);
		} else
			throw new NotFoundException("student Not Found!!!");

	}

	// get students by courseID
	public List<Students> getStudentsByCourseId(Integer courseID) {
//		Course course = courseDao.findById(courseID).get();
//		System.out.println(courseID);

		return studentDao.findStudentsByCourseId(courseID);

	}

	// delete student by id
	public void deleteStudent(Integer id) {
		Optional<Students> foundstudent = studentDao.findById(id);
		if (foundstudent.isPresent()) {
			studentDao.deleteById(id);
		} else
			throw new NotFoundException("student Not Found!!!");

	}

	// add student
	public Students addStudent(Students student) {
		return studentDao.save(student);
	}

	//add student by courseID
	public Students addStudentbyCourse(Students student, int courseID) {

		System.out.println("called");
		int studentID = student.getStudentID();
		System.out.println(studentID);
		studentDao.save(student);
		return assignCourseToStudent(studentID, courseID);
	}

	public Students assignCourseToStudent(int studentID, int courseID) {
		System.out.println("assign method called");
		Students student = studentDao.findById(studentID).get();
		System.out.println(student);

		Course course = courseDao.findById(courseID).get();
		student.assignCourseToStudent(course);

		return studentDao.save(student);
	}
	
	// Student login
		public boolean validateStudent(String email, String password) {
			Students student = studentDao.findStudentByEmail(email);
			if (student == null) {
				return false;
			} else {
				if (student.getPassword().equals(password)) {
					return true;
				} else
					return false;
			}
		}

}
