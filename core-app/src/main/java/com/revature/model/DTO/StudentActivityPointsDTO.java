package com.revature.model.DTO;

public class StudentActivityPointsDTO {
	private Integer courseEnrollmentPoints;
	private Integer courseCompletionPoints;
	private Integer projectEnrollmentPoints;
	private Integer projectCompletionPoints;
	private Integer loginPoints;

	public Integer getCourseEnrollmentPoints() {
		return courseEnrollmentPoints;
	}

	public void setCourseEnrollmentPoints(Integer courseEnrollmentPoints) {
		this.courseEnrollmentPoints = courseEnrollmentPoints;
	}

	public Integer getCourseCompletionPoints() {
		return courseCompletionPoints;
	}

	public void setCourseCompletionPoints(Integer courseCompletionPoints) {
		this.courseCompletionPoints = courseCompletionPoints;
	}

	public Integer getProjectEnrollmentPoints() {
		return projectEnrollmentPoints;
	}

	public void setProjectEnrollmentPoints(Integer projectEnrollmentPoints) {
		this.projectEnrollmentPoints = projectEnrollmentPoints;
	}

	public Integer getProjectCompletionPoints() {
		return projectCompletionPoints;
	}

	public void setProjectCompletionPoints(Integer projectCompletionPoints) {
		this.projectCompletionPoints = projectCompletionPoints;
	}

	public Integer getLoginPoints() {
		return loginPoints;
	}

	public void setLoginPoints(Integer loginPoints) {
		this.loginPoints = loginPoints;
	}

	public void setCourseErlPts(Object o) {
		if (o != null) {
			this.courseEnrollmentPoints = Integer.parseInt(o.toString());

		}
	}

	public Object getCourseErlPts() {
		return 0;
	}

	public void setCourseCompPts(Object o) {
		if (o != null) {
			this.courseCompletionPoints = Integer.parseInt(o.toString());

		}
	}

	public Object getCourseCompPts() {
		return 0;
	}

	public void setProjErlPts(Object o) {
		if (o != null) {
			this.projectEnrollmentPoints = Integer.parseInt(o.toString());

		}
	}

	public Object getProjErlPts() {
		return 0;
	}

	public void setProjCompPts(Object o) {
		if (o != null) {
			this.projectCompletionPoints = Integer.parseInt(o.toString());

		}
	}

	public Object getProjCompPts() {
		return 0;
	}

	public void setLoginPts(Object o) {
		if (o != null) {
			this.loginPoints = Integer.parseInt(o.toString());

		}
	}

	public Object getLoginPts() {
		return 0;
	}

}
