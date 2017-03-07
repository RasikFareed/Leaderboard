package com.revature.model.DTO;

public class StudentCourseHoursSpentDTO {
	private String courseName;
	private Integer studentId;
	private Integer hoursSpent;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getHoursSpent() {
		return hoursSpent;
	}

	public void setHoursSpent(Integer hoursSpent) {
		this.hoursSpent = hoursSpent;
	}

	public void setStuId(Object o) {
		if (o != null) {
			this.studentId = Integer.parseInt(o.toString());

		}
	}

	public Object getStuId() {
		return 0;
	}

	public void setHrSpnt(Object o) {
		if (o != null) {
			this.hoursSpent = Integer.parseInt(o.toString());

		}
	}

	public Object getHrSpnt() {
		return 0;
	}

}
