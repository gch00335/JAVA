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
    <title>��ǰ �߰�</title>
</head>
<body>
    <h1>��ǰ �߰�</h1>
    
    <form action="addProductaction.jsp" method="post">
    	<label for="productID">��ǰ ��ȣ:</label>
		<input type="number" id="productID" name="productID" required><br>
        <label for="productName">��ǰ��:</label>
        <input type="text" id="productName" name="productName" required><br>
        <label for="interestRate">������:</label>
        <input type="number" id="interestRate" name="interestRate" step="0.01" required><br>
        <label for="minimumBalance">�ּ��ܾ�:</label>
        <input type="number" id="minimumBalance" name="minimumBalance" required><br>
        <input type="submit" value="�߰�">
    </form>
</body>
</html>