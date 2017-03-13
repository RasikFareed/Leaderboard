package com.revature.model.DTO;

import java.math.BigDecimal;


public class StudentLoginHoursDTO {
	private String dayName;
	private BigDecimal hoursDistribution;

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public BigDecimal getHoursDistribution() {
		return hoursDistribution;
	}

	public void setHoursDistribution(BigDecimal hoursDistribution) {
		this.hoursDistribution = hoursDistribution;
	}


}
