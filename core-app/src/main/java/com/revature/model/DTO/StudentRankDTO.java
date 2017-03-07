package com.revature.model.DTO;

public class StudentRankDTO {
	private Integer studentId;
	private String name;
	private String college;
	private String department;
	private Integer activityPoints;
	private Integer skillPoints;
	private Integer total;

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

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getActivityPoints() {
		return activityPoints;
	}

	public void setActivityPoints(Integer activityPoints) {
		this.activityPoints = activityPoints;
	}

	public Integer getSkillPoints() {
		return skillPoints;
	}

	public void setSkillPoints(Integer skillPoints) {
		this.skillPoints = skillPoints;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
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
	}

	public Object getActPts() {
		return 0;
	}

	public void setTot(Object o) {
		if (o != null) {
			this.total = Integer.parseInt(o.toString());

		}
	}

	public Object getTot() {
		return 0;
	}

}
