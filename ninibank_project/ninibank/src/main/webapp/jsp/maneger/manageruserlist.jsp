
<%@page import="kr.ac.kopo.util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
    <%@ page import="java.io.PrintWriter"%>
<%@page import="kr.ac.kopo.user.User"%>
<%@page import="kr.ac.kopo.user.UserDAO"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" 
href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" 
crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" 
integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" 
crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" 
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
  src: url('https://example.com/path-to/WooridaumB.woff2') format('woff2'); /* 폰트 파일의 실제 URL로 변경 */
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

  .help-image:hover + .help-menu {
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

.map-container {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  padding-left: 20px;
  margin-top: 150px; /* 원하는 여백 크기로 조정 */
  margin-left: 200px; /* 원하는 만큼 오른쪽으로 이동 */
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
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown:hover .dropdown-menu {
  display: block;
}

.top-container {
  position: relative; /* 상대적 위치 설정 */
}
.table {
	margin-top: 5px; /* 기존 값에 25px 더해서 조정 */
	
}

.row {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.btn-write {
    margin-left: auto;
}

<style type="text/css">
a, a:hover {
	color: #000000;
	test-dacoration: none;
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
</style>
  <meta charset="EUC-KR">
  <title>NINI_BBS</title>
 
</head>

<body>

<%   

	String userID = null;
	if (session.getAttribute("ID") != null){
		userID = (String) session.getAttribute("ID");
	}	    // 카카오톡 로그인 확인
	boolean isKakaoLoggedIn = false;
	String kakaoID = (String) session.getAttribute("kakaoID");
    if (kakaoID != null) {
        isKakaoLoggedIn = true;
        userID = (String) session.getAttribute("kakaoID");
    } 
  
%>
	
  <% if (userID == null) { %>
    <div class="top-container">
  <div class="left-side">
  <a href="/bank/manegerindex.jsp">
  <img src="니니찌니로고.png" alt="로고" class="logo">
</a>
   
    <h3> NINI_BANK 관리</h3><br>
    <div class="button-group">
      <h4><span class="main-page"> 메인메뉴 </span></h4>
		<h4><span class="sub-page"> > 회원정보관리</span></h4>
   
    </div>
  </div>
  <div class="right-side">
  <div class="button-group">
    <button class="button">상품관리</button>
  <div class="dropdown">
    <button class="button"> 접속하기 </button>
    <ul class="dropdown-menu">
      <li> <a href="${pageContext.request.contextPath}/login.do" class="button">로그인</a></li>
      <li>   <a href="${pageContext.request.contextPath}/join.do" class="button">회원 가입</a></li>
    </ul>
    </li>
       </div>
  </div>
</div>
  <% } else { %>
   <div class="top-container">
  <div class="left-side">
  <a href="/bank/manegerindex.jsp">
  <img src="니니찌니로고.png" alt="로고" class="logo">
</a>
   
 <h3> NINI_BANK 관리 </h3><br>
    <div class="button-group">
      <h4><span class="main-page"> MY메뉴 </span></h4>
		<h4><span class="sub-page"> > 회원정보 관리 </span></h4>
   
    </div>
  </div>
				<div class="right-side">
					<div class="button-group">
						<a href="${pageContext.request.contextPath}/managerbbs.do" class="button">Q&A게시판</a>
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

  	<div class="customer-service">
  <h2>NINI_BANK 관리</h2><br><br>
  <p style="margin-left: 100px;"><a href="${pageContext.request.contextPath}/account.do">상품관리</a></p>
  <p><a href="${pageContext.request.contextPath}/managerbbs.do">Q&A게시판 관리</a></p>
  <p><a href="${pageContext.request.contextPath}/ManageUserlist.do">회원정보 관리</a></p>
</div>

	<div class="container">
	<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #E6E6E6">
				<thead>
				<h1> 가 입 회 원 목 록 </h1>
					<tr>
					
						
						<th style="background-color: #BDBDBD; text-align: center;">아이디</th>
						<th style="background-color: #BDBDBD; text-align: center;">비밀번호</th>
						<th style="background-color: #BDBDBD; text-align: center;">이름</th>
						
						<th style="background-color: #BDBDBD; text-align: center;">이메일</th>
					</tr>
				</thead>
				<tbody>
				<%
ConnectionFactory  connectionFactory = new ConnectionFactory(); // ConnectionFactory 객체 생성
UserDAO userDAO = new UserDAO(connectionFactory); // UserDAO 객체 생성
ArrayList<User> userList = userDAO.getAllUsers(); // 수정된 부분
for (User user : userList) {
%>
            <tr>
                <td><%= user.getID() %></td>
                <td><%= user.getPASSWORD() %></td>
                <td><%= user.getName() %></td>
                <td><%= user.getEmail() %></td>
            </tr>
					<%
					}
					%>
				</tbody>
			</table>
		
		</div>
	</div>









<div class="help-image">
  <img src="도움.png" alt="도움 아이콘" width="140" height="98">
  <div class="help-menu">
    <p><a href="${pageContext.request.contextPath}/managerload.do" >찾아오시는 길</a></p>
  <p><a href="${pageContext.request.contextPath}/managerbbs.do" > 문의하기</a></p>
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
							<li>&copy; 니니찌니'S </li ><li>E -Mail : gch00335@naver.com </li><li>PH : 010-4090-9045 </li><li>git-hub: <a href="https://github.com/gch00335/JAVA">gch00335</a></li>
						</ul>
					</footer>

</body>

</html>