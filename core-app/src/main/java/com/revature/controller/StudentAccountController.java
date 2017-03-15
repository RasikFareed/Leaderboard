package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.revature.biz.StudentAccountService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.controller.exception.InternalException;
import com.revature.controller.exception.InvalidInputException;
import com.revature.model.StudentAccount;
import com.revature.model.DTO.StudentAccountDTO;



@RestController
// @RequestMapping("/")

public class StudentAccountController {

	private static Logger logger = Logger.getLogger(StudentAccountController.class);

	@Autowired
	private StudentAccountService studentAccountService;

	// @RequestMapping("/login")
	@PostMapping(value = "login")
	public @ResponseBody StudentAccountDTO getActiveStudentAccountController(@RequestParam("emailId") String emailId,
			@RequestParam("password") String password) {
		StudentAccountDTO studentAccount = null;

		try {
			logger.info("Getting the login data...");
			studentAccount = studentAccountService.Login(emailId, password);

			logger.info("login data retrieval success1." + studentAccount);
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentAccount;
	}
	@PostMapping("/login1")
	public StudentAccountDTO loginController(@RequestParam("emailId") String emailId,@RequestParam("password") String password) {
		StudentAccountDTO studentAccountDTO = new StudentAccountDTO();
		
		try {
			logger.info("Getting the Users data...");
			studentAccountDTO = studentAccountService.getUserByLogin(emailId,password);
			logger.info("Users data retrieval success.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentAccountDTO;
	}
	
	@PostMapping("emailId/{emailId}/password/{password}")
	public String passwordInsertController(@PathVariable("password") String password,@PathVariable("emailId") String emailId) {
		String studentAccount = null;
		
		try {
			logger.info("encrypting...");
			studentAccount = studentAccountService.insertUserPassword(password,emailId);
			logger.info("Password inserted.");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentAccount;
}

	@RequestMapping(value = "/activity/points/{studentId}")
	public @ResponseBody List<StudentAccount> getActivityPointsByStudentId(
			@PathVariable("studentId") Integer studentId) {
		List<StudentAccount> studentAccount = null;

		try {
			logger.info("Getting the activity points data...");
			studentAccount = studentAccountService.getActivityPointsByStudentId(studentId);
			logger.info("activity points data retrieval successfully.");
		} catch (BusinessServiceException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidInputException(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new InternalException("System has some issue...", e);
		}
		return studentAccount;
	}

}