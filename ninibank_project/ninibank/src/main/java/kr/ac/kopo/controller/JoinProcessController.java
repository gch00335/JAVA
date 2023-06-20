package kr.ac.kopo.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.user.User;
import kr.ac.kopo.user.UserDAO;
import kr.ac.kopo.util.ConnectionFactory;

public class JoinProcessController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	    

		try {
			request.setCharacterEncoding("euc-kr");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// 1. 회원가입 정보 받아오기
	    String id = request.getParameter("ID");
	    String password = request.getParameter("PASSWORD");
	    String name = request.getParameter("name");
	    String email = request.getParameter("email");
	    String birth = request.getParameter("Birth"); // 추가: 생년월일 정보 받아오기
	    String phone = request.getParameter("phone"); // 추가: 전화번호 정보 받아오기
	    String post = request.getParameter("post"); // 추가: 우편번호 정보 받아오기
	    String addr = request.getParameter("addr"); // 추가: 주소 정보 받아오기
	    String detailAddress = request.getParameter("DETAILADDRESS");

	    // 2. 회원가입 정보 검증 및 에러 처리
	    if (id == null || password == null || name == null || email == null || birth == null || phone == null || post == null || addr == null || detailAddress == null) {
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
	    user.setBirth(birth); // 추가: 생년월일 설정
	    user.setPhone(phone); // 추가: 전화번호 설정
	    user.setPost(post); // 추가: 우편번호 설정
	    user.setAddr(addr); // 추가: 주소 설정
	    user.setAddr(detailAddress); 

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
	        return "error2.jsp";
	    }

	    // 4. 회원가입 성공 시 로그인 페이지로 리다이렉트
	    return "/jsp/login/loginForm.jsp";
	}
	
}



