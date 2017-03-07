package com.revature.data.access;

import java.util.List;

import com.revature.data.access.exception.DataAccessException;
import com.revature.model.DTO.StudentRankDTO;

public interface DataRetriver {
  /**
   * Used to get the data by sql query.
   * 
   * @param query query to execute
   * @return the requested data
   * @throws DataAccessException if query format error
   */
  public <E> List<E> retrieveBySQL(String query) throws DataAccessException;
  public <E> List<E> retrieveBySQLJSON(String query) throws DataAccessException;
  public <E> Object retrieveBySQLAsObject(String query,Class<?> cls) throws DataAccessException;
  public  <E> List<E> retrieveBySQLWithResultTransformer(String queryString, Class<?> cls) throws DataAccessException;






}
