package com.gestion.service;

import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

import com.gestion.entity.Test1;

public interface Test1Service {

	public boolean save(Test1 test) throws Exception;

	public boolean update(Test1 test) throws Exception;

	public void delete(Test1 test) throws Exception;

	public List<Test1> findAll(int start, int size, String sortField, SortOrder sortOrder, Map<String, Object> filters)
			throws Exception;

	public int countPage();

	public List<Test1> findAll();
	
	public void persistWithBatching() throws Exception;
}
