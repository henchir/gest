package com.gestion.dao.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.gestion.dao.TestDao;
import com.gestion.entity.Test;

@Repository
public class TestDaoImp extends GenericDaoImp<Test> implements TestDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void persistWithBatching(int n) throws Exception {
		int batchSize = 1000;

		for (int i = 1000001; i < n + 1; i++) {

			Test user = new Test(BigDecimal.valueOf(i));
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
		String jql ="Select count(*) from Test";
		Number countResult = (Number) getEntityManager().createQuery (jql).getSingleResult();
		return countResult.intValue();
	}
}
