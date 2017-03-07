package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.StudentCourseService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.StudentCourseDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentCourse;
import com.revature.model.DTO.StudentCourseHoursSpentDTO;
import com.revature.model.DTO.StudentCoursePercentageDTO;
import com.revature.model.DTO.StudentCourseSkillPointsDTO;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {
	private static Logger logger = Logger.getLogger(StudentCourseServiceImpl.class);

	@Autowired
	private StudentCourseDAO studentcourseDAO;

	@Override
	public List<StudentCourse> getAllStudentCourses() throws BusinessServiceException {
		List<StudentCourse> studentCourses = null;
		try {
			studentCourses = studentcourseDAO.getAllStudentCourses();
			logger.info("student courses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentCourses;
	}

	@Override
	public List<StudentCourseSkillPointsDTO> getStudentCourseSkillPointsByStudentId(Integer studentId)
			throws BusinessServiceException {
		List<StudentCourseSkillPointsDTO> studentCourses = null;
		try {
			studentCourses = studentcourseDAO.getStudentCourseSkillPointsByStudentId(studentId);
			logger.info("student courses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentCourses;

	}

	@Override
	public List<StudentCourse> getStudentCourseActivityPointsById(Integer studentId) throws BusinessServiceException {
		List<StudentCourse> studentCourses = null;
		try {
			studentCourses = studentcourseDAO.getStudentCourseActivityPointsById(studentId);
			logger.info("student courses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentCourses;

	}

	@Override
	public List<StudentCourseHoursSpentDTO> getStudentCourseHoursSpent(Integer studentId)
			throws BusinessServiceException {
		List<StudentCourseHoursSpentDTO> studentCoursesHoursSpent = null;
		try {
			studentCoursesHoursSpent = studentcourseDAO.getStudentCourseHoursSpent(studentId);
			logger.info("student courses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentCoursesHoursSpent;

	}

	@Override
	public List<StudentCoursePercentageDTO> getStudentCoursePercentage(Integer studentId)
			throws BusinessServiceException {
		List<StudentCoursePercentageDTO> studentCourses = null;
		try {
			studentCourses = studentcourseDAO.getStudentCoursePercentage(studentId);
			logger.info("student courses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentCourses;
	}

	@Override
	public List<StudentCourse> getStudentCourseDetails(String courseName) throws BusinessServiceException {
		List<StudentCourse> studentCourses = null;
		try {
			studentCourses = studentcourseDAO.getStudentCourseDetails(courseName);
			logger.info("student courses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentCourses;
	}

	@Override
	public List<StudentCourse> getStudentCourseActivityDetails(String courseName) throws BusinessServiceException {
		List<StudentCourse> studentCourses = null;
		try {
			studentCourses = studentcourseDAO.getStudentCourseActivityDetails(courseName);
			logger.info("student courses retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentCourses;
	}

}