package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentProject;
import com.revature.model.DTO.StudentProjectPercentageDTO;
import com.revature.model.DTO.StudentProjectSkillPointsDTO;

public interface StudentProjectDAO {
	/**
	 * Used to get the student projects data from db.
	 * 
	 * @return studentProjects
	 * @throws DataServiceException
	 *             if any exception happens while executing the query
	 */

	public List<StudentProject> getAllStudentProjects() throws DataServiceException;

	public List<StudentProject> getAllStudentProjectSkillPoints() throws DataServiceException;

	public List<StudentProject> getAllStudentProjectActivityPoints() throws DataServiceException;

	public List<StudentProject> getStudentProjectActivityPointsById(Integer studentId) throws DataServiceException;

	public List<StudentProjectSkillPointsDTO> getStudentProjectSkillPointsByStudentId(Integer studentId) throws DataServiceException;

	public List<StudentProjectPercentageDTO> getStudentProjectPercentageCompleted(Integer studentId) throws DataServiceException;
}
