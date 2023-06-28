<%@page import="java.util.Date"%>
<%@page import="java.util.UUID"%>
<%@page import="kr.ac.kopo.transactionHistory.TransactionHistory"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="kr.ac.kopo.product.Product"%>
<%@ page import="kr.ac.kopo.bank.Bank"%>
<%@ page import="kr.ac.kopo.bank.BankDAO"%>

<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<style>
/* Reset some default styles for consistency */
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}
/* Define @font-face rule */
@font-face {
	font-family: 'WooridaumB';
	src: url('https://example.com/path-to/WooridaumB.woff2') format('woff2');
	/* ��Ʈ ������ ���� URL�� ���� */
	font-weight: 700;
	font-style: normal;
}
/* Styling for the top container */
.top-container {
	background-color: #008040;
	display: flex;
	justify-content: space-between; /* ����: ���ʰ� ������ ������ ������ �ִ�ȭ */
	align-items: center;
	height: 25vh;
	font-weight: bold;
	font-family: 'WooridaumB', sans-serif;
}

.left-side {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	text-align: center;
	width: 50%;
	height: 100%;
	background-color: #ffffff; /* �Ͼ� ��� �߰� */
	border-radius: 5px;
	padding: 20px;
}

.left-side h1 {
	font-size: 60px; /* ū �۾�ü�� ���� */
	font-weight: bold; /* ���� �۾�ü�� ���� */
	color: #008040; /* ��Ʈ������ ���� */
	font-family: 'WooridaumB', sans-serif;
}

.left-side h3 {
	font-size: 34px; /* ���� �۾�ü�� ���� */
	color: #000;
	margin-bottom: 10px;
	font-family: 'WooridaumB', sans-serif;
}

.right-side {
	display: flex;
	flex-direction: column;
	justify-content: flex-start; /* ����: �� ���� ���ĵǵ��� ���� */
	align-items: center;
	width: 50%;
	height: 100%;
	background-color: #008040; /* ��Ʈ�� ��� �߰� */
	border-radius: 5px;
	margin-left: 20px;
}

.right-side .button {
	margin-left: 10px; /* ����: ��ư ������ ���� */
}

.button-group {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.button-group a {
	color: black; /* ���������� ���� */
	text-decoration: none; /* ��ũ ȿ�� ���� */
	display: flex;
	align-items: center;
	justify-content: center;
}
/* Additional styles */

/* 1. ����� ��Ʈ���� �˻�â ��Ÿ�� */
.top-container {
	background-color: #008040;
	display: flex;
	justify-content: space-between; /* ����: ���ʰ� ������ ������ ������ �ִ�ȭ */
	align-items: center;
	height: 25vh;
	font-weight: bold;
	font-family: 'WooridaumB', sans-serif;
}

.right-side {
	display: flex;
	flex-direction: column;
	align-items: flex-end; /* ����: �� �����ʿ� ��ġ�ϵ��� ���� */
	margin-left: 20px;
	background-color: #008040; /* ��Ʈ�� ��� �߰� */
	font-weight: bold;
	font-family: 'WooridaumB', sans-serif;
}

/* 2. ���� �Ͼ��� ������ ���� */
.left-side {
	text-align: center;
	background-color: #ffffff; /* �Ͼ� ��� �߰� */
	padding: 20px;
	border-radius: 5px;
}

.left-side h1 {
	font-size: 60px; /* ū �۾�ü�� ���� */
	font-weight: bold; /* ���� �۾�ü�� ���� */
	color: #008040; /* ��Ʈ������ ���� */
	font-family: 'WooridaumB', sans-serif;
	margin-left: -250px; /* �������� 20px �̵� */
}

.left-side h3 {
	font-size: 34px; /* ���� �۾�ü�� ���� */
	color: #000;
	margin-bottom: 5px;
	font-family: 'WooridaumB', sans-serif;
}

.left-side h4 {
	font-size: 16px; /* ���� �۾�ü�� ���� */
	margin-bottom: 5px;
	font-family: 'WooridaumB', sans-serif;
}

.main-page {
	color: #FF8000; /* ����ȭ���� ��Ȳ�� */
}

.sub-page {
	color: #888888; /* �����ȳ��� ȸ�� */
}

.button {
	width: 100px;
	height: 40px;
	margin-top: 10px;
	background-color: #ffffff;
	border: none;
	border-radius: 5px;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
	margin-right: 10px;
	font-family: 'WooridaumB', sans-serif;
}

}
.button:hover {
	background-color: #ececec;
}

/* ��Ÿ�� �ڵ� �߰� */
.help-image {
	position: fixed; /* ���� ��ġ */
	bottom: 60px; /* Footer �ٷ� ���� ��ġ */
	right: 20px; /* ������ ���� */
	font-family: 'WooridaumB', sans-serif;
}

.help-menu {
	display: none; /* �ʱ⿡�� ���� */
	position: absolute;
	bottom: 100%; /* ���� ������ ���� ��ġ */
	left: 50%;
	transform: translateX(-50%);
	background-color: #fff;
	padding: 10px;
	width: 200px; /* �޴� ĭ �ʺ� ���� */
	font-family: 'WooridaumB', sans-serif;
}

.help-menu p {
	margin: 5px 0; /* ���� ���� */
	cursor: pointer; /* Ŀ�� �����ͷ� ���� */
}

.help-menu p:hover {
	background-color: #eee; /* ���콺�� �÷��� �� ��� ���� ���� */
}

.help-image:hover+.help-menu {
	display: block; /* ���콺 Ŀ���� �÷��� �� �޴� ǥ�� */
}

/* ��Ÿ�� �ڵ� �߰� */
#footer {
	background-color: #f1f1f1;
	text-align: center;
	font-size: 14px;
	/* ���� ��Ÿ�� �Ӽ� */
	position: fixed;
	bottom: 0;
	left: 0;
	width: 100%;
	font-family: 'WooridaumB', sans-serif;
}

#footer ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

#footer li {
	display: inline-block;
	margin-right: 40px;
}

#footer a {
	color: #333;
	text-decoration: none;
}

#footer a:hover {
	text-decoration: underline;
}

#footer p {
	margin-bottom: 10px;
}

.customer-service {
	width: 240px;
	height: 168px;
	border: 1px solid #000; /* ���� �׵θ� �߰� */
	position: absolute; /* ��ġ�� ���������� ���� */
	top: 350px; /* ���ϴ� ��ġ�� ���� */
	left: 100px; /* ���ϴ� ��ġ�� ���� */
	text-align: center; /* �ؽ�Ʈ�� ���������� ���� */
}

.customer-service p {
	margin-right: 10px; /* ���������� 10px�� ���� ���� */
}

/* �߰� ��Ÿ�� �ڵ� */
.logo {
	position: absolute;
	top: 20px;
	left: 20px;
	width: 300px; /* �̹��� �ʺ� ���� (������ ������ ����) */
	height: 50; /* �̹��� ���� �ڵ� ���� */
}

/* �߰� ��Ÿ�� �ڵ� */
.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-menu {
	display: none;
	position: absolute;
	top: 100%; /* Change '0%' to '100%' */
	left: 0; /* Change 'right' to 'left' */
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown:hover .dropdown-menu {
	display: block;
}

.top-container {
	position: relative; /* ����� ��ġ ���� */
}

.table {
	margin-top: 40px; /* ���� ���� 25px ���ؼ� ���� */
}

.row {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.btn-write {
	margin-left: auto;
}


.col-auto {
	position: absolute;
	top: 350px;
	left: 450px;
	margin-top: 10px; /* �ʿ��� ��� ���� ���� */
}

.container {
	position: absolute;
	top: 360px;
	left: 450px;
	margin-top: 10px; /* �ʿ��� ��� ���� ���� */
}

@import
	url('https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap')
	;

.body {
	font-family: 'Nanum Gothic', sans-serif;
	
}

.h4, .mb-3, .btn-primary, .mb-33 {
	font-family: 'Nanum Gothic', sans-serif;
}

.container {
	position: relative;
	width: 800px;
	height: 100px;
	margin: 0 auto;
	padding: 20px;
}

.input-form-background {
	padding: 20px;
	background-color: #ffffff;
	border-radius: 5px;
}

.h4 {
	text-align: center;
	margin-bottom: 10px;
	color: #333333;
}

.mb-3 {
	margin-bottom: 20px;
	font-weight: bold;
}

.mb-33 {
	position: relative;
	margin-bottom: 100px;
	font-size: 40px;
	font-weight: bold;
}

.form-control {
	width: 100%; /* ����: ���� ���̸� 100%�� ���� */
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 3px;
	box-sizing: border-box; /* ����: ���� ũ�⸦ �ڽ� �𵨿� ���� */
	margin-top: 20px; /* �߰�: �Է�â ������ ������ ���� */
	margin-bottom: 10px; /* �߰�: �Է�â ������ ������ ���� */
}

.invalid-feedback {
	color: #dc3545;
}

.btn-primary {
	background-color: #007bff;
	color: #fff;
	border: none;
	padding: 10px 20px;
	font-size: 16px;
	font-weight: bold;
	border-radius: 3px;
	cursor: pointer;
	font-family: Arial, sans-serif; /* ��Ʈ ���� */
}

.btn-primary:hover {
	background-color: #0056b3;
}

.custom-control-input:checked ~ .custom-control-label::before {
	background-color: #c0e1f5;
	border-color: #c0e1f5;
}

.custom-control-label::before {
	border-radius: 3px;
}

.custom-checkbox .custom-control-input:checked ~ .custom-control-label::after
	{
	border-color: #fff;
}

.custom-checkbox .custom-control-input:checked ~ .custom-control-label::before
	{
	background-color: #c0e1f5;
}

.custom-control-label::after, .custom-control-label::before {
	position: absolute;
	top: 0;
	left: -1.25rem;
	display: block;
	width: 1rem;
	height: 1rem;
	pointer-events: none;
	content: "";
}

.custom-control-label::before {
	border: 1px solid #adb5bd;
}

.custom-control-label::after {
	background-repeat: no-repeat;
	background-position: center center;
	background-size: 50% 50%;
	background-image: none;
}

.custom-control-label::before, .custom-control-label::after {
	background-color: #fff;
	transition: background-color 0.2s ease-in-out, border-color 0.2s
		ease-in-out, box-shadow 0.2s ease-in-out;
}

.generate-button {
	background-color: #007bff;
	color: #fff;
	border: none;
	padding: 5px 10px;
	font-size: 15px;
	border-radius: 3px;
	cursor: pointer;
	font-family: Arial, sans-serif;
	/* Add any additional custom styles here */
}

.generate-button:hover {
	background-color: #0056b3;
}
   .container2 {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 150vh;
  
    }
    
  
</style>

<meta charset="EUC-KR">
<title>��ǰ ����</title>
</head>
<body>
	<%
	String userID = null;
	if (session.getAttribute("ID") != null) {
		userID = (String) session.getAttribute("ID");
	} // īī���� �α��� Ȯ��
	boolean isKakaoLoggedIn = false;
	String kakaoID = (String) session.getAttribute("kakaoID");
	if (kakaoID != null) {
		isKakaoLoggedIn = true;
		userID = (String) session.getAttribute("kakaoID");
	}
	
	%>

	
	
	<ul class="nav navbar-nav navbar-right">


		<%
		if (userID == null && isKakaoLoggedIn == false) {
		%>
		<div class="top-container">
			<div class="left-side">
				<a href="/bank/index.jsp"> <img src="�ϴ���Ϸΰ�.png" alt="�ΰ�"
					class="logo">
				</a>

				<h3>Q&A �Խ���</h3>
				<br>
				<div class="button-group">
					<h4>
						<span class="main-page"> ���θ޴� </span>
					</h4>
					<h4>
						<span class="sub-page"> > Q&A �Խ���</span>
					</h4>

				</div>
			</div>
			<div class="right-side">
				<div class="button-group">
					<button class="button">Q&A�Խ���</button>
					<div class="dropdown">
						<button class="button">�����ϱ�</button>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/login.do"
								class="button">�α���</a></li>
							<li><a href="${pageContext.request.contextPath}/join.do"
								class="button">ȸ�� ����</a></li>
						</ul>
						</li>
					</div>
				</div>
			</div>
			<%
			} else if (isKakaoLoggedIn) {
			%>
			<div class="top-container">
				<div class="left-side">
					<a href="/bank/index.jsp"> <img src="�ϴ���Ϸΰ�.png" alt="�ΰ�"
						class="logo">
					</a>

					<h3>���°���</h3>
					<br>
					<div class="button-group">
						<h4>
							<span class="main-page"> MY�޴� </span>
						</h4>
						<h4>
							<span class="sub-page"> > ���°��� </span>
						</h4>

					</div>
				</div>
				<div class="right-side">
					<div class="button-group">
						<button class="button">MYPAGE</button>
						<a href="${pageContext.request.contextPath}/bbs.do" class="button">Q&A�Խ���
							</button> <a href="${pageContext.request.contextPath}/logout.do"
							class="button">�α׾ƿ�</a>
							</button>
							<div class="dropdown">
								<button class="button">MY����</button>
								<ul class="dropdown-menu">
									<li><a
										href="${pageContext.request.contextPath}/account.do">���°���</a></li>
									<li><a href="logoutAction.jsp">���¹�ŷ����</a></li>
									<li><a href="mypage.jsp">�ŷ�������ȸ</a></li>
									<li><a href="logoutAction.jsp">������ü</a></li>
								</ul>
								</li>
							</div>
					</div>
				</div>
				<%
				} else {
				%>
				<div class="top-container">
					<div class="left-side">
						<a href="/bank/index.jsp"> <img src="�ϴ���Ϸΰ�.png" alt="�ΰ�"
							class="logo">
						</a>

						<h3>���°���</h3>
						<br>
						<div class="button-group">
							<h4>
								<span class="main-page"> MY�޴� </span>
							</h4>
							<h4>
								<span class="sub-page"> > ���°��� </span>
							</h4>

						</div>
					</div>
					<div class="right-side">
						<div class="button-group">
							<a href="${pageContext.request.contextPath}/bbs.do"
								class="button">Q&A�Խ���
								</button>
								<button class="button">MYPAGE</button> <a
								href="${pageContext.request.contextPath}/logout.do"
								class="button">�α׾ƿ�</a>
								</button>
								<div class="dropdown">
									<button class="button">MY����</button>
									<ul class="dropdown-menu">
										<li><a
											href="${pageContext.request.contextPath}/account.do">���°���</a></li>
										<li><a href="logoutAction.jsp">���¹�ŷ����</a></li>
										<li><a href="mypage.jsp">�ŷ�������ȸ</a></li>
										<li><a href="logoutAction.jsp">������ü</a></li>
									</ul>
									</li>
								</div>
						</div>
					</div>
					<%
					}
					%>
				
	</ul>




	<div class="container2">
		<div class="row">
			<div class="col-md-6 mx-auto">
				<div class="input-form-background">
					<h4 class="mb-33">���»���</h4>
					<form class="validation-form" method="post"
						action="${pageContext.request.contextPath}/madeac.do">

						<div class="mb-3">

							<label for="idname">���»�ǰ</label>

							<form action="createAccountProcess.jsp" method="post">

								<label for="productID">����:</label> <select id="productID"
									name="productID" class="form-control">
									<%-- ��ǰ ����� ��ȸ�Ͽ� �ɼ����� ǥ�� --%>
									<%
									// DB ���� ����
									String url = "jdbc:oracle:thin:@localhost:1521:xe";
									String username = "hr";
									String password = "hr";

									// DB ����
									Connection conn = null;
									PreparedStatement pstmt = null;
									ResultSet rs = null;
									try {
										// JDBC ����̹� �ε�
										Class.forName("oracle.jdbc.driver.OracleDriver");

										// DB ����
										conn = DriverManager.getConnection(url, username, password);

										// SQL ���� ����
										String sql = "SELECT * FROM account_products";
										pstmt = conn.prepareStatement(sql);
										rs = pstmt.executeQuery();

										// ��ǰ ����� �ɼ����� ǥ��
										while (rs.next()) {
											int productID = rs.getInt("productID");
											String productName = rs.getString("productName");
											out.println("<option value='" + productName + "'>" + productName + "</option>");
										}
									} catch (Exception e) {
										e.printStackTrace();
									} finally {
										// ���ҽ� ����
										if (rs != null) {
											try {
										rs.close();
											} catch (SQLException e) {
										e.printStackTrace();
											}
										}
										if (pstmt != null) {
											try {
										pstmt.close();
											} catch (SQLException e) {
										e.printStackTrace();
											}
										}
										if (conn != null) {
											try {
										conn.close();
											} catch (SQLException e) {
										e.printStackTrace();
											}
										}
									}
									%>
								</select><br> <br> <br>
								<div class="mb-3">
									<label for="name">�Ա� �ݾ�</label> <input type="number"
										class="form-control" id="balance" name="balance"
										placeholder="�Ա� �ݾ�" required>
									<div class="invalid-feedback">ù ���� ���� �� 10000�� �̻���� �Ա�
										�����մϴ�.</div>
									<div class="valid-feedback"></div>
								</div>
						</div>
						<div class="mb-3">
							<label for="idname">���¹�ȣ</label> <input type="text"
								class="form-control" id="acc_num" name="acc_num"
								placeholder="���¹�ȣ�� �����ϼ���" value="" required> <a
								class="invalid-feedback">���¹�ȣ�� �������ּ���.</a>
							<button type="button" onclick="generateAccountNumber()"
								class="btn btn-primary generate-button">���¹�ȣ ����</button>
						</div>

						<div class="row">
							<div class="col-md-6 mb-3">
								<label for="pw">����� ���̵�</label> <input type="text"
									class="form-control" id="id" name="id" value="<%=userID%>"
									readonly>
								<div class="invalid-feedback"></div>
							</div>
						</div>

						<div class="col-md-6 mb-3">

							<label for="pw">�����ڵ�</label> <input type="text"
								class="form-control" id="bankcode" name="bankcode"
								placeholder="333" value="333" readonly>


							<div class="mb-3">
								<label for="name">���� ��й�ȣ</label> <input type="text"
									class="form-control" id="acpw" name="acpw" placeholder="���� 4�ڸ�"
									pattern="[0-9]{4}" maxlength="4" required
									oninput="this.value = this.value.slice(0, 4); if (this.value.length < 4) this.setCustomValidity('��й�ȣ�� �Է��ϼ���.'); else this.setCustomValidity('');">
								<div class="invalid-feedback">���� ��й�ȣ 4�ڸ��� �Է����ּ���.</div>
							</div>




							<div class="mb-3">
								<label for="name">���°�����</label> <input type="date"
									class="form-control" id="acmadedate" name="acmadedate"
									value="<%=java.time.LocalDate.now()%>" required readonly>
							</div>
							<hr class="mb-4">
							<div class="custom-control custom-checkbox">
								<input type="checkbox" class="custom-control-input"
									id="agreement" required> <label
									class="custom-control-label" for="agreement">�������� ���� ��
									�̿뿡 �����մϴ�.</label>
							</div>
							<br> <br>
							<div class="mb-4"></div>
							<button class="btn btn-primary btn-lg" type="submit"
								style="display: block; margin: 0 auto; width: 100%; font-size: 20px;">����
								����</button>
					</form>
					<br> <br> <br> <br> <br> <br> <br>
					<br> <br> <br>
				</div>
			</div>
		</div>
	</div>
</body>


<script>
document.getElementById('balance').addEventListener('input', function() {
    var balanceInput = document.getElementById('balance');
    var balanceValue = parseInt(balanceInput.value);
    var invalidFeedback = balanceInput.nextElementSibling;
    var validFeedback = invalidFeedback.nextElementSibling;
    
    if (balanceValue >= 10000) {
        balanceInput.classList.remove('is-invalid');
        balanceInput.classList.add('is-valid');
        invalidFeedback.style.display = 'none';
        validFeedback.style.display = 'block';
    } else {
        balanceInput.classList.remove('is-valid');
        balanceInput.classList.add('is-invalid');
        invalidFeedback.style.display = 'block';
        validFeedback.style.display = 'none';
    }
});

function generateAccountNumber() {
	  var accountNumber = "";
	    var digits = "0123456789";

	    for (var i = 0; i < 13; i++) {
	        accountNumber += digits.charAt(Math.floor(Math.random() * digits.length));
	    }

	    var bankcode = "333";
	    var accountNumberWithCode = bankcode + accountNumber;

	    document.getElementById("acc_num").value = accountNumberWithCode;
	}

function getbankcodeNumber() {
    var bankcode = "333";
    document.getElementById("bankcode").value = bankcode;
}

function showCompletionMessage() {
    alert("���� ������ �Ϸ�Ǿ����ϴ�!");
}

document.querySelector('.validation-form').addEventListener('submit', function(event) {
    var balanceInput = document.getElementById('balance');
    var balanceValue = parseInt(balanceInput.value);
    var passwordInput = document.getElementById('acpw');
    var passwordValue = passwordInput.value;
    
    if (balanceValue < 10000) {
        event.preventDefault(); // �� ���� ����
        alert('�Ա� �ݾ��� 10,000�� �̻� �Է����ּ���.');
        balanceInput.focus();
    } else if (passwordValue.length !== 4 || isNaN(passwordValue)) {
        event.preventDefault(); // �� ���� ����
        alert('���� 4�ڸ� ��й�ȣ�� �Է����ּ���.');
        passwordInput.focus();
    } else {
        showCompletionMessage();
    }
});
</script>

  



<div class="help-image">
	<img src="����.png" alt="���� ������" width="140" height="98">
	<div class="help-menu">
		<p>
			<a href="${pageContext.request.contextPath}/load.do">ã�ƿ��ô� ��</a>
		</p>
		<p>�����ϱ�</p>
	</div>
</div>
<script>
  // JavaScript �ڵ� �߰�
  const helpImage = document.querySelector('.help-image');
  const helpMenu = document.querySelector('.help-menu');

  helpImage.addEventListener('mouseover', () => {
    helpMenu.style.display = 'block';
  });

  helpImage.addEventListener('mouseout', () => {
    helpMenu.style.display = 'none';
  });
</script>

<footer id="footer">


	<ul class="copyright">
		<li>&copy; �ϴ����'S</li>
		<li>E -Mail : gch00335@naver.com</li>
		<li>PH : 010-4090-9045</li>
		<li>git-hub: <a href="https://github.com/gch00335/JAVA">gch00335</a></li>
	</ul>
</footer>

</body>

</html>