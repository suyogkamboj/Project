package com.project.sms.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "student_performance")
public class StudentPerformance{

	@EmbeddedId
    private StudentPerformanceId id = new StudentPerformanceId();
	
	@JsonIgnore
    @ManyToOne()
    @MapsId("studentID")
    Students student;
    
    @JsonIgnore
    @ManyToOne()
    @MapsId("subjectID")
    Subjects subjects;
    
    
    @Column(name = "marks")
    private int marks;

    
    public StudentPerformance() {
		super();
	}

	public StudentPerformance(StudentPerformanceId id, Students student, Subjects subjects, int marks) {
		super();
		this.id = id;
		this.student = student;
		this.subjects = subjects;
		this.marks = marks;
	}

	public StudentPerformanceId getId() {
		return id;
	}

	public void setId(StudentPerformanceId id) {
		this.id = id;
	}

	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}

	public Subjects getSubjects() {
		return subjects;
	}

	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "StudentPerformance [id=" + id + ", student=" + student + ", subjects=" + subjects + ", marks=" + marks
				+ "]";
	}

	
}
