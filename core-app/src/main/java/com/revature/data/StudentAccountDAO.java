package com.revature.data;

import java.util.List;

import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentAccount;
import com.revature.model.DTO.StudentAccountDTO;

public interface StudentAccountDAO {

	/**
	 * Used to get the student data from db.
	 * 
	 * @return student details
	 * @throws DataServiceException
	 *             if any exception happens while executing the query
	 */

	public StudentAccountDTO getId(String emailId, String password) throws DataServiceException;
	/**
	 * Used to get the student activity data from db.
	 * 
	 * @return student activity points
	 * @throws DataServiceException
	 *             if any exception happens while executing the query
	 */
	

	public List<StudentAccount> getActivityPointsByStudentId(Integer studentId) throws DataServiceException;

}
