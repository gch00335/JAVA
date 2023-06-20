package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginProcessController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		  // 사용자 ID를 세션에 저장
        String userID = request.getParameter("ID");
        HttpSession session = request.getSession();
        session.setAttribute("ID", userID);
        
        // 로그인이 완료되었으므로 다음 페이지로 이동
        return "index.jsp";
    }
}