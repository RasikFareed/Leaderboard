package com.revature.model.DTO;


public class StudentAccountDTO {

	private Integer studentId;
	private String name;
	private String username;
	private String password;
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	private String department;
	private String collegeName;
	private Integer skillPoints;
	private Integer activityPoints;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public Integer getSkillPoints() {
		return skillPoints;
	}

	public void setSkillPoints(Integer skillPoints) {
		this.skillPoints = skillPoints;
	}

	public Integer getActivityPoints() {
		return activityPoints;
	}

	public void setActivityPoints(Integer activityPoints) {
		this.activityPoints = activityPoints;
	}

	public void setStuId(Object o) {
		if (o != null) {
			this.studentId = Integer.parseInt(o.toString());

		}
	}

	public Object getStuId() {
		return 0;
	}

	public void setSkillPts(Object o) {
		if (o != null) {
			this.skillPoints = Integer.parseInt(o.toString());

		}
	}

	public Object getSkillPts() {
		return 0;
	}

	public void setActPts(Object o) {
		if (o != null) {
			this.activityPoints = Integer.parseInt(o.toString());

		}
	}public Object getActPts() {
		return 0;
	}

}
