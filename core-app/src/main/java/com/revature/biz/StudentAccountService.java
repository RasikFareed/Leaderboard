package com.revature.biz;

import java.util.List;

import com.revature.biz.exception.BusinessServiceException;
import com.revature.model.StudentAccount;
import com.revature.model.DTO.StudentAccountDTO;

public interface StudentAccountService {

	/**
	 * Used to do login activities.
	 * 
	 * @throws BusinessServiceException
	 *             if any business error occurs
	 */
	//public StudentAccountDTO Login(String emailId, String password) throws BusinessServiceException;

	public List<StudentAccount> getActivityPointsByStudentId(Integer studentId) throws BusinessServiceException;

	public String insertUserPassword(String password, String emailId) throws BusinessServiceException;

	public StudentAccountDTO getUserByLogin(String emailId, String password) throws BusinessServiceException;

	public StudentAccountDTO Login(String emailId, String password) throws BusinessServiceException;

}
