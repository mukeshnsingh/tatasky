package com.sspl.master.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sspl.master.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Transactional
	public Map<String, Object> viewEmployee() {
		return employeeDAO.viewEmployee();
	}


	@Transactional
	public Map<String, Object> editEmployee(Integer id) {
		return employeeDAO.editEmployee(id);
	}

	@Transactional
	public Map<String, Object> saveEmployee(Map<String, Object> map) {
		return employeeDAO.saveEmployee(map);
	}

	@Transactional
	public Map<String, Object> modifyEmployee(Map<String, Object> map) {
		return employeeDAO.modifyEmployee(map);
	}


}
