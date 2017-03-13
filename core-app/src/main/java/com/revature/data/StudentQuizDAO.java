package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentQuiz;
import com.revature.model.DTO.StudentQuizSkillPointsDTO;

public interface StudentQuizDAO {

	/**
	 * Used to get the student quiz skill points data from db.
	 * 
	 * @return studentQuizSkillPoints
	 * @throws DataServiceException
	 *             if any exception happens while executing the query
	 */

	public List<StudentQuizSkillPointsDTO> getStudentQuizSkillPoints(Integer studentId)
			throws DataServiceException;

}
