package com.project.sms.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudentPerformanceId implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "subject_id")
	private int subjectID;
	@Column(name = "student_id")
	private int studentID;
	
	
	public StudentPerformanceId() {
		super();
	}

	public StudentPerformanceId(int subjectID, int studentID) {
		super();
		this.subjectID = subjectID;
		this.studentID = studentID;
	}

	public int getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
}
