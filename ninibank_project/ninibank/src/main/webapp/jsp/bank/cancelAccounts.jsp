<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ page import="java.io.PrintWriter"%>
<%@ page import="kr.ac.kopo.product.Product"%>
<%@ page import="kr.ac.kopo.bank.Bank"%>
<%@ page import="kr.ac.kopo.bank.BankDAO"%>

<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>

<head>
</head>
<body>



	<%
	String userID = null;
	if (session.getAttribute("ID") != null) {
		userID = (String) session.getAttribute("ID");
	} // 카카오톡 로그인 확인
	boolean isKakaoLoggedIn = false;
	String kakaoID = (String) session.getAttribute("kakaoID");
	if (kakaoID != null) {
		isKakaoLoggedIn = true;
		userID = (String) session.getAttribute("kakaoID");
	}
	// BankDAO 인스턴스 생성
	BankDAO bankDAO = new BankDAO();

	// getAccountList 메서드 호출 시 userID 전달
	ArrayList<Bank> accountList = bankDAO.getAccountList(userID);
	%>


<%


String[] accountNumbers = null;
if (request.getParameter("accountNumbers") != null) {
    accountNumbers = request.getParameter("accountNumbers").split(",");
    System.out.println(accountNumbers);
} else {
    // accountNumbers가 null인 경우에 대한 처리 코드
    accountNumbers = new String[0]; // 빈 배열로 초기화
}

System.out.println("Selected Account Numbers: " + Arrays.toString(accountNumbers)); // 디버깅 메시지 출력

//해지가 완료된 후에 실행되는 코드
if (accountNumbers.length > 0) {
    for (String accNum : accountNumbers) {
        bankDAO.deleteAccount(accNum);
    }
    // 해지가 완료되었을 때의 처리
    %>
    <script>
        alert('해지가 완료되었습니다.');
        location.href = '<%=request.getContextPath()%>/jsp/bank/account.jsp';
    </script>
    <%  
} else {
    // accountNumbers가 null이거나 빈 배열인 경우 해지에 실패한 것으로 처리
    %>
    <script>
        alert('해지에 실패했습니다.');
        location.href = '<%=request.getContextPath()%>/jsp/bank/account.jsp';
    </script>
    <%  
}
%>
</body>

</html>