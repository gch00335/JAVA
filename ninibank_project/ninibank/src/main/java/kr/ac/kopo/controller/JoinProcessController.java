package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.user.User;
import kr.ac.kopo.user.UserDAO;
import kr.ac.kopo.util.ConnectionFactory;

public class JoinProcessController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		 // 1. 회원가입 정보 받아오기
	    String id = request.getParameter("id");
	    String password = request.getParameter("password");
	    String name = request.getParameter("name");
	    String email = request.getParameter("email");
	    
	    // 2. 회원가입 정보 검증 및 에러 처리
	    if (id == null || password == null || name == null || email == null) {
	        // 필수 필드가 비어있는 경우 에러 처리
	        request.setAttribute("error", "회원가입 정보를 모두 입력해주세요.");
	        return "error.jsp";
	    }
	    // 아이디 중복 체크, 유효성 검사 등을 수행하고 필요한 에러 처리
	    
	    // 3. 회원 데이터 저장 및 DB 등록
	    User user = new User();
	    user.setID(id);
	    user.setPASSWORD(password);
	    user.setName(name);
	    user.setEmail(email);
	    
	    // ConnectionFactory 객체 생성
	    ConnectionFactory connectionFactory = new ConnectionFactory();
	    
	    // UserDAO 객체를 생성할 때 connectionFactory를 전달
	    UserDAO userDAO = new UserDAO(connectionFactory);
	    int result = userDAO.join(user);
	    if (result == -1) {
	        // 아이디 중복 등으로 인한 회원가입 실패
	        request.setAttribute("error", "이미 사용 중인 아이디입니다.");
	        return "error.jsp";
	    } else if (result < 0) {
	        // 회원가입 실패
	        request.setAttribute("error", "회원가입에 실패했습니다. 다시 시도해주세요.");
	        return "error.jsp";
	    }
	    
	    // 4. 회원가입 성공 시 로그인 페이지로 리다이렉트
	    return "redirect:/login"; // 로그인 페이지 경로로 리다이렉트
	}
}
