package com.gestion.service;

import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

import com.gestion.entity.Test;

public interface TestService {

	public boolean save(Test test) throws Exception;

	public boolean update(Test test) throws Exception;

	public void delete(Test test) throws Exception;

	public List<Test> findAll(int start, int size, String sortField, SortOrder sortOrder, Map<String, Object> filters)
			throws Exception;

	public int countPage();

	public List<Test> findAll();
	
	public void persistWithBatching() throws Exception;
}
