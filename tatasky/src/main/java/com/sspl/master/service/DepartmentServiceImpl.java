package com.sspl.master.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sspl.master.dao.DepartmentDAO;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	@Transactional
	public Map<String, Object> viewDepartment() {
		return departmentDAO.viewDepartment();
	}

	@Transactional
	public Map<String, Object> editDepartment(Integer id) {
		return departmentDAO.editDepartment(id);
	}

	@Transactional
	public Map<String, Object> saveDepartment(Map<String, Object> map) {
		return departmentDAO.saveDepartment(map);
	}

	@Transactional
	public Map<String, Object> modifyDepartment(Map<String, Object> map) {
		return departmentDAO.modifyDepartment(map);
	}

}
