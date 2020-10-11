package com.sspl.master.dao;

import java.util.Map;

public interface ProfileDAO {

	Map<String, Object> viewProfile();

	Map<String, Object> modifyProfile(Map<String, Object> map);

	Map<String, Object> saveProfile(Map<String, Object> map);

	Map<String, Object> editProfile(Integer id);
}
