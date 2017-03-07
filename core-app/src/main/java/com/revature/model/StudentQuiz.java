package com.revature.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "student_quizes")
public class StudentQuiz {

	public StudentQuiz() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "STUDENT_ID", nullable = false)
	private Student student;
	@ManyToOne
	@JoinColumn(name = "QUIZ_ID", nullable = false)
	private Quiz quiz;
	@Column(name = "STARTED_ON")
//	@Temporal(TemporalType.TIME)
	private Time startedOn;
	@Column(name = "COMPLETED_ON")
//	@Temporal(TemporalType.TIME)
	private Time completedOn;
	@Column(nullable = false)
	private Integer score;
	@ManyToOne
	@JoinColumn(name = "STATUS_ID")
	private SeedStatus status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Time getStartedOn() {
		return startedOn;
	}

	public void setStartedOn(Time startedOn) {
		this.startedOn = startedOn;
	}

	public Time getCompletedOn() {
		return completedOn;
	}

	public void setCompletedOn(Time completedOn) {
		this.completedOn = completedOn;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public SeedStatus getStatus() {
		return status;
	}

	public void setStatus(SeedStatus status) {
		this.status = status;
	}

}
