package com.gestion.dao.impl;

import org.springframework.stereotype.Repository;

import com.gestion.dao.UsersDao;
import com.gestion.entity.Users;

@Repository
public class UsersDaoImp extends GenericDaoImp<Users> implements UsersDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void persistWithBatching(int n) throws Exception {
		int batchSize = 1000;

		for (int i = 100000001; i < n + 1; i++) {

			Users user = new Users(String.valueOf(i), String.valueOf(i), true, "ROLE_USER");
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
		String jql ="Select count(*) from Users";
		Number countResult = (Number) getEntityManager().createQuery (jql).getSingleResult();
		return countResult.intValue();
	}

}
