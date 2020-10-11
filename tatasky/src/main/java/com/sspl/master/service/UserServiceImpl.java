package com.sspl.master.service;

/**
 * 
 * @author Mukesh Narayan Singh
 *
 */

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sspl.master.dao.UserDAO;


@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Transactional
	public Map<String, Object> viewUser() {
		return userDAO.viewUser();
	}


	@Transactional
	public Map<String, Object> editUser(Integer id) {
		return userDAO.editUser(id);
	}

	@Transactional
	public Map<String, Object> saveUser(Map<String, Object> map) {
		return userDAO.saveUser(map);
	}

	@Transactional
	public Map<String, Object> modifyUser(Map<String, Object> map) {
		return userDAO.modifyUser(map);
	}


}
