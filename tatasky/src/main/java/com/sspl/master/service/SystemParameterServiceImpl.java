package com.sspl.master.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sspl.entity.SystemParameterEntity;
import com.sspl.master.dao.SystemParameterDAO;
@Service
public class SystemParameterServiceImpl implements SystemParameterService {
	@Autowired
	private SystemParameterDAO systemParameterDAO;

	public void setSystemparameterdao(SystemParameterDAO systemParameterDAO) {
		this.systemParameterDAO = systemParameterDAO;
	}

	@Transactional
	public Object viewSystemParameter() {
		System.out.println("hello this is service");
		
		return systemParameterDAO.viewSystemParameter();
	}

	@Transactional
	public Map<String, Object> modifySystemParameter(SystemParameterEntity systemParameterEntity) {
		
		return systemParameterDAO.modifySystemParameter(systemParameterEntity);
	}

	@Transactional
	public Map<String, Object> saveSystemparameter(SystemParameterEntity systemParameterEntity) {
	
					
		return systemParameterDAO.saveSystemParameter(systemParameterEntity);
	}

}
