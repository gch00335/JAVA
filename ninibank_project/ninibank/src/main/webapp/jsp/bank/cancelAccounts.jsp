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
	} // īī���� �α��� Ȯ��
	boolean isKakaoLoggedIn = false;
	String kakaoID = (String) session.getAttribute("kakaoID");
	if (kakaoID != null) {
		isKakaoLoggedIn = true;
		userID = (String) session.getAttribute("kakaoID");
	}
	// BankDAO �ν��Ͻ� ����
	BankDAO bankDAO = new BankDAO();

	// getAccountList �޼��� ȣ�� �� userID ����
	ArrayList<Bank> accountList = bankDAO.getAccountList(userID);
	%>


<%


String[] accountNumbers = null;
if (request.getParameter("accountNumbers") != null) {
    accountNumbers = request.getParameter("accountNumbers").split(",");
    System.out.println(accountNumbers);
} else {
    // accountNumbers�� null�� ��쿡 ���� ó�� �ڵ�
    accountNumbers = new String[0]; // �� �迭�� �ʱ�ȭ
}

System.out.println("Selected Account Numbers: " + Arrays.toString(accountNumbers)); // ����� �޽��� ���

//������ �Ϸ�� �Ŀ� ����Ǵ� �ڵ�
if (accountNumbers.length > 0) {
    for (String accNum : accountNumbers) {
        bankDAO.deleteAccount(accNum);
    }
    // ������ �Ϸ�Ǿ��� ���� ó��
    %>
    <script>
        alert('������ �Ϸ�Ǿ����ϴ�.');
        location.href = '<%=request.getContextPath()%>/jsp/bank/account.jsp';
    </script>
    <%  
} else {
    // accountNumbers�� null�̰ų� �� �迭�� ��� ������ ������ ������ ó��
    %>
    <script>
        alert('������ �����߽��ϴ�.');
        location.href = '<%=request.getContextPath()%>/jsp/bank/account.jsp';
    </script>
    <%  
}
%>
</body>

</html>