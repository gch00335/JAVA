package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		 response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
		return "/jsp/login/loginForm.jsp";
	}
	

}
