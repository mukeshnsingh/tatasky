package com.sspl.master.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sspl.master.dao.ProfileWorkflowDAO;

@Service
public class ProfileWorkflowServiceImpl implements ProfileWorkflowService {

	@Autowired
	ProfileWorkflowDAO profileWorkflowDAO;

	public void setProfileWorkflowDAO(ProfileWorkflowDAO profileWorkflowDAO) {
		this.profileWorkflowDAO = profileWorkflowDAO;
	}

	@Transactional
	public Map<String, Object> viewProfileWorkflow() {
		return profileWorkflowDAO.viewProfileWorkflow();
	}

	@Transactional
	public Map<String, Object> saveProfileWorkflow(Map<String, Object> map) {
		return profileWorkflowDAO.saveProfileWorkflow(map);
	}
	
}
