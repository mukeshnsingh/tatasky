package com.sspl.master.service;

import java.util.Map;

public interface DocumentApprovalService {

	Map<String, Object> followupDocumentList();

	Map<String, Object> editFollowupDocumentList(Map<String, Object> mapData);

	Map<String, Object> approveDocument(Map<String, Object> map);
	

}
