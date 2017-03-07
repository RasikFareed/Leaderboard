package com.revature.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "point_settings")
public class PointSetting {
	public PointSetting() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "LOGIN_ACTIVITY_ID", nullable = false)
	private LoginActivity loginActivity;
	@Column(nullable=false)
	private Integer points;
	@Column(name = "IS_ACTIVE")
	private Boolean isActive = true;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LoginActivity getLoginActivity() {
		return loginActivity;
	}
	public void setLoginActivity(LoginActivity loginActivity) {
		this.loginActivity = loginActivity;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
}
