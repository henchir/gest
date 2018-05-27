package com.gestion.service.impl;

import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.dao.UsersDao;
import com.gestion.entity.Users;
import com.gestion.service.UsersService;

@Service("usrSrv")
@Transactional
public class UsersServiceIm implements UsersService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private UsersDao usersDao;


	@Override
	public boolean save(Users users) throws Exception {
		usersDao.saveOrUpdate(users);
		return true;
	}

	@Override
	public boolean update(Users users) throws Exception {
		usersDao.saveOrUpdate(users);
		return false;
	}

	@Override
	public void delete(Users users) throws Exception {
		usersDao.delete(users);
	}

	@Override
	public List<Users> findAll(int start, int size, String sortField, SortOrder sortOrder, Map<String, Object> filters)
			throws Exception {
		return usersDao.findAll(Users.class, start, size, sortField, sortOrder, filters);
	}

	@Override
	public int countPage() {
		return usersDao.countPage();
	}

	@Override
	public List<Users> findAll() {
		return usersDao.findAll(Users.class);
	}

	@Override
	public void persistWithBatching() throws Exception {
		usersDao.persistWithBatching(300000000);
	}
}
