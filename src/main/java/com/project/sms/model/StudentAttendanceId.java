package com.project.sms.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudentAttendanceId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "attendance_id")
	private int attendanceID;
	@Column(name = "student_id")
	private int studentID;
	
	public StudentAttendanceId(int attendanceID, int studentID) {
		super();
		this.attendanceID = attendanceID;
		this.studentID = studentID;
	}

	public StudentAttendanceId() {
		super();
	}

	public int getAttendanceID() {
		return attendanceID;
	}

	public void setAttendanceID(int attendanceID) {
		this.attendanceID = attendanceID;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	
	
	
	
}
