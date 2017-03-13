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
	public List<StudentQuizSkillPointsDTO> getStudentQuizSkillPoints(Integer studentId)
			throws DataServiceException {
		List<StudentQuizSkillPointsDTO> studentQuizSkillPoints = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT quizzes.`NAME` quizName,quizzes.`SKILL_POINTS` skillPts FROM student_quizes JOIN quizzes ON quizzes.`ID`=student_quizes.`QUIZ_ID` RIGHT JOIN students ON students.`ID`=student_quizes.`STUDENT_ID` WHERE student_quizes.`STATUS_ID`=2 and student_id="
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
