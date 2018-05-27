package com.gestion.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

import com.gestion.entity.Users;

public interface UsersService extends Serializable {

	public boolean save(Users users) throws Exception;

	public boolean update(Users users) throws Exception;

	public void delete(Users users) throws Exception;

	public List<Users> findAll(int start, int size, String sortField, SortOrder sortOrder, Map<String, Object> filters)
			throws Exception;

	public int countPage();

	public List<Users> findAll();
	
	public void persistWithBatching() throws Exception;
}
