<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="javax.servlet.http.HttpSession" %>    
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>NINI_BANK</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<section>

<%   

	String userID = null;
	if (session.getAttribute("ID") != null){
		userID = (String) session.getAttribute("ID");
	}	    // 카카오톡 로그인 확인
	boolean isKakaoLoggedIn = false;
	String kakaoID = (String) session.getAttribute("kakaoID");
    if (kakaoID != null) {
        isKakaoLoggedIn = true;
    } 
%>

	 <div class="top-container">
  <div class="left-side">
    <h1>NINI_BANK</h1>
   <h3>오픈뱅킹시스템</h3>
    <div class="button-group">
      <% if(userID == null && isKakaoLoggedIn == false) { %>
        <a href="${pageContext.request.contextPath}/join.do" class="button">회원 가입</a>
        <a href="${pageContext.request.contextPath}/login.do" class="button">로그인</a>
  					 <% } else if (userID != null) { %>
                    <p><%= userID %> 님 환영합니다</p>
                    <a href="${pageContext.request.contextPath}/logout.do" class="button">로그아웃</a>
                <% } else if (isKakaoLoggedIn) { %>
                    <p><%= kakaoID %> 님 환영합니다</p>
                    <a href="${pageContext.request.contextPath}/logout.do" class="button">로그아웃</a>
                <% } %>
    </div>
  </div>
  <div class="right-side">
    <button class="button">Q&A게시판</button>
    <li>
        <a href="#">
            <%= kakaoID %> 님 <!-- 로그인된 아이디 표시 -->
        </a>
    </li>
  </div>
</div>

  <div class="middle-container">
    <div class="menu-button">
      <div class="menu-item">
        <img src="계좌관리.png" alt="계좌관리 아이콘">계좌관리
        <p>계좌관리</p>
      </div>
      <div class="menu-item">
        <img src="계좌이체.png" alt="계좌이체 아이콘">계좌이체
        <p>계좌이체</p>
      </div>
      <div class="menu-item">
        <img src="거래내역조회.png" alt="거래내역조회 아이콘">거래내역조회
      <p>거래내역조회</p>
    </div>
  </div>
</div>

<div class="help-image">
  <img src="도움.png" alt="도움 아이콘" width="140" height="98">
  <div class="help-menu">
    <p><a href="${pageContext.request.contextPath}/load.do" >찾아오시는 길</a></p>
    <p>문의하기</p>
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
  <%-- 
	<a href="${ pageContext.request.contextPath}/login.do">로그인</a>
	<a href="${ pageContext.request.contextPath}/logout.do" >로그아웃</a> --%>
</section>

	<!-- Footer -->
					<footer id="footer">
						
						
						<ul class="copyright">
							<li>&copy; 니니찌니'S </li ><li>E -Mail : gch00335@naver.com </li><li>PH : 010-4090-9045 </li><li>git-hub: <a href="https://github.com/gch00335/JAVA">gch00335</a></li>
						</ul>
					</footer>

			
</body>
</html>