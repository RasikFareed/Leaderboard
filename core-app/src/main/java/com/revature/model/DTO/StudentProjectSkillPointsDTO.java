package com.revature.model.DTO;

public class StudentProjectSkillPointsDTO {
	private Integer studentId;
	private String projectName;
	private Integer skillPoints;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getSkillPoints() {
		return skillPoints;
	}

	public void setSkillPoints(Integer skillPoints) {
		this.skillPoints = skillPoints;
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

}
