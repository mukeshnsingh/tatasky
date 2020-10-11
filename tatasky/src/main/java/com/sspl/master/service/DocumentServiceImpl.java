package com.sspl.master.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sspl.master.dao.DocumentDAO;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentDAO documentDAO;
	
	public void setDocumentsDAO(DocumentDAO documentDAO) {
		this.documentDAO = documentDAO;
	}

	@Transactional
	public Map<String, Object> viewDocuments() {
		return documentDAO.viewDocuments();
	}

	@Transactional
	public Map<String, Object> editDocuments(Integer id) {
		return documentDAO.editDocuments(id);
	}

	@Transactional
	public Map<String, Object> saveDocuments(Map<String, Object> map) {
		return documentDAO.saveDocuments(map);
	}

	@Transactional
	public Map<String, Object> modifyDocuments(Map<String, Object> map) {
		return documentDAO.modifyDocuments(map);
	}

	@Transactional
	public Map<String, Object> viewSignatory() {
		return documentDAO.viewSignatory();
	}

	@Transactional
	public Map<String, Object> modifySignatory(Map<String, Object> map) {
		return documentDAO.modifySignatory(map);
	}
	@Transactional
	public Map<String, Object> editSignatory(Integer id) {
		return documentDAO.editSignatory(id);
	}

	@Transactional
	public Map<String, Object> saveSignatory(Map<String, Object> map) {
		return documentDAO.saveSignatory(map);
	}

}
