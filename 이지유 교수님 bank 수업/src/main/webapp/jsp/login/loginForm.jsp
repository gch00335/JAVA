<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="${ pageContext.request.contextPath }/loginprocess.do">
	  ���̵� : <input type="text" name="id"><br>
	  �н����� : <input type="password" name="password"><br>
	  <input type="submit" value="�α���">
	 
	</form>
</body>
</html>