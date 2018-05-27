package com.gestion.dao.impl;

import org.springframework.stereotype.Repository;

import com.gestion.dao.Test1Dao;
import com.gestion.entity.Test1;

@Repository
public class Test1DaoImp extends GenericDaoImp<Test1> implements Test1Dao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void persistWithBatching(int n) throws Exception {
		int batchSize = 1000;

		for (int i = 1; i < n + 1; i++) {

			Test1 user = new Test1(i);
			super.saveOrUpdate(user);

			// Flush a batch of inserts and release memory
			if (i % batchSize == 0 && i > 0) {
				getEntityManager().flush();
				getEntityManager().clear();

			}
		}
	}
	
	@Override
	public int countPage() {
		String jql ="Select count(*) from Test1";
		Number countResult = (Number) getEntityManager().createQuery (jql).getSingleResult();
		return countResult.intValue();
	}
}
