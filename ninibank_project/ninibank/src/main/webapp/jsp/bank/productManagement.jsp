<%@page import="kr.ac.kopo.product.Product"%>
<%@page import="kr.ac.kopo.bank.BankDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.List" %>
<%@ page import="kr.ac.kopo.bank.BankDAO" %>
<%
    // BankDAO �ν��Ͻ� ����
    BankDAO bankDAO = new BankDAO();
    
    // ��ǰ ��� ��ȸ
    List<Product> accountProducts = bankDAO.getAllAccountProducts();
%>
<meta charset="EUC-KR">
<!DOCTYPE html>
<html>
<head>
   
    <title>��ǰ ����</title>
</head>
<body>
    <h1>��ǰ ����</h1>
    
    <table border="1">
        <tr>
            <th>��ǰ ID</th>
            <th>��ǰ��</th>
            <th>������</th>
            <th>�ּ��ܾ�</th>
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
    <a href="addProduct.jsp">��ǰ �߰�</a>
    <br>
    <a href="deleteProduct.jsp">��ǰ ����</a>
</body>
</html>