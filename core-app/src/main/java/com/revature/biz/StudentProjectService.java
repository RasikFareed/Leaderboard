package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.StudentProject;
import com.revature.model.DTO.StudentProjectActivityDetailsDTO;
import com.revature.model.DTO.StudentProjectPercentageDTO;
import com.revature.model.DTO.StudentProjectSkillPointsDTO;
import com.revature.model.DTO.StudentprojectDetailsDTO;

public interface StudentProjectService {
	/**
	 * Used to get all the student projects.
	 * 
	 * @return studentProjects
	 * @throws BusinessServiceException
	 *             if any business error occurs
	 */
	

	List<StudentProjectSkillPointsDTO> getStudentProjectSkillPoints(Integer studentId) throws BusinessServiceException;

	List<StudentProjectPercentageDTO> getStudentProjectPercentageCompleted(Integer studentId) throws BusinessServiceException;

	List<StudentprojectDetailsDTO> getStudentProjectDetails(String projectName) throws BusinessServiceException;

	List<StudentProjectActivityDetailsDTO> getStudentProjectActivityDetails(String projectName) throws BusinessServiceException;

}
