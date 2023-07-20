package com.citiustech.oneToMany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long instructorId;
	@Column(nullable = false)
	private String instructorName;
	@Column(nullable = false)
	private String summary;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "instructor", fetch = FetchType.EAGER)
	private Set<Course> courses;

	public long getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(long instructorId) {
		this.instructorId = instructorId;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Instructor(long instructorId, String instructorName, String summary, Set<Course> courses) {
		super();
		this.instructorId = instructorId;
		this.instructorName = instructorName;
		this.summary = summary;
		this.courses = courses;
	}

	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Instructor [instructorId=" + instructorId + ", instructorName=" + instructorName + ", summary="
				+ summary + "]";
	}

}
