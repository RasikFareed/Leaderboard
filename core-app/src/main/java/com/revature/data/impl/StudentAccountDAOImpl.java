package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.StudentAccount;
import com.revature.model.DTO.StudentAccountDTO;

@Repository
public class StudentAccountDAOImpl implements com.revature.data.StudentAccountDAO {
	private static Logger logger = Logger.getLogger(StudentAccountDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public StudentAccountDTO getId(String emailId, String password) throws DataServiceException {

		StudentAccountDTO studentAccount = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT student_Id  stuId,NAME  name,`USERNAME` username ,`DEPARTMENT` department,COLLEGE_NAME collegeName,Skill_Points skillPts,Activity_Points actPts FROM `vw_student_details` WHERE USERNAME='"
							+ emailId + "'" + " and PASSWORD='" + password + "'");
			studentAccount = (StudentAccountDTO) dataRetriver.retrieveBySQLAsObject(sb.toString(),StudentAccountDTO.class);
			logger.info("Login data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentAccount;

	}

	@Override
	public List<StudentAccount> getActivityPointsByStudentId(Integer studentId) throws DataServiceException {
		List<StudentAccount> studentAccount = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select course_enrollment_points,course_completion_points,project_enrollment_points,project_completion_points,login_points from vw_student_activity_points where student_id="
							+ studentId);
			studentAccount = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Student activity points data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentAccount;
	}

}
