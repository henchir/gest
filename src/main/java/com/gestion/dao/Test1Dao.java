package com.gestion.dao;

import com.gestion.entity.Test1;

public interface Test1Dao extends GenericDao<Test1> {

	public void persistWithBatching(int n) throws Exception;
	
	public int countPage();
}
