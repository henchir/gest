package com.gestion.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.gestion.entity.Users;
import com.gestion.service.UsersService;

@ManagedBean
@ViewScoped
public class UserBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user = new Users();
	@ManagedProperty(value = "#{usrSrv}")
	private UsersService userService;
	private LazyDataModel<Users> users;
	private List<Users> selectedUsers;

	@PostConstruct
	public void init() {
		users = new LazyDataModel<Users>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private List<Users> list = new ArrayList<>();

			@Override
			public Object getRowKey(Users car) {
				return car.getUsername();
			}

			@Override
			public List<Users> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				try {

					this.setRowCount(userService.countPage());
					list = userService.findAll(first, pageSize, sortField, sortOrder, filters);

				} catch (Exception e) {
					e.printStackTrace();
				}
				return list;
			}
		};
	}

	public void ajouter() {
		try {
			userService.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public UsersService getUserService() {
		return userService;
	}

	public void setUserService(UsersService userService) {
		this.userService = userService;
	}

	public LazyDataModel<Users> getUsers() {
		return users;
	}

	public List<Users> getSelectedUsers() {
		return selectedUsers;
	}

	public void setSelectedUsers(List<Users> selectedUsers) {
		this.selectedUsers = selectedUsers;
	}

}
