package com.gestion.dao;

import com.gestion.entity.Test;

public interface TestDao extends GenericDao<Test> {

	public void persistWithBatching(int n) throws Exception;
	
	public int countPage();
}
