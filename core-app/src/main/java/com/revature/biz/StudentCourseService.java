package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentCourse;
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

	List<StudentCourse> getAllStudentCourses() throws BusinessServiceException;

	List<StudentCourseSkillPointsDTO> getStudentCourseSkillPointsByStudentId(Integer studentId) throws BusinessServiceException;

	List<StudentCourse> getStudentCourseActivityPointsById(Integer studentId) throws BusinessServiceException;

	List<StudentCourseHoursSpentDTO> getStudentCourseHoursSpent(Integer studentId) throws BusinessServiceException;

	List<StudentCoursePercentageDTO> getStudentCoursePercentage(Integer studentId) throws BusinessServiceException;

	List<StudentCourse> getStudentCourseDetails(String courseName) throws BusinessServiceException;

	List<StudentCourse> getStudentCourseActivityDetails(String courseName) throws BusinessServiceException;

}