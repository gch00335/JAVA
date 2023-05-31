<%@page import="kr.ac.kopo.member.MemberVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	/*
		�۾�����
		1. �Ķ���� ����(���̵�, �н�����)
		2. ����� �Ķ���͸� ���� ȸ�� �˻�
		3. �˻������ ���� ȭ�� ����
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
	
	// ctr/ + �����̽��� ������ ����Ʈ ��!
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
			
			msg = loginUser.getName() + "�� ȯ���մϴ�";
			locUrl = "/Webtest1";
			
			session.setAttribute("loginUser", loginUser);
			
		} else {
			msg = "�Է��Ͻ� ID �Ǵ� �н����尡 �߸��Ǿ����ϴ�";
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





	