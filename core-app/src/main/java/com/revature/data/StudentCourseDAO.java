package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentCourse;
import com.revature.model.DTO.StudentCourseHoursSpentDTO;
import com.revature.model.DTO.StudentCoursePercentageDTO;
import com.revature.model.DTO.StudentCourseSkillPointsDTO;

public interface StudentCourseDAO {

	/**
	 * Used to get the student course skill points data from db.
	 * 
	 * @return student course skill points
	 * @throws DataServiceException
	 *             if any exception happens while executing the query
	 */
	public List<StudentCourseSkillPointsDTO> getStudentCourseSkillPoints(Integer studentId) throws DataServiceException;

	/**
	 * Used to get the student course hours spent data from db.
	 * 
	 * @return student course hours spent
	 * @throws DataServiceException
	 *             if any exception happens while executing the query
	 */
	public List<StudentCourseHoursSpentDTO> getStudentCourseHoursSpent(Integer studentId) throws DataServiceException;

	/**
	 * Used to get the student course percentage data from db.
	 * 
	 * @return student course percentage
	 * @throws DataServiceException
	 *             if any exception happens while executing the query
	 */
	public List<StudentCoursePercentageDTO> getStudentCoursePercentage(Integer studentId) throws DataServiceException;

	/**
	 * Used to get the student courses data from db.
	 * 
	 * @return student course details
	 * @throws DataServiceException
	 *             if any exception happens while executing the query
	 */
	public List<StudentCourse> getStudentCourseDetails(String courseName) throws DataServiceException;

	/**
	 * Used to get the student course activity data from db.
	 * 
	 * @return student course activity details
	 * @throws DataServiceException
	 *             if any exception happens while executing the query
	 */
	public List<StudentCourse> getStudentCourseActivityDetails(String courseName) throws DataServiceException;

}