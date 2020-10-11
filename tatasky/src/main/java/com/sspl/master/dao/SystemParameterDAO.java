package com.sspl.master.dao;

import java.util.Map;

import com.sspl.entity.SystemParameterEntity;

public interface SystemParameterDAO {

	public Object viewSystemParameter();
	public Map<String,Object> modifySystemParameter(SystemParameterEntity systemparameterentity);
	public Map<String,Object> saveSystemParameter(SystemParameterEntity systemparameterentity);
	
	
}
