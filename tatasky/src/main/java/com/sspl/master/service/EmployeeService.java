package com.sspl.master.service;

import java.util.Map;

public interface EmployeeService {

	public Map<String, Object> viewEmployee();

	public Map<String, Object> editEmployee(Integer id);
	
	public Map<String, Object> saveEmployee(Map<String, Object> map);
	
	public Map<String, Object> modifyEmployee(Map<String, Object> map);
	

}
