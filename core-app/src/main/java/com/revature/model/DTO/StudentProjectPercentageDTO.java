package com.revature.model.DTO;

public class StudentProjectPercentageDTO {
	private Integer studentId;
	private String projectName;
	private Integer percentageCompleted;

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

	public Integer getPercentageCompleted() {
		return percentageCompleted;
	}

	public void setPercentageCompleted(Integer percentageCompleted) {
		this.percentageCompleted = percentageCompleted;
	}

	public void setStuId(Object o) {
		if (o != null) {
			this.studentId = Integer.parseInt(o.toString());

		}
	}

	public Object getStuId() {
		return 0;
	}

	public void setPerComp(Object o) {
		if (o != null) {
			this.percentageCompleted = Integer.parseInt(o.toString());

		}
	}

	public Object getPerComp() {
		return 0;
	}

}
