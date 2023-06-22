<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
    <%@ page import="java.io.PrintWriter"%>
<%@ page import="kr.ac.kopo.bank.Bank"%>
<%@ page import="kr.ac.kopo.bank.BankDAO"%>
<%@ page import="kr.ac.kopo.product.ProductDAO"%>
<%@ page import="kr.ac.kopo.product.Product"%>
<!DOCTYPE html>

<html>
<head>
  <meta charset="EUC-KR">
    <title>상품 추가</title>
</head>
<body>
    <h1>상품 추가</h1>
    
    <form action="addProductaction.jsp" method="post">
    	<label for="productID">상품 번호:</label>
		<input type="number" id="productID" name="productID" required><br>
        <label for="productName">상품명:</label>
        <input type="text" id="productName" name="productName" required><br>
        <label for="interestRate">이자율:</label>
        <input type="number" id="interestRate" name="interestRate" step="0.01" required><br>
        <label for="minimumBalance">최소잔액:</label>
        <input type="number" id="minimumBalance" name="minimumBalance" required><br>
        <input type="submit" value="추가">
    </form>
</body>
</html>