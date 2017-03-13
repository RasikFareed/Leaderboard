package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.StudentProjectService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.StudentProject;
import com.revature.model.DTO.StudentProjectPercentageDTO;
import com.revature.model.DTO.StudentProjectSkillPointsDTO;

@RestController
@RequestMapping("/student")
public class StudentProjectController {
	private static Logger logger = Logger.getLogger(CategoryController.class);

	@Autowired
	private StudentProjectService studentProjectService;


	@RequestMapping("{studentId}/project/skillpoints")
	public List<StudentProjectSkillPointsDTO> getProjectSkillPoints(@PathVariable("studentId") Integer studentId) {
		List<StudentProjectSkillPointsDTO> studentProjectSkillPoints = null;
		try {
			logger.info("Getting the student projects data...");
			studentProjectSkillPoints = studentProjectService.getStudentProjectSkillPoints(studentId);
			logger.info("student projects data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentProjectSkillPoints;
	}

	@RequestMapping("{studentId}/project/percentage")
	public List<StudentProjectPercentageDTO> getStudenProjectPercentageCompleted(@PathVariable("studentId") Integer studentId) {
		List<StudentProjectPercentageDTO> studentProjectPercentage = null;
		try {
			logger.info("Getting the student projects data...");
			studentProjectPercentage = studentProjectService.getStudentProjectPercentageCompleted(studentId);
			logger.info("student projects data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentProjectPercentage;
	}

	

	
}
