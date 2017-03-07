package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
	public Course() {

	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne()
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	private Category category;
	@ManyToOne()
	@JoinColumn(name = "LEVEL_ID", nullable = false)
	private Level level;
	@Column(unique = true, nullable = false)
	private String name;
	@Column(nullable = false)
	private String description;
	@Column(name = "ENROLLMENT_POINTS", nullable = false)
	private Integer enrollmentPoints;
	@Column(name = "COMPLETION_POINTS", nullable = false)
	private Integer completionPoints;
	@Column(name = "IS_ACTIVE")
	private Boolean isActive = true;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getEnrollmentPoints() {
		return enrollmentPoints;
	}
	public void setEnrollmentPoints(Integer enrollmentPoints) {
		this.enrollmentPoints = enrollmentPoints;
	}
	public Integer getCompletionPoints() {
		return completionPoints;
	}
	public void setCompletionPoints(Integer completionPoints) {
		this.completionPoints = completionPoints;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	

}
