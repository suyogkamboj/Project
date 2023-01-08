package com.project.sms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Students {

	@Id
	@Column(name = "student_id")
	private int studentID;

	@Column(name = "student_name")
	private String studentName;

	@Column(name = "student_email")
	private String email;

	@Column(name = "password")
	private String password;

	// Done
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "course_id", referencedColumnName = "course_id")
	private Course course;

	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<StudentPerformance> studentPerformance = new ArrayList<>();

	@OneToMany(mappedBy = "student" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<StudentAttendance> studentAttendances = new ArrayList<>();
	public Students() {
		super();
	}
	
	public Students(int studentID, String studentName, String email, String password) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.email = email;
		this.password = password;
	}



	// Ashish added this
	public Students(int studentID, String student_name, String student_email, String password, Course course,
			List<StudentPerformance> studentPerformance, List<StudentAttendance> studentAttendances) {
		super();
		this.studentID = studentID;
		this.studentName = student_name;
		this.email = student_email;
		this.password = password;
		this.course = course;
		this.studentPerformance = studentPerformance;
		this.studentAttendances = studentAttendances;
	}

	// Service method
	public void assignCourseToStudent(Course course) {
		this.course = course;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<StudentPerformance> getStudentPerformance() {
		return studentPerformance;
	}

	public void setStudentPerformance(List<StudentPerformance> studentPerformance) {
		this.studentPerformance = studentPerformance;
	}

	public List<StudentAttendance> getStudentAttendances() {
		return studentAttendances;
	}

	public void setStudentAttendances(List<StudentAttendance> studentAttendances) {
		this.studentAttendances = studentAttendances;
	}

	@Override
	public String toString() {
		return "Students [studentID=" + studentID + ", student_name=" + studentName + ", student_email="
				+ email + ", password=" + password + ", course=" + course + ", studentPerformance="
				+ studentPerformance + "]";
	}

}
