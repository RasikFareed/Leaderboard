package com.revature.data.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.revature.data.StudentDAO;
import com.revature.data.access.DataRetriver;
import com.revature.data.access.exception.DataAccessException;
import com.revature.data.exception.DataServiceException;
import com.revature.data.utils.DataUtils;
import com.revature.model.DTO.StudentActivityPointsDTO;
import com.revature.model.DTO.StudentLoginHoursDTO;
import com.revature.model.DTO.StudentProjectSkillPointsDTO;
import com.revature.model.DTO.StudentRankDTO;

@Repository
public class StudentDAOImpl implements StudentDAO {
	private static Logger logger = Logger.getLogger(StudentDAOImpl.class);
	@Autowired
	private DataRetriver dataRetriver;

	public DataRetriver getDataRetriver() {
		return dataRetriver;
	}

	public void setDataRetriver(DataRetriver dataRetriver) {
		this.dataRetriver = dataRetriver;
	}

	@Override
	public List<StudentRankDTO> getStudentRanks() throws DataServiceException {
		List<StudentRankDTO> studentRank = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT student_id stuId,NAME name,COLLEGE_NAME college,DEPARTMENT department,"
							+ "ACTIVITY_POINTS actPts,SKILL_POINTS skillPts,TOTAL tot FROM vw_student_rank");
			studentRank = dataRetriver.retrieveBySQLWithResultTransformer(sb.toString(), StudentRankDTO.class);
			logger.info("Student rank data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentRank;
	}

	@Override
	public StudentActivityPointsDTO getStudentActivityPointsByStudentId(Integer studentId) throws DataServiceException {
		StudentActivityPointsDTO studentActivityPoints = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT IFNULL(ca.enrollment_points,0) courseErlPts, IFNULL(ca.completion_points,0) courseCompPts,IFNULL(pa.enrollment_points,0) projErlPts,IFNULL(pa.completion_points,0) projCompPts,IFNULL(la.`login_points`,0) loginPts FROM (SELECT student_id,COUNT(DISTINCT(DATE(activity_timestamp)))*(SELECT points FROM point_settings WHERE login_activity_id=1) login_points FROM student_audit_details WHERE login_activity_id=1 GROUP BY student_id ) la LEFT JOIN (SELECT students.`ID`,SUM(courses.`ENROLLMENT_POINTS`) AS enrollment_points,SUM(IF(IFNULL(`COMPLETED_ON`,FALSE),courses.`COMPLETION_POINTS`,0)) AS completion_points  FROM students JOIN student_courses ON students.`ID`=`student_courses`.`STUDENT_ID` JOIN courses ON courses.`ID`=student_courses.`COURSE_ID` GROUP BY students.`ID`) ca ON la.`student_id`=ca.id LEFT JOIN (SELECT students.`ID`,SUM(projects.`ENROLLMENT_POINTS`) AS ENROLLMENT_POINTS,SUM(IF(IFNULL(`COMPLETED_ON`,FALSE),projects.`COMPLETION_POINTS`,0)) AS  COMPLETION_POINTS FROM students JOIN student_projects ON students.`ID`=student_projects.`STUDENT_ID`JOIN projects ON student_projects.`PROJECT_ID`=projects.`ID`GROUP BY students.`ID`)pa ON pa.`ID`=la.`student_id` WHERE la.student_id="+studentId);
			studentActivityPoints = (StudentActivityPointsDTO) dataRetriver.retrieveBySQLAsObject(sb.toString(),
					StudentActivityPointsDTO.class);
			logger.info("Student activity points data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentActivityPoints;
	}

	@Override
	public List<StudentLoginHoursDTO> getStudentLoginHours(Integer studentId) throws DataServiceException {
		List<StudentLoginHoursDTO> studentLoginHoursDetails = null;
		try {
			StringBuilder sb = new StringBuilder(
					"SELECT IF(IFNULL(b.logoutdate,FALSE),DAYNAME(b.logoutdate),0) AS DAY_NAME,DATE(b.logoutdate),b.student_id AS STUDENT_ID,HOUR(b.total_duration)+MINUTE(b.total_duration)/60+SECOND(b.total_duration)/3600 AS HOURS_DISTRIBUTION FROM(SELECT student_id,DATE(logouttime) AS logoutdate,SEC_TO_TIME((HOUR(SUM(TIMEDIFF(a.logouttime,a.logintime)))*60*60 + MINUTE(SUM(TIMEDIFF(a.logouttime,a.logintime)))*60+SECOND(SUM(TIMEDIFF(a.logouttime,a.logintime))))) AS total_duration FROM(SELECT i.id,i.student_id,i.activity_timestamp AS logintime,(SELECT o.activity_timestamp FROM student_audit_details o WHERE i.student_id = o.student_id AND CONVERT(i.activity_timestamp,DATE) = CONVERT(o.activity_timestamp,DATE)AND o.activity_timestamp> i.activity_timestamp AND o.login_activity_id = 2 AND o.activity_timestamp = (SELECT MIN(o2.activity_timestamp)FROM student_audit_details  o2 WHERE o2.activity_timestamp > i.activity_timestamp)) AS logouttime FROM student_audit_details i WHERE i.login_activity_id = 1) a GROUP BY DATE(logintime),DATE(logouttime), student_id)b WHERE (logoutdate)BETWEEN DATE_SUB(NOW(),INTERVAL DAYOFWEEK(NOW())-1 DAY) AND NOW() AND b.student_id="+ studentId);
			studentLoginHoursDetails = dataRetriver.retrieveBySQLWithResultTransformer(sb.toString(),
					StudentLoginHoursDTO.class);
			logger.info("Student Projects Activity Points data retrieval success..");
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw new DataServiceException(DataUtils.getPropertyMessage("data_retrieval_fail"), e);
		}
		return studentLoginHoursDetails;
	}

}
