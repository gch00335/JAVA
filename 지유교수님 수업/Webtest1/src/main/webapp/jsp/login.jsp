<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
	
<link rel="stylesheet" href="/Webtest1/css/layout.css">	


<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>

<script>
	function checkForm(){
		let f = document.loginForm;
		if(f.id.value =='')
		f.id.focus()
		return flase
	}
	if(f.password.value == ''){
		alert('패스워드를 입력하세요')
		f.password.focus()
		return false
	}
	return true
	}
</script>

</head>
<body>
<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
	<section>
		<div align="center">
		<br>
		<h2>로그인</h2>
		<br>
		<div class="card" style="width: 18rem;">
		<form method="post" action="loginprocess.jsp" 
			  name="loginForm" onsubmit="return checkForm()">
			<div class="form-group">
				<label for="id">ID</label> 
				<input type="text" class="form-control" id="id" name="id">
			</div>
			<div class="form-group">
				<label for="password">Password</label> 
				<input type="password" class="form-control" id="password" name="password">
			</div>
	
			<button type="submit" class="btn btn-primary">로그인</button>
		</form>
		</div>
		</div>
	</section>
	<footer>
		<%@ include file="/jsp/include/bottom.jsp" %>
	</footer>
</body>
</html>