package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.user.UserDAO;
import kr.ac.kopo.util.ConnectionFactory;


public class KakaoLoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		 // 세션에 값을 저장
			String kakaoID = request.getParameter("kakaoID");
	        // UserDAO 객체를 사용하여 데이터베이스에 저장
			ConnectionFactory connectionFactory = new ConnectionFactory();  // ConnectionFactory 객체 생성

			  
		    // UserDAO 객체를 생성할 때 connectionFactory를 전달
		    UserDAO userDAO = new UserDAO(connectionFactory);
		    System.out.println(kakaoID + "이거냐");
	        userDAO.saveKakaoID(kakaoID);
		    HttpSession session = request.getSession();
		    session.setAttribute("kakaoID", kakaoID);
		    
		 return "/jsp/login/kakaologinjsp.jsp";
	}
	

}