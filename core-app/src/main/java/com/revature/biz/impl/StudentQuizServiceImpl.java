package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.StudentQuizService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.StudentQuizDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentQuiz;
import com.revature.model.DTO.StudentQuizSkillPointsDTO;

@Service
public class StudentQuizServiceImpl implements StudentQuizService {
	private static Logger logger = Logger.getLogger(StudentQuizServiceImpl.class);

	@Autowired
	private StudentQuizDAO studentQuizDAO;

	@Override
	public List<StudentQuiz> getAllStudentQuiz() throws BusinessServiceException {
		return null;
	}

	public List<StudentQuiz> getAllStudentQuizSkillPoints() throws BusinessServiceException {
		List<StudentQuiz> studentQuizzes = null;
		try {
			studentQuizzes = studentQuizDAO.getAllStudentQuizSkillPoints();
			logger.info("Student Quiz Skill retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentQuizzes;
	}

	@Override
	public List<StudentQuizSkillPointsDTO> getStudentQuizSkillPointsByStudentId(Integer studentId) throws BusinessServiceException {
		List<StudentQuizSkillPointsDTO> studentQuizSkillPoints = null;
		try {
			studentQuizSkillPoints = studentQuizDAO.getStudentQuizSkillPointsByStudentId(studentId);
			logger.info("Student Quiz Skill retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentQuizSkillPoints;
	}
}
