package com.sspl.master.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sspl.master.dao.ContractMngmtDAO;

@Service
public class ContractMngmtServiceImpl implements ContractMngmtService {

	@Autowired
	private ContractMngmtDAO contractMngmtDAO;
	
	public void setContractMngmtDAO(ContractMngmtDAO contractMngmtDAO) {
		this.contractMngmtDAO = contractMngmtDAO;
	}

	@Transactional
	public Map<String, Object> viewContractType() {
		return contractMngmtDAO.viewContractType();
	}

	@Transactional
	public Map<String, Object> editContractType(Integer id) {
		return contractMngmtDAO.editContractType(id);
	}

	@Transactional
	public Map<String, Object> saveContractType(Map<String, Object> map) {
		return contractMngmtDAO.saveContractType(map);
	}

	@Transactional
	public Map<String, Object> modifyContractType(Map<String, Object> map) {
		return contractMngmtDAO.modifyContractType(map);
	}

	@Transactional
	public Map<String, Object> viewContractReview() {
		return contractMngmtDAO.viewContractReview();
	}

	@Transactional
	public Map<String, Object> modifyContractReview(Map<String, Object> map) {
		return contractMngmtDAO.modifyContractReview(map);
	}
	@Transactional
	public Map<String, Object> editContractReview(Integer id) {
		return contractMngmtDAO.editContractReview(id);
	}

	@Transactional
	public Map<String, Object> saveContractReview(Map<String, Object> map) {
		return contractMngmtDAO.saveContractReview(map);
	}

}
