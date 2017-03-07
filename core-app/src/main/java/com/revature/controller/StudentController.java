package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.StudentService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.DTO.StudentActivityPointsDTO;
import com.revature.model.DTO.StudentRankDTO;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	private static Logger logger = Logger.getLogger(StudentController.class);
	
	
	@RequestMapping(value="rank")
	public @ResponseBody List<StudentRankDTO> getActiveStudentAccountController() {
		List<StudentRankDTO> studentRank = null;

		try {
			logger.info("Getting the student rank data...");
			studentRank=studentService.getStudentRanks();
			logger.info("student rank retrieval success");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		 return studentRank;
	}
	@RequestMapping(value="activity/points/{studentId}")
	public StudentActivityPointsDTO getStudentActivityPointsByStudentId(@PathVariable("studentId") Integer studentId) {
		StudentActivityPointsDTO studentActivityPoints = null;

		try {
			logger.info("Getting the student rank data...");
			studentActivityPoints=studentService.getStudentActivityPointsByStudentId(studentId);
			logger.info("student activity points retrieval success");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		 return studentActivityPoints;
	}
	
}
