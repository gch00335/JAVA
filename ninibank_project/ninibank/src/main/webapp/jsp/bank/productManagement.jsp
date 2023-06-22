<%@page import="kr.ac.kopo.product.Product"%>
<%@page import="kr.ac.kopo.bank.BankDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.List" %>
<%@ page import="kr.ac.kopo.bank.BankDAO" %>
<%
    // BankDAO 인스턴스 생성
    BankDAO bankDAO = new BankDAO();
    
    // 상품 목록 조회
    List<Product> accountProducts = bankDAO.getAllAccountProducts();
%>
<meta charset="EUC-KR">
<!DOCTYPE html>
<html>
<head>
   
    <title>상품 관리</title>
</head>
<body>
    <h1>상품 관리</h1>
    
    <table border="1">
        <tr>
            <th>상품 ID</th>
            <th>상품명</th>
            <th>이자율</th>
            <th>최소잔액</th>
        </tr>
        <% for (Product accountProduct : accountProducts) { %>
        <tr>
            <td><%= accountProduct.getProductID() %></td>
            <td><%= accountProduct.getProductName() %></td>
            <td><%= accountProduct.getInterestRate() %></td>
            <td><%= accountProduct.getMinimumBalance() %></td>
        </tr>
        <% } %>
    </table>
    
    <br>
    <a href="addProduct.jsp">상품 추가</a>
    <br>
    <a href="deleteProduct.jsp">상품 삭제</a>
</body>
</html>