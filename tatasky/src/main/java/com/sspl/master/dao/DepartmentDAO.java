package com.sspl.master.dao;

import java.util.Map;

public interface DepartmentDAO {

	Map<String, Object> viewDepartment();

	Map<String, Object> editDepartment(Integer id);

	Map<String, Object> saveDepartment(Map<String, Object> map);

	Map<String, Object> modifyDepartment(Map<String, Object> map);

}
