package com.project.sms.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "student_attendance" )
public class StudentAttendance{

	@EmbeddedId
	private StudentAttendanceId id = new StudentAttendanceId();
	
	@JsonIgnore
	@ManyToOne()
    @MapsId("studentID")
    Students student;
	
//	@JsonIgnore
	@ManyToOne()
	@MapsId("attendanceID")
    Attendance attendance;
    
    
    @Column(name = "status")
    private boolean status;

	public StudentAttendance() {
		super();
	}
	
	public StudentAttendance(StudentAttendanceId id, Students student, Attendance attendance, boolean status) {
		super();
		this.id = id;
		this.student = student;
		this.attendance = attendance;
		this.status = status;
	}


	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}

	public Attendance getAttendance() {
		return attendance;
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
	@Override
	public String toString() {
		return "StudentAttendance [id=" + id + ", student=" + student + ", attendance=" + attendance + ", status="
				+ status + "]";
	}

	
	
}
