package com.revature.model.DTO;

public class StudentprojectDetailsDTO {
	private String projectName;
	private String description;
	private Integer activityCount;
	private Integer enrollmentPoints;
	private Integer completionPoints;
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getActivityCount() {
		return activityCount;
	}
	public void setActivityCount(Integer activityCount) {
		this.activityCount = activityCount;
	}
	public Integer getEnrollmentPoints() {
		return enrollmentPoints;
	}
	public void setEnrollmentPoints(Integer enrollmentPoints) {
		this.enrollmentPoints = enrollmentPoints;
	}
	public Integer getCompletionPoints() {
		return completionPoints;
	}
	public void setCompletionPoints(Integer completionPoints) {
		this.completionPoints = completionPoints;
	}
	public void setActivityCnt(Object o) {
		if (o != null) {
			this.activityCount= Integer.parseInt(o.toString());

		}
	}

	public Object getActivityCnt() {
		return 0;
	}

	public void setEnrPts(Object o) {
		if (o != null) {
			this.enrollmentPoints = Integer.parseInt(o.toString());

		}
	}

	public Object getEnrPts() {
		return 0;
	}
	public void setCompPts(Object o) {
		if (o != null) {
			this.completionPoints = Integer.parseInt(o.toString());

		}
	}

	public Object getCompPts() {
		return 0;
	}
	

}
