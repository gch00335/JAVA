<%@page import="kr.ac.kopo.member.MemberVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	/*
		작업순서
		1. 파라미터 추출(아이디, 패스워드)
		2. 추출된 파라미터를 가진 회원 검색
		3. 검색결과에 따른 화면 구성
	*/
	
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String pass = "hr";
	
	StringBuilder sql = new StringBuilder();
	sql.append("select * ");
	sql.append("  from t_member ");
	sql.append(" where id = ? and password = ? ");
	
	try(
		Connection conn = DriverManager.getConnection(url, user, pass);
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	) {
		
		pstmt.setString(1, id);
		pstmt.setString(2, password);
		
		ResultSet rs = pstmt.executeQuery();
		
		String msg = "";
		String locUrl = "";
		if(rs.next()) {
			
			MemberVO loginUser = new MemberVO();
			loginUser.setId(rs.getString("id"));
			loginUser.setPassword(rs.getString("password"));
			loginUser.setName(rs.getString("name"));
			loginUser.setType(rs.getString("type"));
			
			msg = loginUser.getName() + "님 환영합니다";
			locUrl = "/webtest2";
			
			session.setAttribute("loginUser", loginUser);
			
		} else {
			msg = "입력하신 ID 또는 패스워드가 잘못되었습니다";
			locUrl = "login.jsp";
		}
		
		pageContext.setAttribute("msg", msg);
		pageContext.setAttribute("url", locUrl);
		
		
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	
%>    

<script>
	alert('${ msg }')
	location.href = '${ url }'
</script>







