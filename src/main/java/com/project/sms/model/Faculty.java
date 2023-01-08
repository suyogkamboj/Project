package com.project.sms.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty {

	@Id
	@Column(name = "faculty_id")
	private int facultyID;

	@Column(name = "faculty_name")
	private String facultyName;

	@Column(name = "faculty_email")
	private String email;

	@Column(name = "password")
	private String password;

	
	@OneToOne // (optional = false) // this data can't be null and should have a value if data is to be inserted
	@JoinColumn(name = "teaching_subject", referencedColumnName = "subject_id")
	private Subjects subject;

	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "course_id", referencedColumnName = "course_id")
	private Course course;

	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Faculty(int faculty_id, String faculty_name, String email, String password, Subjects subject,
			Course course) {
		super();
		this.facultyID = faculty_id;
		this.facultyName = faculty_name;
		this.email = email;
		this.password = password;
		this.subject = subject;
		this.course = course;
	}

	
	//Getter ANd setters
	public int getFacultyID() {
		return facultyID;
	}

	public void setFacultyID(int facultyID) {
		this.facultyID = facultyID;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
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

	public Subjects getSubject() {
		return subject;
	}

	public void setSubject(Subjects subject) {
		this.subject = subject;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Faculty [facultyID=" + facultyID + ", facultyName=" + facultyName + ", email=" + email + ", password="
				+ password + "]";
	}

	public void assignCourse(Course course) {
		this.course = course;
	}
	
	public void assignSubject(Subjects subject) {
		this.subject = subject;
	}
	
}
