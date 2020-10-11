package com.sspl.master.dao;

import java.util.Map;

public interface DocumentApprovalDAO {

	Map<String, Object> followupDocumentList();

	Map<String, Object> editFollowupDocumentList(Map<String, Object> mapData);

	Map<String, Object> approveDocument(Map<String, Object> map);
	

}
