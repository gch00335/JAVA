<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.ac.kopo.transactionHistory.TransactionHistory"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@ page import="java.io.PrintWriter"%>
    <%@ page import="kr.ac.kopo.product.Product"%>
<%@ page import="kr.ac.kopo.bank.Bank"%>
<%@ page import="kr.ac.kopo.bank.BankDAO"%>

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


.container2{
 position: absolute;
  top: 5px;
  left: 450px;
  width: 1000px; /* Adjust the width as desired */
  margin-top: 10px; /* 필요한 경우 여백 조정 */
}
	.card {
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 10px;
  margin-bottom: 10px;
  width: 360px; /* Adjust the width as desired */
  margin-left: auto;
  margin-right: auto;
}
.card2 {

  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 10px;
  margin-bottom: 50px;
  width: 800px; /* Adjust the width as desired */
  margin-left: 1800px;
}

.card-header {
  font-weight: bold;
  margin-bottom: 5px;
}

.date {
  color: #000;
  font-weight: bold;
  margin-right: 10px;
}

.account {
  color: #000;
  
}

.amount {
  font-weight: bold;
}

.deposit {
  color: red;
}

.withdraw {
  color: blue;
}

.transaction-history {
  margin-top: 100px; /* 필요한 경우 상단 여백을 조정하세요 */
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center; /* 이 속성을 추가해 보세요 */
}		
	
	
	</style>
  <meta charset="EUC-KR">
  <title>NINI_BBS</title>
 
</head>

<body>
<%
	String url = "";
    String userID = null;
    boolean isKakaoLoggedIn = false;
    
    if (session.getAttribute("ID") != null) {
        userID = (String) session.getAttribute("ID");
    } else {
        String kakaoID = (String) session.getAttribute("kakaoID");
        if (kakaoID != null) {
            isKakaoLoggedIn = true;
            userID = (String) session.getAttribute("kakaoID");
        }
        
        
 // 로그인 확인 및 처리
    if (userID == null && !isKakaoLoggedIn) {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter loginScript = response.getWriter();
        loginScript.println("<script>");
        loginScript.println("alert('로그인을 하세요');");
        loginScript.println("location.href = '/bank/index.jsp';");
        loginScript.println("</script>");
        loginScript.close();
    }
    }
    
    // BankDAO 인스턴스 생성
    BankDAO bankDAO = new BankDAO();
    
    // getAccountList 메서드 호출 시 userID 전달
    ArrayList<Bank> accountList = bankDAO.getAccountList(userID);
    
    // 클릭한 계좌 정보 가져오기
    String selectedAccount = request.getParameter("selectedAccount");
    
    // 선택한 계좌에 해당하는 거래 내역 조회
    List<TransactionHistory> transactionHistoryList = null;
    if (selectedAccount != null) {
        transactionHistoryList = bankDAO.getTransactionHistory(selectedAccount);
    }
    
%>




<ul class="nav navbar-nav navbar-right">
    <% if (userID == null && isKakaoLoggedIn == false) { %>
    <div class="top-container">
  <div class="left-side">
  <a href="/bank/index.jsp">
  <img src="니니찌니로고.png" alt="로고" class="logo">
</a>
   
    <h3> 거래내역조회</h3><br>
    <div class="button-group">
      <h4><span class="main-page"> MY메뉴 </span></h4>
		<h4><span class="sub-page"> > 거래내역조회</span></h4>
   
    </div>
  </div>
  <div class="right-side">
  <div class="button-group">
    <button class="button">Q&A게시판</button>
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
  <% } else if (isKakaoLoggedIn) { %>
   <div class="top-container">
  <div class="left-side">
  <a href="/bank/index.jsp">
  <img src="니니찌니로고.png" alt="로고" class="logo">
</a>
   
<h3> 거래내역조회 </h3><br>
    <div class="button-group">
      <h4><span class="main-page"> MY메뉴 </span></h4>
		<h4><span class="sub-page"> > 거래내역조회 </span></h4>
   
    </div>
  </div>
  <div class="right-side">
  <div class="button-group">
    <a href="${pageContext.request.contextPath}/bbs.do" class="button">Q&A게시판</a>
						<a href="${pageContext.request.contextPath}/Mypage.do" class="button"> MYPAGE</a>
						 <a href="${pageContext.request.contextPath}/logout.do" class="button">로그아웃</a>
						 <a href="${pageContext.request.contextPath}/account.do" class="button">MY계좌</a>
       </div>
  </div>
</div>
  <% } else { %>
   <div class="top-container">
  <div class="left-side">
  <a href="/bank/index.jsp">
  <img src="니니찌니로고.png" alt="로고" class="logo">
</a>
   
 <h3> 거래내역조회 </h3><br>
    <div class="button-group">
      <h4><span class="main-page"> MY메뉴 </span></h4>
		<h4><span class="sub-page"> > 거래내역조회 </span></h4>
   
    </div>
  </div>
  <div class="right-side">
  <div class="button-group">
    					<a href="${pageContext.request.contextPath}/bbs.do" class="button">Q&A게시판</a>
						<a href="${pageContext.request.contextPath}/Mypage.do" class="button"> MYPAGE</a>
						 <a href="${pageContext.request.contextPath}/logout.do" class="button">로그아웃</a>
						 <a href="${pageContext.request.contextPath}/account.do" class="button">MY계좌</a>
       </div>
  </div>
</div>
  <% } %>
</ul>


  	<div class="customer-service">
  <h2>MY 계좌</h2><br><br>
  <p><a href="${pageContext.request.contextPath}/account.do">계좌관리</a></p>
   <p>
  <a href="${pageContext.request.contextPath}/Product.do">계좌상품</a>
		</p>
  <p><a href="${pageContext.request.contextPath}/Openbank.do">오픈뱅킹연결</a></p>
  <p style="margin-left: 100px;"><a href="${pageContext.request.contextPath}/detalle.do">거래내역조회</p>
  <p><a href="${pageContext.request.contextPath}/transfer.do">계좌이체</a></p>
 
 









<!-- 계좌 목록 출력 -->
<div class="account-list">
    <div class="container2">
        <div class="row">
            <% long totalBalance = 0; %>
            <% for (Bank account : accountList) { %>
                <% long balance = Long.parseLong(account.getBalance()); %>
                <% totalBalance += balance; %>
            <% } %>
            <div class="col-md-12" style="text-align: left;">
                <p style="font-size: 30px; font-weight: bold; color: darkgreen; text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3); margin-top: 2px;">
                      내 계좌 총 금액: <%= String.format("%,d", totalBalance).replace(",", ", ") %> 원
                </p>
            </div>
        </div>
        <div class="row">
            <% for (Bank account : accountList) { %>
                <div class="col-md-4">
                    <div class="card" style="margin-bottom: 20px; border: 1px solid #ccc; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);">
                        <div class="card-body">
                            <h5 class="card-title" style="font-size: 18px; font-weight: bold;">계좌번호: <%= account.getAcc_num() %></h5>
                            <h6 class="card-subtitle mb-2 text-muted">은행: <%= account.getAcName() %></h6>
                            <p class="card-text" style="font-size: 20px; font-weight: bold;">잔액:  <%= String.format("%,d", Long.parseLong(account.getBalance())) %> 원</p>
                            <a href="?selectedAccount=<%= account.getAcc_num() %>" class="card-link" style="color: #007bff; font-weight: bold;">선택</a>
                        </div>
                    </div>
                </div>
            <% } %>
        </div>
    </div>
</div>
<!-- 거래 내역 출력 -->

<div class="transaction-history">
    <% if (transactionHistoryList == null || transactionHistoryList.isEmpty()) { %>
      
    <% } else { %>
        <% for (TransactionHistory history : transactionHistoryList) { %>
            <div class="card2">
                <div class="card-header">
                    <span class="date"><%= new SimpleDateFormat("yyyy-MM-dd HH:mm").format(history.getTransactionDate()) %></span>
                    <span class="account">
                          <% if (history.getTransactionType().equals("입금")) { %>
           					 || 보낸 계좌: <%= history.getTransactionId() %> || 보낸 사람: <%= history.getSenderName() %>
      					  <% } else { %>
          					  || 받은 계좌: <%= history.getAccountNumber() %> || 받는 사람: <%= history.getRecipientName() %>
          					    <% } %>
                    </span>
                </div>
                <div class="amount <%= history.getTransactionType().equals("입금") ? "deposit" : "withdraw" %>">
                    <% if (history.getTransactionType().equals("입금")) { %>
                       + <%= String.format("%,d", (long) history.getAmount()).replaceAll(",", ", ") %>
                    <% } else { %>
                       - <%= String.format("%,d", (long) history.getAmount()).replaceAll(",", ", ") %>
                    <% } %>
                </div>
            </div>
        <% } %>
    <% } %>
</div>


<div class="help-image">
  <img src="도움.png" alt="도움 아이콘" width="140" height="98">
  <div class="help-menu">
    <p><a href="${pageContext.request.contextPath}/load.do" >찾아오시는 길</a></p>
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
							<li>&copy; 니니찌니'S </li ><li>E -Mail : gch00335@naver.com </li><li>PH : 010-4090-9045 </li><li>git-hub: <a href="https://github.com/gch00335/JAVA">gch00335</a></li>
						</ul>
					</footer>

</body>

</html>