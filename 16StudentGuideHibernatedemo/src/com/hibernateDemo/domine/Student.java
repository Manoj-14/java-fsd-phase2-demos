package com.hibernateDemo.domine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="enrollment_id")
	private String enrollmentid;
	
	@ManyToOne
	@JoinColumn(name  ="guide_id")
	private Guide guide;
	
	private String name;

	public Student(String enrollmentid, Guide guide, String name) {
		this.enrollmentid = enrollmentid;
		this.guide = guide;
		this.name = name;
	}
	
	
}
