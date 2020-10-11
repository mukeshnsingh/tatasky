package com.sspl.master.service;

import java.util.Map;

public interface LoginService {

	Map<String, Object> validate(Map<String, Object> mapData);

	Map<String, Object> home(Map<String, Object> mapData);

}
