package com.revature.biz.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.biz.StudentService;
import com.revature.biz.exception.BusinessServiceException;
import com.revature.data.StudentDAO;
import com.revature.data.exception.DataServiceException;
import com.revature.model.DTO.StudentActivityPointsDTO;
import com.revature.model.DTO.StudentRankDTO;

@Service
public class StudentServiceImpl implements StudentService {
	private static Logger logger = Logger.getLogger(StudentServiceImpl.class);

	@Autowired
	private StudentDAO studentDAO;

	@Override
	public List<StudentRankDTO> getStudentRanks() throws BusinessServiceException {
		List<StudentRankDTO> studentRank = null;
		try {
			studentRank = studentDAO.getStudentRanks();
			logger.info("student ranks retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentRank;
	}

	@Override
	public StudentActivityPointsDTO getStudentActivityPointsByStudentId(Integer studentId)
			throws BusinessServiceException {
		StudentActivityPointsDTO studentActivityPoints = null;
		try {
			studentActivityPoints = studentDAO.getStudentActivityPointsByStudentId(studentId);
			logger.info("student activity points retrieved successfully");
		} catch (DataServiceException e) {
			logger.error(e.getMessage(), e);
			throw new BusinessServiceException(e.getMessage(), e);
		}
		return studentActivityPoints;
	}
}
