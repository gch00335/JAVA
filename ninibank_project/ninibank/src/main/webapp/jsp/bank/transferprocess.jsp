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

    // BankDAO �ν��Ͻ� ����
    BankDAO bankDAO = new BankDAO();

    // ���� ��ü ����
    boolean success = bankDAO.transferFunds(fromAccount, toAccount, amount, password);

    if (success) {
        // ��ü ���� �� ó���� ����

        // ��ü ���� ����
       TransactionHistory history = new TransactionHistory();
		String transactionId = request.getParameter("fromAccount");
        
        history.setTransactionId(transactionId);
        history.setAccountNumber(fromAccount);
        history.setTransactionDate(new Date());
        history.setTransactionType(amount > 0 ? "���" : "�Ա�");
        history.setAmount(amount);

        // BankDAO�� ����Ͽ� ��ü ������ TRANSACTION_HISTORY ���̺� ����
        bankDAO.insertTransactionHistory(history);

        if (amount > 0) {
            // �Ա� ���� ����
            TransactionHistory depositHistory = new TransactionHistory();
            depositHistory.setTransactionId(transactionId);
            depositHistory.setAccountNumber(toAccount);
            depositHistory.setTransactionDate(new Date());
            depositHistory.setTransactionType("�Ա�");
            depositHistory.setAmount(amount);
            bankDAO.insertTransactionHistory(depositHistory);
        } else {
            // ��� ���� ����
            TransactionHistory withdrawalHistory = new TransactionHistory();
            withdrawalHistory.setTransactionId(transactionId);
            withdrawalHistory.setAccountNumber(toAccount);
            withdrawalHistory.setTransactionDate(new Date());
            withdrawalHistory.setTransactionType("���");
            withdrawalHistory.setAmount(Math.abs(amount));
            bankDAO.insertTransactionHistory(withdrawalHistory);
        }

        %>
        <script>
            alert('��ü�� ���������� �Ϸ�Ǿ����ϴ�.');
            location.href = '<%=request.getContextPath()%>/jsp/bank/account.jsp';
        </script>
        <%
    } else {
        // ��ü ���� �� ó���� ����
        %>
        <script>
            alert('��ü�� �����Ͽ����ϴ�. ���� ������ ��й�ȣ�� Ȯ�����ּ���.');
            location.href = '<%=request.getContextPath()%>/jsp/bank/transfer.jsp';
        </script>
        <%
    }
%>
</body>
</html>