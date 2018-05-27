package com.gestion.dao;

import com.gestion.entity.Users;

public interface UsersDao extends GenericDao<Users> {

	public void persistWithBatching(int n) throws Exception;
	
	public int countPage();
}
