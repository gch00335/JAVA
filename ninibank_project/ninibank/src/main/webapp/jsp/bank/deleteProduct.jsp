<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="EUC-KR">
    <title>��ǰ ����</title>
</head>
<body>
    <h1>��ǰ ����</h1>
    
    <form action="deleteProductProcess.jsp" method="post">
        <label for="productID">��ǰ ID:</label>
        <input type="number" id="productID" name="productID" required><br>
        <input type="submit" value="����">
    </form>
</body>
</html>