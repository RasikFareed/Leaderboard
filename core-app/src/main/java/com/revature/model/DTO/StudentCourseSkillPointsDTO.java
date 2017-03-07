package com.revature.model.DTO;

public class StudentCourseSkillPointsDTO {

	private String courseName;
	private Integer skillPoints;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getSkillPoints() {
		return skillPoints;
	}

	public void setSkillPoints(Integer skillPoints) {
		this.skillPoints = skillPoints;
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
