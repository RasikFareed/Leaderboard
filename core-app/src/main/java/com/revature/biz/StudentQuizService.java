package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.DTO.StudentQuizSkillPointsDTO;

public interface StudentQuizService {
	/**
	 * Used to get all the student quiz skill points.
	 * 
	 * @return studentQuizSkillPoints
	 * @throws BusinessServiceException
	 *             if any business error occurs
	 */

	List<StudentQuizSkillPointsDTO> getStudentQuizSkillPoints(Integer studentId) throws BusinessServiceException;

}
