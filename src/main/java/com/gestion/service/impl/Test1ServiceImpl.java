package com.gestion.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.dao.Test1Dao;
import com.gestion.entity.Test1;
import com.gestion.service.Test1Service;

@Service("tst1Srv")
@Transactional
public class Test1ServiceImpl implements Test1Service, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private Test1Dao testDao;


	@Override
	public boolean save(Test1 test) throws Exception {
		testDao.saveOrUpdate(test);
		return true;
	}

	@Override
	public boolean update(Test1 test) throws Exception {
		testDao.saveOrUpdate(test);
		return false;
	}

	@Override
	public void delete(Test1 test) throws Exception {
		testDao.delete(test);
	}

	@Override
	public List<Test1> findAll(int start, int size, String sortField, SortOrder sortOrder, Map<String, Object> filters)
			throws Exception {
		return testDao.findAll(Test1.class, start, size, sortField, sortOrder, filters);
	}

	

	@Override
	public List<Test1> findAll() {
		return testDao.findAll(Test1.class);
	}

	@Override
	public void persistWithBatching() throws Exception {
		testDao.persistWithBatching(10000);
	}

	@Override
	public int countPage() {
		return testDao.countPage();
	}
}
