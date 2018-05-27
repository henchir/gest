package com.gestion.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

public interface GenericDao<T> extends Serializable{

	public void saveOrUpdate(T entity) throws Exception;

	public void delete(T entity) throws Exception;

	public List<T> findAll(Class<T> cls, int start, int size, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) throws Exception;

	public List<T> findAll(Class<T> cls);
		
}
