package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.StudentCourse;
import com.revature.model.DTO.StudentCourseDetailsDTO;
import com.revature.model.DTO.StudentCourseHoursSpentDTO;
import com.revature.model.DTO.StudentCoursePercentageDTO;
import com.revature.model.DTO.StudentCourseSkillPointsDTO;

public interface StudentCourseService {

	/**
	 * Used to get all the student courses.
	 * 
	 * @return student courses
	 * @throws BusinessServiceException
	 *             if any business error occurs
	 */


	List<StudentCourseSkillPointsDTO> getStudentCourseSkillPoints(Integer studentId) throws BusinessServiceException;

	List<StudentCourseHoursSpentDTO> getStudentCourseHoursSpent(Integer studentId) throws BusinessServiceException;

	List<StudentCoursePercentageDTO> getStudentCoursePercentage(Integer studentId) throws BusinessServiceException;

	List<StudentCourseDetailsDTO> getStudentCourseDetails(String courseName) throws BusinessServiceException;

	List<StudentCourse> getStudentCourseActivityDetails(String courseName) throws BusinessServiceException;

}