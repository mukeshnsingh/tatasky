package com.sspl.master.dao;

import java.util.Map;

public interface LoginDAO {

	Map<String, Object> validate(Map<String, Object> mapData);

	Map<String, Object> home(Map<String, Object> mapData);

}
