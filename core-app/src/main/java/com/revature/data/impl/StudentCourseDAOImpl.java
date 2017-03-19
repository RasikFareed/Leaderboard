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
import com.revature.model.StudentProject;
import com.revature.model.DTO.StudentCourseActivityDetailsDTO;
import com.revature.model.DTO.StudentCourseDetailsDTO;
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
					"SELECT`courses`.`NAME` courseName,SUM(`course_contents`.`SKILL_POINTS`) skillPts FROM ((`student_courses` LEFT JOIN (`student_course_contents`JOIN `course_contents`ON ((`course_contents`.`ID` = `student_course_contents`.`COURSE_CONTENT_ID`)))ON ((`student_courses`.`ID` = `student_course_contents`.`STUDENT_COURSE_ID`)))JOIN `courses` ON ((`courses`.`ID` = `course_contents`.`COURSE_ID`))) WHERE `student_course_contents`.`STATUS_ID` = 2 GROUP BY `student_courses`.`STUDENT_ID`,`courses`.`NAME` having student_id="
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
					"SELECT`courses`.`NAME`courseName,`student_courses`.`STUDENT_ID` stuId,SUM(`course_contents`.`DURATION_IN_MINUTES`) hrSpnt FROM ((`student_courses`LEFT JOIN (`student_course_contents`JOIN `course_contents`ON ((`course_contents`.`ID` = `student_course_contents`.`COURSE_CONTENT_ID`)))ON ((`student_courses`.`ID` = `student_course_contents`.`STUDENT_COURSE_ID`)))JOIN `courses`ON ((`courses`.`ID` = `course_contents`.`COURSE_ID`)))WHERE (`student_course_contents`.`STATUS_ID` = 2)GROUP BY `student_courses`.`STUDENT_ID`,`courses`.`NAME` having student_id="
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
					"SELECT students.`ID` stuId,courses.`NAME` courseName,ROUND((COUNT(DISTINCT COURSE_CONTENT_ID) / COUNT(DISTINCT VIDEO_ID))*100) perComp FROM students JOIN student_courses ON students.`ID`=student_courses.`STUDENT_ID` JOIN courses ON student_courses.`COURSE_ID`=courses.`ID` JOIN  student_course_contents ON student_course_contents.`STUDENT_COURSE_ID`=student_courses.`ID` JOIN `course_contents` ON `course_contents`.`COURSE_ID`=courses.`ID`GROUP  BY `student_course_contents`.`STUDENT_COURSE_ID` having students.id="+ studentId);
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
	public List<StudentCourseDetailsDTO> getStudentCourseDetails(String courseName) throws DataServiceException {
		List<StudentCourseDetailsDTO> studentCoursesDTO = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT  DISTINCT courses.`NAME` courseName,COUNT(DISTINCT VIDEO_ID) AS videoCnt,courses.`DESCRIPTION` description ,courses.`ENROLLMENT_POINTS` enrPts,courses.`COMPLETION_POINTS` compPts FROM students JOIN student_courses ON students.`ID`=student_courses.`STUDENT_ID`JOIN courses ON student_courses.`COURSE_ID`=courses.`ID` JOIN  student_course_contents ON student_course_contents.`STUDENT_COURSE_ID`=student_courses.`ID`JOIN `course_contents` ON `course_contents`.`COURSE_ID`=courses.`ID`GROUP  BY `student_course_contents`.`STUDENT_COURSE_ID` having courses.NAME='" + courseName + "'");
			studentCoursesDTO = dataRetriver.retrieveBySQLWithResultTransformer(sb.toString(), StudentCourseDetailsDTO.class);;
			logger.info("Student courses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCoursesDTO;
	}

	@Override
	public List<StudentCourseActivityDetailsDTO> getStudentCourseActivityDetails(String courseName) throws DataServiceException {
		List<StudentCourseActivityDetailsDTO> studentCourses = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT `courses`.`NAME` courseName,`course_contents`.`NAME` activityName FROM (`courses` JOIN `course_contents`ON ((`course_contents`.`COURSE_ID` = `courses`.`ID`))) WHERE courses.NAME='" + courseName+ "'");
			studentCourses = dataRetriver.retrieveBySQLWithResultTransformer(sb.toString(),StudentCourseActivityDetailsDTO.class);
			logger.info("Student courses data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentCourses;
	}

}