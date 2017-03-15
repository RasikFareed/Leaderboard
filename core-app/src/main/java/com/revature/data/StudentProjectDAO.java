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

		public List<StudentProjectSkillPointsDTO> getStudentProjectSkillPoints(Integer studentId) throws DataServiceException;

	public List<StudentProjectPercentageDTO> getStudentProjectPercentageCompleted(Integer studentId) throws DataServiceException;

	public List<StudentProject> getStudentProjectDetails(String projectName) throws DataServiceException;

	public List<StudentProject> getStudentProjectActivityDetails(String projectName) throws DataServiceException;
}
