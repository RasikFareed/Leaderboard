package com.revature.data.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.StudentProjectDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.DTO.StudentProjectActivityDetailsDTO;
import com.revature.model.DTO.StudentProjectPercentageDTO;
import com.revature.model.DTO.StudentProjectSkillPointsDTO;
import com.revature.model.DTO.StudentprojectDetailsDTO;

@Repository
public class StudentProjectDAOImpl implements StudentProjectDAO {
	private static Logger logger = Logger.getLogger(CategoryDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<StudentProjectSkillPointsDTO> getStudentProjectSkillPoints(Integer studentId) throws DataServiceException {
		List<StudentProjectSkillPointsDTO> studentProjectSkillPoints = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT`projects`.`NAME` projectName,`student_projects`.`STUDENT_ID` stuId,SUM(`project_sprint_activities`.`SKILL_POINTS`) skillPts FROM (`projects`LEFT JOIN (`student_projects`LEFT JOIN (`student_project_sprints`LEFT JOIN (`student_project_sprint_activities` JOIN `project_sprint_activities` ON ((`project_sprint_activities`.`ID` = `student_project_sprint_activities`.`PROJECT_SPRINT_ACTIVITY_ID`))) ON ((`student_project_sprints`.`ID` = `student_project_sprint_activities`.`STUDENT_PROJECTS_SPRINT_ID`)))ON ((`student_projects`.`ID` = `student_project_sprints`.`STUDENT_PROJECT_ID`))) ON ((`projects`.`ID` = `student_projects`.`PROJECT_ID`)))WHERE (`student_project_sprint_activities`.`STATUS_ID` = 2)GROUP BY `student_projects`.`STUDENT_ID`,`projects`.`NAME` having student_id=" + studentId);
			studentProjectSkillPoints = dataRetriver.retrieveBySQLWithResultTransformer(sb.toString(), StudentProjectSkillPointsDTO.class);
			logger.info("Student Projects Activity Points data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectSkillPoints;
	}
	@Override
	public List<StudentProjectPercentageDTO> getStudentProjectPercentageCompleted(Integer studentId) throws DataServiceException {
		List<StudentProjectPercentageDTO> studentProjectPercentage = null;
		try {
			StringBuilder sb = new StringBuilder("SELECT STUDENT_ID stuId, NAME projectName, ROUND((q.COMPLETED_ACTIVITIES/(SELECT COUNT(*) AS TOTAL_ACTIVITIES FROM  project_sprints s, project_sprint_activities a WHERE q.id = s.`PROJECT_ID` AND s.`ID` = a.`PROJECT_SPRINT_ID` ))*100) perComp FROM(SELECT sp.STUDENT_ID ,p.NAME , p.ID, COUNT(*) AS COMPLETED_ACTIVITIES FROM student_project_sprint_activities spsa, student_project_sprints sps, student_projects sp , projects p WHERE sps.`ID` = spsa.STUDENT_PROJECTS_SPRINT_ID AND sps.`STUDENT_PROJECT_ID` = sp.id AND sp.`PROJECT_ID` = p.`ID` AND spsa.status_id = 2 GROUP BY p.NAME, p.ID , sp.STUDENT_ID ) q having student_id=" + studentId);
			studentProjectPercentage = dataRetriver.retrieveBySQLWithResultTransformer(sb.toString(), StudentProjectPercentageDTO.class);
			logger.info("Student Projects percentage data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectPercentage;
	}
	@Override
	public List<StudentprojectDetailsDTO> getStudentProjectDetails(String projectName) throws DataServiceException {
		List<StudentprojectDetailsDTO> studentProjectDetails = null;
		try {
			StringBuilder sb = new StringBuilder("SELECT projects.`NAME` projectName,projects.`DESCRIPTION` description,projects.`ENROLLMENT_POINTS` enrPts,projects.`COMPLETION_POINTS`compPts,COUNT(project_sprint_activities.`NAME`) activityCnt FROM projects JOIN project_sprints  ON project_sprints.`PROJECT_ID`=projects.`ID` JOIN project_sprint_activities  ON project_sprint_activities.`PROJECT_SPRINT_ID`=project_sprints.`ID` GROUP BY projects.`NAME` having projects.name='" + projectName+"'");
			studentProjectDetails = dataRetriver.retrieveBySQLWithResultTransformer(sb.toString(), StudentprojectDetailsDTO.class);
			logger.info("Student Projects percentage data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectDetails;
	}
	@Override
	public List<StudentProjectActivityDetailsDTO> getStudentProjectActivityDetails(String projectName) throws DataServiceException {
		List<StudentProjectActivityDetailsDTO> studentProjectActivityDetails = null;
		try {
			StringBuilder sb = new StringBuilder("SELECT projects.`NAME` projectName,project_sprint_activities.`NAME` activityName FROM projects JOIN project_sprints ON project_sprints.`PROJECT_ID`=projects.`ID` JOIN project_sprint_activities ON project_sprint_activities.`PROJECT_SPRINT_ID`=project_sprints.`ID` where projects.name='" + projectName+"'");
			studentProjectActivityDetails = dataRetriver.retrieveBySQLWithResultTransformer(sb.toString(), StudentProjectActivityDetailsDTO.class);
			logger.info("Student Projects percentage data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentProjectActivityDetails;
	}
}
