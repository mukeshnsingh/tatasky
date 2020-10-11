package com.sspl.master.dao;

import java.util.Map;

public interface EmployeeDAO {
	public Map<String, Object> viewEmployee();

	public Map<String, Object> editEmployee(Integer id);
	
	public Map<String, Object> saveEmployee(Map<String, Object> map);
	
	public Map<String, Object> modifyEmployee(Map<String, Object> map);
	
}
