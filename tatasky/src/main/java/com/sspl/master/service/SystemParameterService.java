package com.sspl.master.service;

import java.util.Map;

import com.sspl.entity.SystemParameterEntity;

public interface SystemParameterService {
	
	
	public Object viewSystemParameter();
	public Map<String,Object> modifySystemParameter(SystemParameterEntity systemParameterEntity); 
public Map<String,Object> saveSystemparameter(SystemParameterEntity systemParameterEntity);
}
