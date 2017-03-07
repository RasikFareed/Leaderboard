package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.StudentProjectDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.StudentProject;
import com.revature.model.DTO.StudentProjectPercentageDTO;
import com.revature.model.DTO.StudentProjectSkillPointsDTO;

@Repository
public class StudentProjectDAOImpl implements StudentProjectDAO {
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
	public List<StudentProject> getAllStudentProjects() throws DataServiceException {
		List<StudentProject> studentProjects = null;
		try {
			StringBuilder sb = new StringBuilder("select * from student_projects");
			studentProjects = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Student Projects data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjects;
	}

	@Override
	public List<StudentProject> getAllStudentProjectSkillPoints() throws DataServiceException {
		List<StudentProject> studentProjects = null;
		try {
			StringBuilder sb = new StringBuilder("select * from vw_student_project_skill_points");
			studentProjects = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Student Projects Skill Points data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjects;
	}

	@Override
	public List<StudentProject> getAllStudentProjectActivityPoints() throws DataServiceException {
		List<StudentProject> studentProjects = null;
		try {
			StringBuilder sb = new StringBuilder("select * from vw_student_project_activity_points");
			studentProjects = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Student Projects Activity Points data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjects;
	}
	@Override
	public List<StudentProject> getStudentProjectActivityPointsById(Integer studentId) throws DataServiceException {
		List<StudentProject> studentProjects = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select enrollment_points,completion_points from vw_student_project_activity_points where id="
							+ studentId);
			studentProjects = dataRetriver.retrieveBySQLJSON(sb.toString());
			logger.info("Student Projects Activity Points data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjects;
	}

	@Override
	public List<StudentProjectSkillPointsDTO> getStudentProjectSkillPointsByStudentId(Integer studentId) throws DataServiceException {
		List<StudentProjectSkillPointsDTO> studentProjectSkillPoints = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select NAME projectName,SKILL_POINTS skillPts from vw_student_project_skill_points where STUDENT_ID=" + studentId);
			studentProjectSkillPoints = dataRetriver.retrieveBySQLWithResultTransformer(sb.toString(), StudentProjectSkillPointsDTO.class);
			logger.info("Student Projects Activity Points data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectSkillPoints;
	}
	@Override
	public List<StudentProjectPercentageDTO> getStudentProjectPercentageCompleted(Integer studentId) throws DataServiceException {
		List<StudentProjectPercentageDTO> studentProjectPercentage = null;
		try {
			StringBuilder sb = new StringBuilder("SELECT NAME projectName,STUDENT_ID stuId,ROUND(PERCENTAGE) perComp FROM `vw_project_activity_percentage_calculation` WHERE STUDENT_ID=" + studentId);
			studentProjectPercentage = dataRetriver.retrieveBySQLWithResultTransformer(sb.toString(), StudentProjectPercentageDTO.class);
			logger.info("Student Projects percentage data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectPercentage;
	}
}
