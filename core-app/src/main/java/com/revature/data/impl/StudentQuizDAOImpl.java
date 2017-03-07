package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.StudentQuizDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.StudentQuiz;
import com.revature.model.DTO.StudentQuizSkillPointsDTO;

@Repository

public class StudentQuizDAOImpl implements StudentQuizDAO {
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
	public List<StudentQuiz> getAllStudentQuiz() throws DataServiceException {
		List<StudentQuiz> studentQuizzes = null;
		try {
			StringBuilder sb = new StringBuilder("select * from student_quizes");
			studentQuizzes = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Student quizzes data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentQuizzes;
	}

	@Override
	public List<StudentQuiz> getAllStudentQuizSkillPoints() throws DataServiceException {
		List<StudentQuiz> studentQuizzes = null;
		try {
			StringBuilder sb = new StringBuilder("select * from vw_student_quiz_skill_points");
			studentQuizzes = dataRetriver.retrieveBySQL(sb.toString());
			logger.info("Student Quizzes data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentQuizzes;
	}

	@Override
	public List<StudentQuizSkillPointsDTO> getStudentQuizSkillPointsByStudentId(Integer studentId)
			throws DataServiceException {
		List<StudentQuizSkillPointsDTO> studentQuizSkillPoints = null;
		try {
			StringBuilder sb = new StringBuilder(
					"select NAME quizName,SKILL_POINTS skillPts from vw_student_quiz_skill_points where STUDENT_ID="
							+ studentId);
			studentQuizSkillPoints = dataRetriver.retrieveBySQLWithResultTransformer(sb.toString(),
					StudentQuizSkillPointsDTO.class);
			logger.info("Categories data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentQuizSkillPoints;
	}

}
