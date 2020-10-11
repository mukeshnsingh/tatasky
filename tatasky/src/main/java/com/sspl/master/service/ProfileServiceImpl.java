package com.sspl.master.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sspl.master.dao.ProfileDAO;
@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileDAO profileDAO;

	public void setProfileDao(ProfileDAO profileDAO) {
		this.profileDAO = profileDAO;
	}

	@Transactional
	public Map<String, Object> viewProfile() {
		return profileDAO.viewProfile();
	}

	@Transactional
	public Map<String, Object> modifyProfile(Map<String, Object> map) {
		return profileDAO.modifyProfile(map);
	}

	@Transactional
	public Map<String, Object> saveProfile(Map<String, Object> map) {
		return profileDAO.saveProfile(map);
	}

	@Transactional
	public Map<String, Object> editProfile(Integer id) {
		return profileDAO.editProfile(id);
	}

}
