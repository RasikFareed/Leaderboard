package com.revature.data.access.impl;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.data.access.DataModifier;
import com.revature.data.access.exception.DataAccessException;

@Repository
public class DataModifierImpl implements DataModifier {

	private static Logger logger = Logger.getLogger(DataRetriverImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int modifyBySQL(String query) throws DataAccessException {
		int rows = 0;
		try {
			rows = sessionFactory.getCurrentSession().createSQLQuery(query).executeUpdate();
			logger.info("data modifier success..");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new DataAccessException(e.getMessage(), e);
		}
		return rows;
	}

}
