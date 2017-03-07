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
@Table(name = "project_sprint_activities", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "PROJECT_SPRINT_ID", "VIDEO_ID" }),
		@UniqueConstraint(columnNames = { "PROJECT_SPRINT_ID", "COURSE_ID" }),
		@UniqueConstraint(columnNames = { "PROJECT_SPRINT_ID", "QUIZ_ID" }),
		@UniqueConstraint(columnNames = { "PROJECT_SPRINT_ID", "ONLINE_ACTIVITY" }),
		@UniqueConstraint(columnNames = { "PROJECT_SPRINT_ID", "OFFLINE_ACTIVITY" }) })
public class ProjectSprintActivity {

	public ProjectSprintActivity() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne()
	@JoinColumn(name = "PROJECT_SPRINT_ID", nullable = false)
	private ProjectSprint projectSprint;
	@ManyToOne()
	@JoinColumn(name = "VIDEO_ID")
	private Video video;
	@ManyToOne()
	@JoinColumn(name = "COURSE_ID")
	private Course course;
	@ManyToOne()
	@JoinColumn(name = "QUIZ_ID")
	private Quiz quiz;
	@Column(name = "ONLINE_ACTIVITY")
	private String onlineActivity;
	@Column(name = "OFFLINE_ACTIVITY")
	private String offlineActivity;
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
	public ProjectSprint getProjectSprint() {
		return projectSprint;
	}
	public void setProjectSprint(ProjectSprint projectSprint) {
		this.projectSprint = projectSprint;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Quiz getQuiz() {
		return quiz;
	}
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	public String getOnlineActivity() {
		return onlineActivity;
	}
	public void setOnlineActivity(String onlineActivity) {
		this.onlineActivity = onlineActivity;
	}
	public String getOfflineActivity() {
		return offlineActivity;
	}
	public void setOfflineActivity(String offlineActivity) {
		this.offlineActivity = offlineActivity;
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
