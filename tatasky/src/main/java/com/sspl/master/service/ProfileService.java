package com.sspl.master.service;

import java.util.Map;

public interface ProfileService {

	Map<String, Object> viewProfile();

	Map<String, Object> modifyProfile(Map<String, Object> map);

	Map<String, Object> saveProfile(Map<String, Object> map);

	Map<String, Object> editProfile(Integer id);

}
