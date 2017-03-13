package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.StudentCourseService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.StudentCourse;
import com.revature.model.DTO.StudentCourseHoursSpentDTO;
import com.revature.model.DTO.StudentCoursePercentageDTO;
import com.revature.model.DTO.StudentCourseSkillPointsDTO;

@RestController
@RequestMapping("/student")

public class StudentCourseController {
	private static Logger logger = Logger.getLogger(StudentCourseController.class);

	@Autowired
	private StudentCourseService studentCourseService;

	
	@RequestMapping("{studentId}/course/skillpoints")
	public List<StudentCourseSkillPointsDTO> getActiveStudentCourseSkillPointsbyId(@PathVariable("studentId") Integer studentId) {
		List<StudentCourseSkillPointsDTO> studentCourseSkillPoints = null;
		try {
			logger.info("Getting the student courses data...");
			studentCourseSkillPoints = studentCourseService.getStudentCourseSkillPoints(studentId);
			logger.info("student courses data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentCourseSkillPoints;
	}

	
	@RequestMapping(value = "{studentId}/course/hoursspent")
	public List<StudentCourseHoursSpentDTO> getStudentCourseHoursSpent(@PathVariable("studentId") Integer studentId) {
		List<StudentCourseHoursSpentDTO> studentCourseHoursSpent = null;

		try {

			logger.info("Getting the student courses data...");
			studentCourseHoursSpent = studentCourseService.getStudentCourseHoursSpent(studentId);
			logger.info("student courses data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentCourseHoursSpent;
	}

	@RequestMapping("{studentId}/course/percentage")
	public List<StudentCoursePercentageDTO> getCoursePercentage(@PathVariable("studentId") Integer studentId) {
		List<StudentCoursePercentageDTO> studentcourses = null;
		try {
			logger.info("Getting the student courses data...");
			studentcourses = studentCourseService.getStudentCoursePercentage(studentId);
			logger.info("student courses data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentcourses;
	}

	@RequestMapping("course/{courseName}/coursedetails")
	public List<StudentCourse> getStudentCourseDetailsByCourseName(@PathVariable("courseName") String courseName) {
		List<StudentCourse> studentcourses = null;
		try {
			logger.info("Getting the student courses data...");
			studentcourses = studentCourseService.getStudentCourseDetails(courseName);
			logger.info("student courses data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentcourses;
	}

	@RequestMapping("course/{courseName}/activitydetails")
	public List<StudentCourse> getStudentCourseActivityDetailsByCourseName(
			@PathVariable("courseName") String courseName) {
		List<StudentCourse> studentcourses = null;
		try {
			logger.info("Getting the student courses data...");
			studentcourses = studentCourseService.getStudentCourseActivityDetails(courseName);
			logger.info("student courses data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentcourses;
	}

}