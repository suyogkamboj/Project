package com.project.sms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@Column(name = "course_id")
	private int courseID;

	@Column(name = "course_name")
	private String courseName;

	// Done
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "course", cascade = CascadeType.ALL)
	private List<Faculty> faculties;

	/*
	 * fetch type was set to eager. it also worked for few cases like faculty to
	 * courses (one to many to one) but have to remove it might try the set fetch to
	 * lazy, later
	 * 
	 * I checked again, so putting fetch type as eager in only one of the mapping
	 * doesn't show any error. or put one mapping as eager and rest as lazy
	 * 
	 * it also worked if fetch type was set to lazy for every mapping
	 */

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "course", cascade = CascadeType.ALL)
	private List<Subjects> subject;

	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "course", cascade = CascadeType.ALL)
	private List<Students> student;

	public Course() {
		super();
	}

	public Course(int courseID, String courseName, List<Faculty> faculties, List<Subjects> subject,
			List<Students> student) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.faculties = faculties;
		this.subject = subject;
		this.student = student;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(List<Faculty> faculties) {
		this.faculties = faculties;
	}

	public List<Subjects> getSubject() {
		return subject;
	}

	public void setSubject(List<Subjects> subject) {
		this.subject = subject;
	}

	public List<Students> getStudent() {
		return student;
	}

	public void setStudent(List<Students> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Course [courseID=" + courseID + ", courseName=" + courseName + "]";
	}
	
}
