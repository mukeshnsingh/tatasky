package com.sspl.master.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sspl.master.dao.LoginDAO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginDAO;

	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	@Transactional
	public Map<String, Object> validate(Map<String, Object> mapData) {
		return loginDAO.validate(mapData);
	}

	@Transactional
	public Map<String, Object> home(Map<String, Object> mapData) {
		return loginDAO.home(mapData);
	}
}
