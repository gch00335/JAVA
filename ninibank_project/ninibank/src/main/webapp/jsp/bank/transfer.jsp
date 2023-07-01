<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="EUC-KR"%>
<%@page import="java.util.List"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="kr.ac.kopo.product.Product"%>
<%@ page import="kr.ac.kopo.bank.Bank"%>
<%@ page import="kr.ac.kopo.bank.BankDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>

<head>
 <meta charset="EUC-KR">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>

<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>

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
	/* 폰트 파일의 실제 URL로 변경 */
	font-weight: 700;
	font-style: normal;
}
/* Styling for the top container */
.top-container {
	background-color: #008040;
	display: flex;
	justify-content: space-between; /* 수정: 왼쪽과 오른쪽 사이의 공간을 최대화 */
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
	background-color: #ffffff; /* 하양 배경 추가 */
	border-radius: 5px;
	padding: 20px;
}

.left-side h1 {
	font-size: 60px; /* 큰 글씨체로 수정 */
	font-weight: bold; /* 진한 글씨체로 수정 */
	color: #008040; /* 민트색으로 수정 */
	font-family: 'WooridaumB', sans-serif;
}

.left-side h3 {
	font-size: 34px; /* 작은 글씨체로 수정 */
	color: #000;
	margin-bottom: 10px;
	font-family: 'WooridaumB', sans-serif;
}

.right-side {
	display: flex;
	flex-direction: column;
	justify-content: flex-start; /* 수정: 맨 위로 정렬되도록 변경 */
	align-items: center;
	width: 50%;
	height: 100%;
	background-color: #008040; /* 민트색 배경 추가 */
	border-radius: 5px;
	margin-left: 20px;
}

.right-side .button {
	margin-left: 10px; /* 수정: 버튼 간격을 조정 */
}

.button-group {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.button-group a {
	color: white;
	text-decoration: none; /* 링크 효과 제거 */
	display: flex;
	align-items: center;
	justify-content: center;
}

/* Additional styles */

/* 1. 상단의 민트색과 검색창 스타일 */
.top-container {
	background-color: #008040;
	display: flex;
	justify-content: space-between; /* 수정: 왼쪽과 오른쪽 사이의 공간을 최대화 */
	align-items: center;
	height: 25vh;
	font-weight: bold;
	font-family: 'WooridaumB', sans-serif;
}

.right-side {
	display: flex;
	flex-direction: column;
	align-items: flex-end; /* 수정: 맨 오른쪽에 위치하도록 변경 */
	margin-left: 20px;
	background-color: #008040; /* 민트색 배경 추가 */
	font-weight: bold;
	font-family: 'WooridaumB', sans-serif;
}

/* 2. 왼쪽 하양쪽 디자인 수정 */
.left-side {
	text-align: center;
	background-color: #ffffff; /* 하양 배경 추가 */
	padding: 20px;
	border-radius: 5px;
}

.left-side h1 {
	font-size: 60px; /* 큰 글씨체로 수정 */
	font-weight: bold; /* 진한 글씨체로 수정 */
	color: #008040; /* 민트색으로 수정 */
	font-family: 'WooridaumB', sans-serif;
	margin-left: -250px; /* 왼쪽으로 20px 이동 */
}

.left-side h3 {
	font-size: 34px; /* 작은 글씨체로 수정 */
	color: #000;
	margin-bottom: 5px;
	font-family: 'WooridaumB', sans-serif;
}

.left-side h4 {
	font-size: 16px; /* 작은 글씨체로 수정 */
	margin-bottom: 5px;
	font-family: 'WooridaumB', sans-serif;
}

.main-page {
	color: #FF8000; /* 메인화면의 주황색 */
}

.sub-page {
	color: #888888; /* 지점안내의 회색 */
}

.button {
	width: 100px;
	height: 40px;
	margin-top: 10px;
	background-color: #4CAF50;
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

/* 스타일 코드 추가 */
.help-image {
	position: fixed; /* 고정 위치 */
	bottom: 60px; /* Footer 바로 위에 위치 */
	right: 20px; /* 오른쪽 정렬 */
	font-family: 'WooridaumB', sans-serif;
}

.help-menu {
	display: none; /* 초기에는 숨김 */
	position: absolute;
	bottom: 100%; /* 도움 아이콘 위에 위치 */
	left: 50%;
	transform: translateX(-50%);
	background-color: #fff;
	padding: 10px;
	width: 200px; /* 메뉴 칸 너비 조정 */
	font-family: 'WooridaumB', sans-serif;
}

.help-menu p {
	margin: 5px 0; /* 간격 조정 */
	cursor: pointer; /* 커서 포인터로 변경 */
}

.help-menu p:hover {
	background-color: #eee; /* 마우스를 올렸을 때 배경 색상 변경 */
}

.help-image:hover+.help-menu {
	display: block; /* 마우스 커서를 올렸을 때 메뉴 표시 */
}

/* 스타일 코드 추가 */
#footer {
	background-color: #f1f1f1;
	text-align: center;
	font-size: 14px;
	/* 기존 스타일 속성 */
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
	border: 1px solid #000; /* 검정 테두리 추가 */
	position: absolute; /* 위치를 절대적으로 설정 */
	top: 350px; /* 원하는 위치로 조정 */
	left: 100px; /* 원하는 위치로 조정 */
	text-align: center; /* 텍스트를 오른쪽으로 정렬 */
}

.customer-service p {
	margin-right: 10px; /* 오른쪽으로 10px의 띄어쓰기 적용 */
}

/* 추가 스타일 코드 */
.logo {
	position: absolute;
	top: 20px;
	left: 20px;
	width: 300px; /* 이미지 너비 조정 (적절한 값으로 변경) */
	height: 50; /* 이미지 높이 자동 조정 */
}

/* 추가 스타일 코드 */
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
	position: relative; /* 상대적 위치 설정 */
}

.table {
	margin-top: 40px; /* 기존 값에 25px 더해서 조정 */
}

.row {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.btn-write {
	margin-left: auto;
}

.customer-service {
	width: 300px;
	height: 300px;
	background-color: #ffffff; /* 하얀색으로 변경 */
	border-radius: 10px;
	box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.3);
	padding: 20px;
}

/* 이하 동일 */
.customer-service h2 {
	font-size: 18px;
}

.customer-service p {
	font-size: 14px;
}

.customer-service a {
	color: #007bff;
	text-decoration: none;
}

.customer-service a:hover {
	text-decoration: underline;
}

.col-auto {
	position: absolute;
	top: 350px;
	left: 450px;
	margin-top: 10px; /* 필요한 경우 여백 조정 */
}

.container {
	position: absolute;
	top: 360px;
	left: 450px;
	margin-top: 10px; /* 필요한 경우 여백 조정 */
}

@import
	url('https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap')
	;

body {
	font-family: 'Nanum Gothic', sans-serif;
}

h4, .mb-3, .btn-primary, .mb-33 {
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

h4 {
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
	width: 100%; /* 수정: 가로 길이를 100%로 변경 */
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 3px;
	box-sizing: border-box; /* 수정: 상자 크기를 박스 모델에 맞춤 */
	margin-top: 20px; /* 추가: 입력창 사이의 간격을 조정 */
	margin-bottom: 10px; /* 추가: 입력창 사이의 간격을 조정 */
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
	font-family: Arial, sans-serif; /* 폰트 설정 */
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
	height: 120vh;
}

.input-form-background {
	background-color: #ffffff;
	padding: 25px;
	width: 700px; /* 원하는 넓이 설정 */
	margin: 0 auto; /* 가운데 정렬을 위해 margin을 auto로 설정 */
}
</style>
<meta charset="EUC-KR">
<title>NINI_BBS</title>

</head>
<body>
	<%
	String userID = null;
	if (session.getAttribute("ID") != null) {
		userID = (String) session.getAttribute("ID");
	} // 카카오톡 로그인 확인
	boolean isKakaoLoggedIn = false;
	String kakaoID = (String) session.getAttribute("kakaoID");
	if (kakaoID != null) {
		isKakaoLoggedIn = true;
		userID = (String) session.getAttribute("kakaoID");
	}

	// BankDAO 인스턴스 생성
	BankDAO bankDAO = new BankDAO();

	// getAccountList 메서드 호출 시 userID 전달
	ArrayList<Bank> accountList = bankDAO.getAccountList(userID);
	request.setAttribute("accountList", accountList);
	%>




	<ul class="nav navbar-nav navbar-right">


		<%
		if (userID == null && isKakaoLoggedIn == false) {
		%>
		<div class="top-container">
			<div class="left-side">
				<a href="/bank/index.jsp"> <img src="니니찌니로고.png" alt="로고"
					class="logo">
				</a>

				<h3>계좌이체 </h3>
				<br>
				<div class="button-group">
					<h4>
						<span class="main-page"> 메인메뉴 </span>
					</h4>
					<h4>
						<span class="sub-page"> > 계좌이체 </span>
					</h4>

				</div>
			</div>
			<div class="right-side">
				<div class="button-group">
					<button class="button">Q&A게시판</button>
					<div class="dropdown">
						<button class="button">접속하기</button>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/login.do"
								class="button">로그인</a></li>
							<li><a href="${pageContext.request.contextPath}/join.do"
								class="button">회원 가입</a></li>
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
					<a href="/bank/index.jsp"> <img src="니니찌니로고.png" alt="로고"
						class="logo">
					</a>

					<h3>계좌이체 </h3>
					<br>
					<div class="button-group">
						<h4>
							<span class="main-page"> MY메뉴 </span>
						</h4>
						<h4>
							<span class="sub-page"> > 계좌이체  </span>
						</h4>

					</div>
				</div>
				<div class="right-side">
					<div class="button-group">
						<a href="${pageContext.request.contextPath}/bbs.do" class="button">Q&A게시판</a>
						<a href="${pageContext.request.contextPath}/Mypage.do"
							class="button"> MYPAGE</a> <a
							href="${pageContext.request.contextPath}/logout.do"
							class="button">로그아웃</a> <a
							href="${pageContext.request.contextPath}/account.do"
							class="button">MY계좌</a>
					</div>
				</div>
			</div>
			<%
			} else {
			%>
			<div class="top-container">
				<div class="left-side">
					<a href="/bank/index.jsp"> <img src="니니찌니로고.png" alt="로고"
						class="logo">
					</a>

					<h3>계좌이체 </h3>
					<br>
					<div class="button-group">
						<h4>
							<span class="main-page"> MY메뉴 </span>
						</h4>
						<h4>
							<span class="sub-page"> > 계좌이체  </span>
						</h4>

					</div>
				</div>
				<div class="right-side">
					<div class="button-group">
						<a href="${pageContext.request.contextPath}/bbs.do" class="button">Q&A게시판</a>
						<a href="${pageContext.request.contextPath}/Mypage.do"
							class="button"> MYPAGE</a> <a
							href="${pageContext.request.contextPath}/logout.do"
							class="button">로그아웃</a> <a
							href="${pageContext.request.contextPath}/account.do"
							class="button">MY계좌</a>
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
                <h4 class="mb-33">계좌 이체</h4>
                <form class="validation-form" method="post" action="${pageContext.request.contextPath}/transferaction.do">
                    <div class="mb-3">
                        <label for="bank">내 은행명</label>
                        <select id="bank" name="bank" class="form-control" required>
                            <option value="">은행을 선택하세요</option>
                            <option value="NA_BANK">NA_BANK</option>
                            <option value="YJ_BANK">YJ_BANK</option>
                        </select>
                    </div>

                    <div class="mb-3">
                        <label for="fromAccount">출금 계좌</label>
                        <select id="fromAccount" name="fromAccount" class="form-control" required>
                            <option value="">출금 계좌를 선택하세요</option>
                            <c:forEach var="account" items="${requestScope.accountList}">
                                <option value="${account.acc_num}">${account.acc_num}</option>
                            </c:forEach>
                        </select>
                    </div>
 							<div class="mb-3">
                        <label for="bank2">보낼 은행명</label>
                        <select id="bank2" name="bank2" class="form-control" required>
                            <option value="">은행을 선택하세요</option>
                            <option value="NINI_bank">NINI_bank</option>
                            <option value="NY_BANK">NY_BANK</option>
                            <option value="YZ_BANK">YZ_BANK</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="toAccount">입금 계좌</label>
                        <input type="text" class="form-control" id="toAccount" name="toAccount" placeholder="입금 계좌 번호" required>
                    </div>

                    <div class="mb-3">
                        <label for="senderName">보내는 사람 이름</label>
                        <input type="text" class="form-control" id="senderName" name="senderName" placeholder="보내는 사람 이름" required>
                    </div>

                    <div class="mb-3">
                        <label for="recipientName">받는 사람 이름</label>
                        <input type="text" class="form-control" id="recipientName" name="recipientName" placeholder="받는 사람 이름" required>
                    </div>

                    <div class="mb-3">
                        <label for="amount">이체 금액</label>
                        <input type="text" class="form-control" id="amount" name="amount" placeholder="이체 금액" required>
                    </div>

                   <!--  <div class="mb-3">
                        <label for="password">계좌 비밀번호</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="계좌 비밀번호" required>
                    </div> -->

                    <button class="btn btn-primary btn-lg" type="submit">계좌 이체</button>
                </form>
            </div>
        </div>
    </div>
</div>














	<div class="customer-service">
		<h2>MY 계좌</h2>
		<br> <br>
		<p>
			<a href="${pageContext.request.contextPath}/account.do">계좌관리 
		</p>
		<p>
			<a href="${pageContext.request.contextPath}/Openbank.do">오픈뱅킹연결</a>
		</p>
		<p>
			<a href="${pageContext.request.contextPath}/detalle.do">거래내역조회
		</p>
		<p style="margin-left: 100px;">
			<a href="${pageContext.request.contextPath}/transfer.do">계좌이체 
		</p>
	</div>




	<div class="help-image">
		<img src="도움.png" alt="도움 아이콘" width="140" height="98">
		<div class="help-menu">
			<p>
				<a href="${pageContext.request.contextPath}/load.do">찾아오시는 길</a>
			</p>
			 <p><a href="${pageContext.request.contextPath}/bbs.do" > 문의하기</a></p>
		</div>
	</div>




	<script>
  // JavaScript 코드 추가
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
			<li>&copy; 니니찌니'S</li>
			<li>E -Mail : gch00335@naver.com</li>
			<li>PH : 010-4090-9045</li>
			<li>git-hub: <a href="https://github.com/gch00335/JAVA">gch00335</a></li>
		</ul>
	</footer>

</body>

</html>