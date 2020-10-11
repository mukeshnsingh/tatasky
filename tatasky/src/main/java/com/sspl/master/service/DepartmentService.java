package com.sspl.master.service;

import java.util.Map;

public interface DepartmentService {
	Map<String, Object> viewDepartment();

	Map<String, Object> editDepartment(Integer id);

	Map<String, Object> saveDepartment(Map<String, Object> map);

	Map<String, Object> modifyDepartment(Map<String, Object> map);

}
