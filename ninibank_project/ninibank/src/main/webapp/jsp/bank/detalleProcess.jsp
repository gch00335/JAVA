<%@page import="kr.ac.kopo.transactionHistory.TransactionHistory"%>
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
  <meta charset="EUC-KR">
  <title>NINI_BBS</title>
 
</head>

<body>
<%
String selectedAccount = request.getParameter("selectedAccount");

// BankDAO 인스턴스 생성
BankDAO bankDAO = new BankDAO();

//선택한 계좌의 거래 내역 조회
List<TransactionHistory> transactionHistoryList = bankDAO.getTransactionHistory(selectedAccount);
%>

<%@ include file="/jsp/bank/detalle.jsp" %>
</body>

</html>