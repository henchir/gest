package com.gestion.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.dao.TestDao;
import com.gestion.entity.Test;
import com.gestion.service.TestService;

@Service("tstSrv")
@Transactional
public class TestServiceImpl implements TestService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private TestDao testDao;


	@Override
	public boolean save(Test test) throws Exception {
		testDao.saveOrUpdate(test);
		return true;
	}

	@Override
	public boolean update(Test test) throws Exception {
		testDao.saveOrUpdate(test);
		return false;
	}

	@Override
	public void delete(Test test) throws Exception {
		testDao.delete(test);
	}

	@Override
	public List<Test> findAll(int start, int size, String sortField, SortOrder sortOrder, Map<String, Object> filters)
			throws Exception {
		return testDao.findAll(Test.class, start, size, sortField, sortOrder, filters);
	}

	

	@Override
	public List<Test> findAll() {
		return testDao.findAll(Test.class);
	}

	@Override
	public void persistWithBatching() throws Exception {
		testDao.persistWithBatching(100000000);
	}

	@Override
	public int countPage() {
		return testDao.countPage();
	}
}
