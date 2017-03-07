package com.revature.model.DTO;

public class StudentCoursePercentageDTO {
	private Integer studentId;
	private String courseName;
	private Integer percentageCompleted;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
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
