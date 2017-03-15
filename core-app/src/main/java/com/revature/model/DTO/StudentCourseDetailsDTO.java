package com.revature.model.DTO;

public class StudentCourseDetailsDTO {
	private String projectName;
	private String description;
	private Integer videoCount;
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
	public Integer getVideoCount() {
		return videoCount;
	}
	public void setVideoCount(Integer videoCount) {
		videoCount = videoCount;
	}
	public Integer getEnrollmentPoints() {
		return enrollmentPoints;
	}
	public void setEnrollmentPoints(Integer enrollmentpoints) {
		this.enrollmentPoints = enrollmentpoints;
	}
	public Integer getCompletionPoints() {
		return completionPoints;
	}
	public void setCompletionPoints(Integer completionPoints) {
		this.completionPoints = completionPoints;
	}
	public void setVideoCnt(Object o) {
		if (o != null) {
			this.videoCount= Integer.parseInt(o.toString());

		}
	}

	public Object getVideoCnt() {
		return 0;
	}

	public void setEnrPts(Object o) {
		if (o != null) {
			this.enrollmentPoints = Integer.parseInt(o.toString());

		}
	}

	public Object getEnrPtsPts() {
		return 0;
	}
	public void setCompPts(Object o) {
		if (o != null) {
			this.completionPoints = Integer.parseInt(o.toString());

		}
	}

	public Object getCompPtsPts() {
		return 0;
	}
	

}
