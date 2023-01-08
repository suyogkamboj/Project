package com.project.sms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "subjects")
public class Subjects {

	@Id
	@Column(name = "subject_id")
	private int subjectID;

	@Column(name = "subject_name")
	private String subjectName;

	
	@JsonIgnore
	@OneToOne(mappedBy = "subject")
	private Faculty faculty;

	
	@ManyToOne()
	@JoinColumn(name = "course_id", referencedColumnName = "course_id")
	private Course course;

	@OneToMany(mappedBy = "subjects")
    List<StudentPerformance> studentPerformance = new ArrayList<>();
	
	
	public Subjects() {
		super();
	}
	

	public Subjects(int subjectID, String subjectName) {
		super();
		this.subjectID = subjectID;
		this.subjectName = subjectName;
	}

	public Subjects(int subjectID, String subjectName, Faculty faculty, Course course,
			List<StudentPerformance> studentPerformance) {
		super();
		this.subjectID = subjectID;
		this.subjectName = subjectName;
		this.faculty = faculty;
		this.course = course;
		this.studentPerformance = studentPerformance;
	}


	public int getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
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

	@Override
	public String toString() {
		return "Subjects [subjectID=" + subjectID + ", subjectName=" + subjectName + "]";
	}

	public void setStudentPerformance(List<StudentPerformance> studentPerformance) {
		this.studentPerformance = studentPerformance;
	}

	public void assignCourse(Course course) {
		this.course = course;

	}

}
