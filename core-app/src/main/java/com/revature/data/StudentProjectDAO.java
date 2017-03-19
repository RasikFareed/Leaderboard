package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.DTO.StudentProjectActivityDetailsDTO;
import com.revature.model.DTO.StudentProjectPercentageDTO;
import com.revature.model.DTO.StudentProjectSkillPointsDTO;
import com.revature.model.DTO.StudentprojectDetailsDTO;

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

	public List<StudentprojectDetailsDTO> getStudentProjectDetails(String projectName) throws DataServiceException;

	public List<StudentProjectActivityDetailsDTO> getStudentProjectActivityDetails(String projectName) throws DataServiceException;
}
