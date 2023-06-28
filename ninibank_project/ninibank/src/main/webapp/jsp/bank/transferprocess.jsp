<%@page import="java.util.Date"%>
<%@page import="java.util.UUID"%>
<%@page import="kr.ac.kopo.transactionHistory.TransactionHistory"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@ page import="java.io.PrintWriter"%>
    <%@ page import="kr.ac.kopo.product.Product"%>
<%@ page import="kr.ac.kopo.bank.Bank"%>
<%@ page import="kr.ac.kopo.bank.BankDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>NINI_BANK</title>
</head>

<%
    String fromAccount = request.getParameter("fromAccount");
    String toAccount = request.getParameter("toAccount");
    double amount = Double.parseDouble(request.getParameter("amount"));
    String password = request.getParameter("password");

    // BankDAO 인스턴스 생성
    BankDAO bankDAO = new BankDAO();

    // 계좌 이체 수행
    boolean success = bankDAO.transferFunds(fromAccount, toAccount, amount, password);

    if (success) {
        // 이체 성공 시 처리할 내용

        // 이체 내역 저장
       TransactionHistory history = new TransactionHistory();
		String transactionId = request.getParameter("fromAccount");
        
        history.setTransactionId(transactionId);
        history.setAccountNumber(fromAccount);
        history.setTransactionDate(new Date());
        history.setTransactionType(amount > 0 ? "출금" : "입금");
        history.setAmount(amount);

        // BankDAO를 사용하여 이체 내역을 TRANSACTION_HISTORY 테이블에 저장
        bankDAO.insertTransactionHistory(history);

        if (amount > 0) {
            // 입금 내역 생성
            TransactionHistory depositHistory = new TransactionHistory();
            depositHistory.setTransactionId(transactionId);
            depositHistory.setAccountNumber(toAccount);
            depositHistory.setTransactionDate(new Date());
            depositHistory.setTransactionType("입금");
            depositHistory.setAmount(amount);
            bankDAO.insertTransactionHistory(depositHistory);
        } else {
            // 출금 내역 생성
            TransactionHistory withdrawalHistory = new TransactionHistory();
            withdrawalHistory.setTransactionId(transactionId);
            withdrawalHistory.setAccountNumber(toAccount);
            withdrawalHistory.setTransactionDate(new Date());
            withdrawalHistory.setTransactionType("출금");
            withdrawalHistory.setAmount(Math.abs(amount));
            bankDAO.insertTransactionHistory(withdrawalHistory);
        }

        %>
        <script>
            alert('이체가 성공적으로 완료되었습니다.');
            location.href = '<%=request.getContextPath()%>/jsp/bank/account.jsp';
        </script>
        <%
    } else {
        // 이체 실패 시 처리할 내용
        %>
        <script>
            alert('이체에 실패하였습니다. 계좌 정보나 비밀번호를 확인해주세요.');
            location.href = '<%=request.getContextPath()%>/jsp/bank/transfer.jsp';
        </script>
        <%
    }
%>
</body>
</html>