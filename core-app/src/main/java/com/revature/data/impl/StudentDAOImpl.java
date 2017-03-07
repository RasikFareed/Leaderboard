package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.StudentDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.DTO.StudentActivityPointsDTO;
import com.revature.model.DTO.StudentRankDTO;

@Repository
public class StudentDAOImpl implements StudentDAO {
	private static Logger logger = Logger.getLogger(StudentDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<StudentRankDTO> getStudentRanks() throws DataServiceException {
		List<StudentRankDTO> studentRank = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT student_id stuId,NAME name,COLLEGE_NAME collegeName,DEPARTMENT department,"
							+ "ACTIVITY_POINTS actPts,SKILL_POINTS skillPts,TOTAL tot FROM vw_student_rank");
			studentRank = dataRetriver.retrieveBySQLWithResultTransformer(sb.toString(), StudentRankDTO.class);
			logger.info("Student rank data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentRank;
	}

	@Override
	public StudentActivityPointsDTO getStudentActivityPointsByStudentId(Integer studentId) throws DataServiceException {
		StudentActivityPointsDTO studentActivityPoints = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT COURSE_ENROLLMENT_POINTS courseErlPts,COURSE_COMPLETION_POINTS courseCompPts,"
					+ "PROJECT_ENROLLMENT_POINTS projErlPts,PROJECT_COMPLETION_POINTS projCompPts,"
							+ "LOGIN_POINTS loginPts FROM vw_student_activity_points where STUDENT_ID="+studentId);
			studentActivityPoints = (StudentActivityPointsDTO) dataRetriver.retrieveBySQLAsObject(sb.toString(), StudentActivityPointsDTO.class);
			logger.info("Student activity points data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentActivityPoints;
	}

}
