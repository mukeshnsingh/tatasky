package com.sspl.master.dao;

import java.util.Map;

public interface DocumentDAO {
	Map<String, Object> viewDocuments();

	Map<String, Object> editDocuments(Integer id);

	Map<String, Object> saveDocuments(Map<String, Object> map);

	Map<String, Object> modifyDocuments(Map<String, Object> map);
	
	Map<String, Object> viewSignatory();

	Map<String, Object> editSignatory(Integer id);

	Map<String, Object> saveSignatory(Map<String, Object> map);

	Map<String, Object> modifySignatory(Map<String, Object> map);

}
