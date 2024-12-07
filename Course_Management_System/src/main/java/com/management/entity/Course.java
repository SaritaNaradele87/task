package com.management.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Course {
	@Id
	Integer id;
	String courseName;
	Double fees;
    String instructor;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Double getFees() {
		return fees;
	}
	public void setFees(Double fees) {
		this.fees = fees;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public Course(Integer id, String courseName, Double fees, String instructor) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.fees = fees;
		this.instructor = instructor;
	}
}
