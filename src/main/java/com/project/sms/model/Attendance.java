package com.project.sms.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "attendance")
public class Attendance {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "attendance_id")
    private int attendanceID;
    
    @Column(name = "date")
    private  Date date;
    
    @JsonIgnore
    @OneToMany(mappedBy = "attendance" , cascade = CascadeType.ALL)
    private List<StudentAttendance> studentAttendances = 
    		new ArrayList<StudentAttendance>();
    

	public Attendance() {
		super();
	}


	public Attendance(int attendanceID, Date date, List<StudentAttendance> studentAttendances) {
		super();
		this.attendanceID = attendanceID;
		this.date = date;
		this.studentAttendances = studentAttendances;
	}

	

	public Attendance(Date date) {
		super();
		this.date = date;
	}


	public int getAttendanceID() {
		return attendanceID;
	}


	public void setAttendanceID(int attendanceID) {
		this.attendanceID = attendanceID;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public List<StudentAttendance> getStudentAttendances() {
		return studentAttendances;
	}


	public void setStudentAttendances(List<StudentAttendance> studentAttendances) {
		this.studentAttendances = studentAttendances;
	}


	@Override
	public String toString() {
		return "Attendance [attendanceID=" + attendanceID + ", date=" + date + "]";
	} 
    
}

