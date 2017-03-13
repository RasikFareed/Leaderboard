package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.DTO.StudentActivityPointsDTO;
import com.revature.model.DTO.StudentLoginHoursDTO;
import com.revature.model.DTO.StudentRankDTO;

public interface StudentDAO {
	/**
	 * Used to get the student rank data from db.
	 * 
	 * @return student ranks
	 * @throws DataServiceException
	 *             if any exception happens while executing the query
	 */

	public List<StudentRankDTO> getStudentRanks() throws DataServiceException;

	public StudentActivityPointsDTO getStudentActivityPointsByStudentId(Integer studentId) throws DataServiceException;

	public List<StudentLoginHoursDTO> getStudentLoginHours(Integer studentId) throws DataServiceException;
}
