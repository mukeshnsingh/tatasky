package com.sspl.master.dao;

import java.util.Map;

public interface ProfileWorkflowDAO {

	Map<String, Object> viewProfileWorkflow();

	Map<String, Object> saveProfileWorkflow(Map<String, Object> map);

}
