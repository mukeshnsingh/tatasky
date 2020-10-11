package com.sspl.master.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sspl.master.dao.DocumentApprovalDAO;

@Service
public class DocumentApprovalServiceImpl implements DocumentApprovalService {

	@Autowired
	private DocumentApprovalDAO documentApprovalDAO;

	public void setDocumentApprovalDAO(DocumentApprovalDAO documentApprovalDAO) {
		this.documentApprovalDAO = documentApprovalDAO;
	}

	@Transactional
	public Map<String, Object> followupDocumentList() {
		return documentApprovalDAO.followupDocumentList();
	}

	@Transactional
	public Map<String, Object> editFollowupDocumentList(Map<String, Object> mapData) {
		return documentApprovalDAO.editFollowupDocumentList(mapData);
	}

	@Transactional
	public Map<String, Object> approveDocument(Map<String, Object> map) {
		return documentApprovalDAO.approveDocument(map);
	}
	
}
