package com.project.sms.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sms.dao.AttendanceDAO;
import com.project.sms.dao.StudentAttendanceDAO;
import com.project.sms.dao.StudentDAO;
import com.project.sms.model.Attendance;
import com.project.sms.model.StudentAttendance;
import com.project.sms.model.Students;

@Service
public class StudentAttendanceService {
	
	@Autowired
	private AttendanceDAO attendanceDAO;
	
	@Autowired
	private StudentDAO studentsDAO;
	
	@Autowired
	private StudentAttendanceDAO studentAttendanceDAO; 
	
	// Adding attendance of a student
	public StudentAttendance addStudentAttendanceService(Date date, int studentID, String status) {
		
		Attendance attendance = saveDateInStudentAttendance(date);
		
		Students student = studentsDAO.findById(studentID).get();
		
		StudentAttendance studentAttendance = new StudentAttendance();
		studentAttendance.setStudent(student);
		studentAttendance.setAttendance(attendance);
		studentAttendance.setStatus(status.equals("present") ? true : false );
		
		return studentAttendanceDAO.save(studentAttendance);
	}
	
	public Attendance saveDateInStudentAttendance(Date date) {
		
		Attendance tempAttendance = attendanceDAO.findbyDate(date);
		if(tempAttendance != null ) {
			return tempAttendance;
		}
		
		return attendanceDAO.save(new Attendance(date));
	}
	
	
	
//	public List<StudentAttendance> getStudentAttendance(int studentID){
//		List<StudentAttendance> studentAttendance = new ArrayList<>();
//		StudentAttendance s = studentAttendanceDAO.findByStudentId(studentID);
//		studentAttendance = studentAttendanceDAO.findByStudentId(studentID);
//		if (studentAttendance.isEmpty()) {
//			throw new NotFoundException("Student Not Found!!!");
//		} else {
//			return studentAttendance;
//		}
//		
//	}






	public List<Attendance> getStudentAttendance(String date) {
		
		return null;
	}

}
