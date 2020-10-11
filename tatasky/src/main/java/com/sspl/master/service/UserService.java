package com.sspl.master.service;

/**
 * 
 * @author Mukesh Narayan Singh
 *
 */

import java.util.Map;

import com.sspl.entity.UsersEntity;

public interface UserService 
{
	public Map<String, Object> viewUser();
	
	public Map<String, Object> editUser(Integer id);
	
	public Map<String, Object> saveUser(Map<String, Object> map);
	
	public Map<String, Object> modifyUser(Map<String, Object> map);

}
