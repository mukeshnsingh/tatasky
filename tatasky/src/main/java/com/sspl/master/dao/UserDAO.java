package com.sspl.master.dao;

/**
 * 
 * @author Mukesh Narayan Singh
 *
 */

import java.util.Map;

import com.sspl.entity.UsersEntity;

public interface UserDAO 
{
	
	public Map<String, Object> viewUser();

	public Map<String, Object> editUser(Integer id);
	
	public Map<String, Object> saveUser(Map<String, Object> map);
	
	public Map<String, Object> modifyUser(Map<String, Object> map);
	
}
