
package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "course_contents", uniqueConstraints = { @UniqueConstraint(columnNames = { "COURSE_ID", "VIDEO_ID" }),
		@UniqueConstraint(columnNames = { "COURSE_ID", "TEXT_CONTENT" }) })
public class CourseContent {
	public CourseContent() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne()
	@JoinColumn(name = "COURSE_ID", nullable = false)
	private Course course;
	@ManyToOne()
	@JoinColumn(name = "VIDEO_ID")
	private Video video;
	@Column(name = "TEXT_CONTENT")
	private String textContent;
	@Column(nullable = false)
	private String name;
	@Column(name = "SKILL_POINTS", nullable = false)
	private Integer skillPoints;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public String getTextContent() {
		return textContent;
	}
	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSkillPoints() {
		return skillPoints;
	}
	public void setSkillPoints(Integer skillPoints) {
		this.skillPoints = skillPoints;
	}

	
}
