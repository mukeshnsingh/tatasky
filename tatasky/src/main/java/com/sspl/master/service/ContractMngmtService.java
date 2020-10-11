package com.sspl.master.service;

import java.util.Map;

public interface ContractMngmtService {

	Map<String, Object> viewContractType();

	Map<String, Object> editContractType(Integer id);

	Map<String, Object> saveContractType(Map<String, Object> map);

	Map<String, Object> modifyContractType(Map<String, Object> map);

	Map<String, Object> viewContractReview();

	Map<String, Object> editContractReview(Integer id);

	Map<String, Object> saveContractReview(Map<String, Object> map);

	Map<String, Object> modifyContractReview(Map<String, Object> map);

}
