package com.project.sms.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sms.model.StudentAttendance;
import com.project.sms.service.StudentAttendanceService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AttendanceController {

	@Autowired
	private StudentAttendanceService attendanceService; 
	
	@PostMapping("/attendance/add/{date}/students/{studentID}/{status}")
	public StudentAttendance addStudentAttendance(
			@PathVariable String date, @PathVariable String studentID, @PathVariable String status) {
		System.out.println(date + " -- " +studentID);
		return attendanceService.addStudentAttendanceService(Date.valueOf(date), Integer.parseInt(studentID), status);
	}
//	
//	@GetMapping("/attendance/{date}")
//	public List<Attendance> getAttendance(@PathVariable String date){
//		
//		return attendanceService.getStudentAttendance(date);
//	}
}
