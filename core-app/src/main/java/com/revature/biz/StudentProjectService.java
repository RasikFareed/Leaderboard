package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.StudentProject;
import com.revature.model.DTO.StudentProjectPercentageDTO;
import com.revature.model.DTO.StudentProjectSkillPointsDTO;

public interface StudentProjectService {
	/**
	 * Used to get all the student projects.
	 * 
	 * @return studentProjects
	 * @throws BusinessServiceException
	 *             if any business error occurs
	 */
	List<StudentProject> getAllStudentProjects() throws BusinessServiceException;

	List<StudentProject> getAllStudentProjectSkillPoints() throws BusinessServiceException;

	List<StudentProject> getAllStudentProjectActivityPoints() throws BusinessServiceException;

	List<StudentProjectSkillPointsDTO> getStudentProjectSkillPointsByStudentId(Integer studentId) throws BusinessServiceException;

	List<StudentProject> getProjectActivityPointsByStudentId(Integer studentId) throws BusinessServiceException;

	List<StudentProjectPercentageDTO> getStudentProjectPercentageCompleted(Integer studentId) throws BusinessServiceException;

}
