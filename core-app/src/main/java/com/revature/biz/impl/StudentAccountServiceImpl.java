package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.StudentAccountService;
import com.revature.biz.exception.BusinessServiceException;

import com.revature.data.StudentAccountDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.StudentAccount;
import com.revature.model.DTO.StudentAccountDTO;



@Service

public class StudentAccountServiceImpl implements StudentAccountService {
	private static Logger logger = Logger.getLogger(CategoryServiceImpl.class);

	@Autowired
	private StudentAccountDAO studentAccountDAO;

	@Override
	public StudentAccountDTO Login(String emailId, String password) throws BusinessServiceException {
		StudentAccountDTO studentAccount = null;
		try {
			studentAccount=studentAccountDAO.getId(emailId, password);
			logger.info("Login retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentAccount;

	}
//	@Override
//	public StudentAccountDTO getUserByLogin(String emailId, String password) throws BusinessServiceException {
//		StudentAccountDTO studentAccountDTOObj = new StudentAccountDTO();
//		try {
//
//			studentAccountDTOObj = studentAccountDAO.getUserByLogin(emailId, password);
//			logger.info("User retrived successfully");
//		} catch (DataServiceException e) {
//			logger.error(e.getMessage(), e);
//			throw new BusinessServiceException(e.getMessage(), e);
//		}
//		return studentAccountDTOObj;
//	}
//
//	@Override
//	public String insertUserPassword(String password, String emailId) throws BusinessServiceException {
//		String msg = null;
//		try {
//
//			msg = studentAccountDAO.insertUserPassword(password,emailId);
//			logger.info("User password inserted successfully");
//		} catch (DataServiceException e) {
//			logger.error(e.getMessage(), e);
//			throw new BusinessServiceException(e.getMessage(), e);
//		}
//		return msg;
//	}

	@Override
	public List<StudentAccount> getActivityPointsByStudentId(Integer studentId) throws BusinessServiceException {
		List<StudentAccount> studentAccount = null;
		try {
			studentAccount = studentAccountDAO.getActivityPointsByStudentId(studentId);
			logger.info("student activity points data retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentAccount;

	}

}

