package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.StudentQuizService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.DTO.StudentQuizSkillPointsDTO;

@RestController
@RequestMapping("/student")
public class StudentQuizController {
	private static Logger logger = Logger.getLogger(CategoryController.class);

	@Autowired
	private StudentQuizService studentQuizService;

	@RequestMapping("/{studentId}/quiz/skillpoints")
	public List<StudentQuizSkillPointsDTO> getQuizByStudentId(@PathVariable("studentId") Integer studentId) {
		List<StudentQuizSkillPointsDTO> studentQuizSkillPoints = null;
		try {
			logger.info("Getting the student quizzes data...");
			studentQuizSkillPoints = studentQuizService.getStudentQuizSkillPoints(studentId);

			logger.info("student quizzes data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentQuizSkillPoints;
	}
}
