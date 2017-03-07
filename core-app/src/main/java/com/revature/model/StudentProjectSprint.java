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

@Entity
@Table(name = "student_project_sprints")
public class StudentProjectSprint {

	public StudentProjectSprint() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "STUDENT_PROJECT_ID", nullable = false)
	private StudentProject studentProject;
	@ManyToOne
	@JoinColumn(name = "PROJECT_SPRINT_ID", nullable = false)
	private ProjectSprint projectSprint;
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

	public StudentProject getStudentProject() {
		return studentProject;
	}

	public void setStudentProject(StudentProject studentProject) {
		this.studentProject = studentProject;
	}

	public ProjectSprint getProjectSprint() {
		return projectSprint;
	}

	public void setProjectSprint(ProjectSprint projectSprint) {
		this.projectSprint = projectSprint;
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
