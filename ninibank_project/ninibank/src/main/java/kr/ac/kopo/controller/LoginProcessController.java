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
        
        // 아이디가 "nini"인 경우 관리자 모드로 인식하여 managerindex.jsp로 이동
        if ("nini".equals(userID)) {
            return "manegerindex.jsp";
        }
        
        // 일반 사용자의 경우 index.jsp로 이동
        return "index.jsp";
    }
}
