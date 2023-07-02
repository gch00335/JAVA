<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<head>

<style>
/* Reset some default styles for consistency */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
   text-decoration: none;
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
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #008040; /* 민트색 배경 추가 */
  height: 25vh;
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

.left-side button {
  margin-top: 60px;
}



/* Additional styles */

/* 1. 상단의 민트색과 검색창 스타일 */
.top-container {
  background-color: #008040;
  display: flex;
  justify-content: flex-end; /* 수정: 버튼을 오른쪽으로 정렬 */
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
  
.customer-service {
  width: 300px;
  height: 168px;
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

.button-group {
	display: flex;
	justify-content: space-between;
	align-items: center;
	font-family: 'WooridaumB', sans-serif; 
}

.button-group a {
	color: white;
	text-decoration: none; /* 링크 효과 제거 */
	display: flex;
	align-items: center;
	justify-content: center;
	font-family: 'WooridaumB', sans-serif; 
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


</style>

  <meta charset="UTF-8" />
  <title>Kakao map</title>
 
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
    int pageNumber = 1;
	if (request.getParameter("pageNumber") != null) {
		pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
	}
%>
	
<ul class="nav navbar-nav navbar-right">


  <% if (userID == null && isKakaoLoggedIn == false ) { %>
    <div class="top-container">
  <div class="left-side">
  <a href="/bank/index.jsp">
  <img src="니니찌니로고.png" alt="로고" class="logo">
</a>
   
    <h3> 지점안내</h3><br>
    <div class="button-group">
      <h4><span class="main-page"> 메인메뉴 </span></h4>
		<h4><span class="sub-page"> > 지점안내</span></h4>
   
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
   
    <h3> 지점안내 </h3><br>
    <div class="button-group">
      <h4><span class="main-page"> 메인메뉴 </span></h4>
		<h4><span class="sub-page"> > 지점안내</span></h4>
   
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
   
    <h3> Q&A 게시판</h3><br>
    <div class="button-group">
      <h4><span class="main-page"> 메인메뉴 </span></h4>
		<h4><span class="sub-page"> > Q&A 게시판</span></h4>
   
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
















 <div class="map-container">
  <div style="display: flex;">
    <div id="map" style="flex: 1; width: 500px; height: 400px;"></div>
  
    <div style="flex: 1; margin-left: 100px;">
      <h3 style="margin-bottom: 10px; font-family: 'WooridaumB', sans-serif;">한국폴리텍대학 성남캠퍼스점</h3>
      <h4 style="margin-bottom: 10px; font-family: 'WooridaumB', sans-serif;">031-739-4000 | 영업시간 09:00 ~ 22:00</h4>
      <p class="address" style="font-family: 'WooridaumB', sans-serif;">
        <hr>
        <h5 style="margin-top: 10px;">도로명</h5>
        경기 성남시 수정구 수정로 398<br>
        경기도 성남시 분당구 산성동 4
      </p>
    </div>
  </div>
  </div>
  	<div class="customer-service">
  <h2>고객센터</h2><br><br>
  <p><a href="${pageContext.request.contextPath}/bbs.do" > 문의하기</a></p><br>
  <p style="margin-left: 100px;"><a href="${pageContext.request.contextPath}/load.do">찾아오시는 길</a></p>
</div>
 
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3be059b28175bae0d5c7b1b5d47bd7a8"></script>
<script>
  var container = document.getElementById('map');
  var options = {
    center: new kakao.maps.LatLng(37.4590828, 127.1537789),
    level: 3
  };

  var map = new kakao.maps.Map(container, options);
</script>

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