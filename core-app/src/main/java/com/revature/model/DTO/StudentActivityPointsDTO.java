package com.revature.model.DTO;

public class StudentActivityPointsDTO {
	private Integer CourseEnrollmentPoints;
	private Integer CourseCompletionPoints;
	private Integer ProjectEnrollmentPoints;
	private Integer ProjectCompletionPoints;
	private Integer LoginPoints;

	public Integer getCourseEnrollmentPoints() {
		return CourseEnrollmentPoints;
	}

	public void setCourseEnrollmentPoints(Integer CourseEnrollmentPoints) {
		this.CourseEnrollmentPoints = CourseEnrollmentPoints;
	}

	public Integer getCourseCompletionPoints() {
		return CourseCompletionPoints;
	}

	public void setCourseCompletionPoints(Integer CourseCompletionPoints) {
		this.CourseCompletionPoints = CourseCompletionPoints;
	}

	public Integer getProjectEnrollmentPoints() {
		return ProjectEnrollmentPoints;
	}

	public void setProjectEnrollmentPoints(Integer ProjectEnrollmentPoints) {
		this.ProjectEnrollmentPoints = ProjectEnrollmentPoints;
	}

	public Integer getProjectCompletionPoints() {
		return ProjectCompletionPoints;
	}

	public void setProjectCompletionPoints(Integer ProjectCompletionPoints) {
		this.ProjectCompletionPoints = ProjectCompletionPoints;
	}

	public Integer getLoginPoints() {
		return LoginPoints;
	}

	public void setLoginPoints(Integer LoginPoints) {
		this.LoginPoints = LoginPoints;
	}

	public void setCourseErlPts(Object o) {
		if (o != null) {
			this.CourseEnrollmentPoints = Integer.parseInt(o.toString());

		}
	}

	public Object getCourseErlPts() {
		return 0;
	}

	public void setCourseCompPts(Object o) {
		if (o != null) {
			this.CourseCompletionPoints = Integer.parseInt(o.toString());

		}
	}

	public Object getCourseCompPts() {
		return 0;
	}

	public void setProjErlPts(Object o) {
		if (o != null) {
			this.ProjectEnrollmentPoints = Integer.parseInt(o.toString());

		}
	}

	public Object getProjErlPts() {
		return 0;
	}

	public void setProjCompPts(Object o) {
		if (o != null) {
			this.ProjectCompletionPoints = Integer.parseInt(o.toString());

		}
	}

	public Object getProjCompPts() {
		return 0;
	}

	public void setLoginPts(Object o) {
		if (o != null) {
			this.LoginPoints = Integer.parseInt(o.toString());

		}
	}

	public Object getLoginPts() {
		return 0;
	}

}
