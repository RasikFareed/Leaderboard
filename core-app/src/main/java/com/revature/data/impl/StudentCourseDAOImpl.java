package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.StudentCourseDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.StudentCourse;
import com.revature.model.DTO.StudentCourseHoursSpentDTO;
import com.revature.model.DTO.StudentCoursePercentageDTO;
import com.revature.model.DTO.StudentCourseSkillPointsDTO;

@Repository
public class StudentCourseDAOImpl implements StudentCourseDAO {
	public StudentCourseDAOImpl() {
	}

	private static Logger logger = Logger.getLogger(CategoryDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

		@Override
	public List<StudentCourseSkillPointsDTO> getStudentCourseSkillPoints(Integer studentId)
			throws DataServiceException {
		List<StudentCourseSkillPointsDTO> studentCourseSkillPoints = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT NAME courseName,SKILL_POINTS skillPts FROM vw_student_course_skill_points WHERE STUDENT_ID="
							+ studentId);
			studentCourseSkillPoints = dataRetriver.retrieveBySQLWithResultTransformer(sb.toString(),
					StudentCourseSkillPointsDTO.class);
			logger.info("Student courses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCourseSkillPoints;
	}

	@Override
	public List<StudentCourseHoursSpentDTO> getStudentCourseHoursSpent(Integer studentId) throws DataServiceException {
		List<StudentCourseHoursSpentDTO> studentCoursesHoursSpent = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT NAME courseName,STUDENT_ID stuId,HOURS_SPENT hrSpnt FROM vw_student_course_hours_spent WHERE STUDENT_ID="
							+ studentId);
			studentCoursesHoursSpent = dataRetriver.retrieveBySQLWithResultTransformer(sb.toString(),
					StudentCourseHoursSpentDTO.class);
			logger.info("Student courses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCoursesHoursSpent;
	}

	@Override
	public List<StudentCoursePercentageDTO> getStudentCoursePercentage(Integer studentId) throws DataServiceException {
		List<StudentCoursePercentageDTO> studentCoursesPercentage = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT STUDENT_ID stuId,NAME courseName,PERCENTAGE perComp FROM vw_student_course_percentage_calculation WHERE STUDENT_ID="
							+ studentId);
			studentCoursesPercentage = dataRetriver.retrieveBySQLWithResultTransformer(sb.toString(),
					StudentCoursePercentageDTO.class);
			logger.info("Student courses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCoursesPercentage;
	}

	@Override
	public List<StudentCourse> getStudentCourseDetails(String courseName) throws DataServiceException {
		List<StudentCourse> studentCourses = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT * FROM VW_STUDENT_COURSE_DETAILS WHERE COURSE_NAME = '" + courseName + "'");
			studentCourses = dataRetriver.retrieveBySQLJSON(sb.toString());
			logger.info("Student courses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCourses;
	}

	@Override
	public List<StudentCourse> getStudentCourseActivityDetails(String courseName) throws DataServiceException {
		List<StudentCourse> studentCourses = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT ACTIVITY_NAME FROM VW_STUDENT_COURSE_ACTIVITY_DETAILS WHERE COURSE_NAME = '" + courseName
							+ "'");
			studentCourses = dataRetriver.retrieveBySQLJSON(sb.toString());
			logger.info("Student courses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCourses;
	}

}