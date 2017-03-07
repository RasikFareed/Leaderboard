package com.revature.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "student_course_contents", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "STUDENT_COURSE_ID", "COURSE_CONTENT_ID" }) })
public class StudentCourseContent {

	public StudentCourseContent() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne()
	@JoinColumn(name = "STUDENT_COURSE_ID", nullable = false)
	private StudentCourse sudentCourse;
	@ManyToOne()
	@JoinColumn(name = "COURSE_CONTENT_ID", nullable = false)
	private CourseContent courseContent;
	@Column(name = "STARTED_ON")
	@Temporal(TemporalType.DATE)
	private Date startedOn;
	@Column(name = "COMPLETED_ON")
	@Temporal(TemporalType.DATE)
	private Date completedOn;
	@ManyToOne
	@JoinColumn(name = "STATUS_ID")
	private SeedStatus status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StudentCourse getSudentCourse() {
		return sudentCourse;
	}

	public void setSudentCourse(StudentCourse sudentCourse) {
		this.sudentCourse = sudentCourse;
	}

	public CourseContent getCourseContent() {
		return courseContent;
	}

	public void setCourseContent(CourseContent courseContent) {
		this.courseContent = courseContent;
	}

	public Date getStartedOn() {
		return startedOn;
	}

	public void setStartedOn(Date startedOn) {
		this.startedOn = startedOn;
	}

	public Date getCompletedOn() {
		return completedOn;
	}

	public void setCompletedOn(Date completedOn) {
		this.completedOn = completedOn;
	}

	public SeedStatus getStatus() {
		return status;
	}

	public void setStatus(SeedStatus status) {
		this.status = status;
	}

}
