package com.citiustech;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {

	private String course;
	private String courseDuration;

	public Certificate(String course, String courseDuration) {
		super();
		this.course = course;
		this.courseDuration = courseDuration;
	}

	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	@Override
	public String toString() {
		return "Certificate [course=" + course + ", courseDuration=" + courseDuration + "]";
	}

}
