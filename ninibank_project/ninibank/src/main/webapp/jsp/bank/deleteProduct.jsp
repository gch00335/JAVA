<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="EUC-KR">
    <title>惑前 昏力</title>
</head>
<body>
    <h1>惑前 昏力</h1>
    
    <form action="deleteProductProcess.jsp" method="post">
        <label for="productID">惑前 ID:</label>
        <input type="number" id="productID" name="productID" required><br>
        <input type="submit" value="昏力">
    </form>
</body>
</html>