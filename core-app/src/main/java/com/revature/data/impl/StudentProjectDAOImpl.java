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
	public List<StudentProjectSkillPointsDTO> getStudentProjectSkillPoints(Integer studentId) throws DataServiceException {
		List<StudentProjectSkillPointsDTO> studentProjectSkillPoints = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select STUDENT_ID stuId,NAME projectName,SKILL_POINTS skillPts from vw_student_project_skill_points where STUDENT_ID=" + studentId);
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
