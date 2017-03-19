package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.access.DataModifier;
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
	@Autowired
	private DataModifier dataModifier;

	public DataModifier getDataModifier() {
		return dataModifier;
	}

	public void setDataModifier(DataModifier dataModifier) {
		this.dataModifier = dataModifier;
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
//	@Override
//	public StudentAccountDTO getUserByLogin(String emailId, String password) throws DataServiceException {
//		StudentAccountDTO studentAccountDTOObj = null;
//
//		try {
//			StringBuilder sb = new StringBuilder(
//					"SELECT PASSWORD password FROM student_account WHERE USERNAME='" + emailId + "'");
//			studentAccountDTOObj = (StudentAccountDTO) dataRetriver.retrieveBySQLAsObject(sb.toString(),
//					StudentAccountDTO.class);
//			System.out.println(studentAccountDTOObj);
//			if (studentAccountDTOObj == null)
//				logger.info("User not exists");
//			else {
//				String dbPassword = studentAccountDTOObj.getPassword();
//				logger.info("Pass-db     " + dbPassword);
//				if (DataUtils.checkPassword(password, dbPassword)) {
//					logger.info("User login success...");
//					StringBuilder sb1 = new StringBuilder(
//							"SELECT student_Id  stuId,NAME  name,`USERNAME` username ,`PASSWORD` password,`DEPARTMENT` department,COLLEGE_NAME collegeName,Skill_Points skillPts,Activity_Points actPts FROM `vw_student_details` WHERE USERNAME='"
//									+ emailId + "'" + " and PASSWORD='" + dbPassword + "'");
//					studentAccountDTOObj = (StudentAccountDTO) dataRetriver.retrieveBySQLAsObject(sb1.toString(),
//							StudentAccountDTO.class);
//				} else
//					logger.info("User login failure..." + studentAccountDTOObj);
//				logger.info("Users data retrieval success..");
//			}
//		} catch (DataAccessException e) {
//			logger.error(e.getMessage(), e);
//			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
//		}
//		return studentAccountDTOObj;
//	}
//
//	@Override
//	public String insertUserPassword(String password, String emailId) throws DataServiceException {
//		String hashedPassword = null;
//		int rows = 0;
//		String msg = null;
//		try {
//			hashedPassword = DataUtils.encryptPassword(password);
//			System.out.println(hashedPassword);
//			StringBuilder sb = new StringBuilder("UPDATE student_account SET PASSWORD='" + hashedPassword + "'"
//					+ " WHERE USERNAME='" + emailId + "'");
//			rows = dataModifier.modifyBySQL(sb.toString());
//			if (rows == 0)
//				msg = "Password not inserted...";
//			else
//				msg = "Password inserted...";
//		} catch (DataAccessException e) {
//			logger.error(e.getMessage(), e);
//			throw new DataServiceException(DataUtils.getPropertyMessage("data_modifier_fail"), e);
//		}
//		logger.info(msg);
//		return msg;
//	}

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

