<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="EUC-KR">
    <title>상품 삭제</title>
</head>
<body>
    <h1>상품 삭제</h1>
    
    <form action="deleteProductProcess.jsp" method="post">
        <label for="productID">상품 ID:</label>
        <input type="number" id="productID" name="productID" required><br>
        <input type="submit" value="삭제">
    </form>
</body>
</html>