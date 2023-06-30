<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.UUID"%>
<%@page import="kr.ac.kopo.transactionHistory.TransactionHistory"%>
<%@page import="java.util.List"%>
    <%@ page import="java.io.PrintWriter"%>
    <%@ page import="kr.ac.kopo.product.Product"%>
<%@ page import="kr.ac.kopo.bank.Bank"%>
<%@ page import="kr.ac.kopo.bank.BankDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<title>NINI_BANK</title>
</head>
<script>
if(${result}){
alert('이체가 성공적으로 완료되었습니다.');
    location.href = '<%=request.getContextPath()%>/jsp/bank/account.jsp';
} else {
	
alert('이체에 실패하였습니다. 계좌 정보나 비밀번호를 확인해주세요.');
    location.href = '<%=request.getContextPath()%>/jsp/bank/transfer.jsp';
}
</script>
</body>
</html>