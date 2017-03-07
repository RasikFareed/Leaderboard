package com.revature.model.DTO;

public class StudentQuizSkillPointsDTO {
	private String quizName;
	private Integer skillPoints;

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
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
