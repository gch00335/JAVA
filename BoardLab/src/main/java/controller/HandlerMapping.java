package controller;

import java.util.HashMap;
import java.util.Map;

import controller.user.InsertUserController;
import controller.user.LoginController;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/insertUser.do", new InsertUserController());
		mappings.put("/login.do", new LoginController());
	
	}
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
