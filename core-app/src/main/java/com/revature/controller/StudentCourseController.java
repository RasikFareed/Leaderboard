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
@RequestMapping("/courses")

public class StudentCourseController {
	private static Logger logger = Logger.getLogger(StudentCourseController.class);

	@Autowired
	private StudentCourseService studentCourseService;

	@RequestMapping("/all/student")
	public List<StudentCourse> getActiveStudentCourse() {
		List<StudentCourse> studentcourses = null;
		try {
			logger.info("Getting the student courses data...");
			studentcourses = studentCourseService.getAllStudentCourses();
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

	@RequestMapping("/skill/points/{studentId}")
	public List<StudentCourseSkillPointsDTO> getActiveStudentCourseSkillPointsbyId(@PathVariable("studentId") Integer studentId) {
		List<StudentCourseSkillPointsDTO> studentCourseSkillPoints = null;
		try {
			logger.info("Getting the student courses data...");
			studentCourseSkillPoints = studentCourseService.getStudentCourseSkillPointsByStudentId(studentId);
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

	@RequestMapping("/activity/points/{studentId}")
	public List<StudentCourse> getActiveStudentCourseAtivityPointsbyId(@PathVariable("studentId") Integer studentId) {
		List<StudentCourse> studentcourses = null;
		try {
			logger.info("Getting the student courses data...");
			studentcourses = studentCourseService.getStudentCourseActivityPointsById(studentId);
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

	@RequestMapping(value = "/hoursspent/{studentId}")
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

	@RequestMapping("/percentage/{studentId}")
	public List<StudentCoursePercentageDTO> getCoursePercentageById(@PathVariable("studentId") Integer studentId) {
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

	@RequestMapping("/details/{courseName}")
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

	@RequestMapping("/activity/details/{courseName}")
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