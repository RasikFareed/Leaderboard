package com.revature.data.access;
import com.revature.data.access.exception.DataAccessException;

public interface DataModifier {
	
	public int modifyBySQL(String query) throws DataAccessException;

}