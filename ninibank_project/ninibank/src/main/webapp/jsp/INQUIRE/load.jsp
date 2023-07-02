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
  src: url('https://example.com/path-to/WooridaumB.woff2') format('woff2'); /* ��Ʈ ������ ���� URL�� ���� */
  font-weight: 700;
  font-style: normal;
}
/* Styling for the top container */
.top-container {
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #008040; /* ��Ʈ�� ��� �߰� */
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

.left-side button {
  margin-top: 60px;
}



/* Additional styles */

/* 1. ����� ��Ʈ���� �˻�â ��Ÿ�� */
.top-container {
  background-color: #008040;
  display: flex;
  justify-content: flex-end; /* ����: ��ư�� ���������� ���� */
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

  .help-image:hover + .help-menu {
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

.map-container {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  padding-left: 20px;
  margin-top: 150px; /* ���ϴ� ���� ũ��� ���� */
  margin-left: 200px; /* ���ϴ� ��ŭ ���������� �̵� */
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
  
.customer-service {
  width: 300px;
  height: 168px;
  background-color: #ffffff; /* �Ͼ������ ���� */
  border-radius: 10px;
  box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.3);
  padding: 20px;
}

/* ���� ���� */
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
	text-decoration: none; /* ��ũ ȿ�� ���� */
	display: flex;
	align-items: center;
	justify-content: center;
	font-family: 'WooridaumB', sans-serif; 
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
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
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


</style>

  <meta charset="UTF-8" />
  <title>Kakao map</title>
 
</head>

<body>

<%   

	String userID = null;
	if (session.getAttribute("ID") != null){
		userID = (String) session.getAttribute("ID");
	}	    // īī���� �α��� Ȯ��
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
  <img src="�ϴ���Ϸΰ�.png" alt="�ΰ�" class="logo">
</a>
   
    <h3> �����ȳ�</h3><br>
    <div class="button-group">
      <h4><span class="main-page"> ���θ޴� </span></h4>
		<h4><span class="sub-page"> > �����ȳ�</span></h4>
   
    </div>
  </div>
  <div class="right-side">
  <div class="button-group">
    <button class="button">Q&A�Խ���</button>
  <div class="dropdown">
    <button class="button"> �����ϱ� </button>
    <ul class="dropdown-menu">
      <li> <a href="${pageContext.request.contextPath}/login.do" class="button">�α���</a></li>
      <li>   <a href="${pageContext.request.contextPath}/join.do" class="button">ȸ�� ����</a></li>
    </ul>
    </li>
       </div>
  </div>
</div>
  <% } else if (isKakaoLoggedIn) { %>
   <div class="top-container">
  <div class="left-side">
  <a href="/bank/index.jsp">
  <img src="�ϴ���Ϸΰ�.png" alt="�ΰ�" class="logo">
</a>
   
    <h3> �����ȳ� </h3><br>
    <div class="button-group">
      <h4><span class="main-page"> ���θ޴� </span></h4>
		<h4><span class="sub-page"> > �����ȳ�</span></h4>
   
    </div>
  </div>
  <div class="right-side">
  <div class="button-group">
   <a href="${pageContext.request.contextPath}/bbs.do" class="button">Q&A�Խ���</a>
						<a href="${pageContext.request.contextPath}/Mypage.do" class="button"> MYPAGE</a>
						 <a href="${pageContext.request.contextPath}/logout.do" class="button">�α׾ƿ�</a>
						 <a href="${pageContext.request.contextPath}/account.do" class="button">MY����</a>
       </div>
  </div>
</div>
  <% } else { %>
   <div class="top-container">
  <div class="left-side">
  <a href="/bank/index.jsp">
  <img src="�ϴ���Ϸΰ�.png" alt="�ΰ�" class="logo">
</a>
   
    <h3> Q&A �Խ���</h3><br>
    <div class="button-group">
      <h4><span class="main-page"> ���θ޴� </span></h4>
		<h4><span class="sub-page"> > Q&A �Խ���</span></h4>
   
    </div>
  </div>
  <div class="right-side">
  <div class="button-group">
   <a href="${pageContext.request.contextPath}/bbs.do" class="button">Q&A�Խ���</a>
						<a href="${pageContext.request.contextPath}/Mypage.do" class="button"> MYPAGE</a>
						 <a href="${pageContext.request.contextPath}/logout.do" class="button">�α׾ƿ�</a>
						 <a href="${pageContext.request.contextPath}/account.do" class="button">MY����</a>
       </div>
  </div>
</div>
  <% } %>
</ul>
















 <div class="map-container">
  <div style="display: flex;">
    <div id="map" style="flex: 1; width: 500px; height: 400px;"></div>
  
    <div style="flex: 1; margin-left: 100px;">
      <h3 style="margin-bottom: 10px; font-family: 'WooridaumB', sans-serif;">�ѱ������ش��� ����ķ�۽���</h3>
      <h4 style="margin-bottom: 10px; font-family: 'WooridaumB', sans-serif;">031-739-4000 | �����ð� 09:00 ~ 22:00</h4>
      <p class="address" style="font-family: 'WooridaumB', sans-serif;">
        <hr>
        <h5 style="margin-top: 10px;">���θ�</h5>
        ��� ������ ������ ������ 398<br>
        ��⵵ ������ �д籸 �꼺�� 4
      </p>
    </div>
  </div>
  </div>
  	<div class="customer-service">
  <h2>������</h2><br><br>
  <p><a href="${pageContext.request.contextPath}/bbs.do" > �����ϱ�</a></p><br>
  <p style="margin-left: 100px;"><a href="${pageContext.request.contextPath}/load.do">ã�ƿ��ô� ��</a></p>
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
  <img src="����.png" alt="���� ������" width="140" height="98">
  <div class="help-menu">
    <p><a href="${pageContext.request.contextPath}/load.do" >ã�ƿ��ô� ��</a></p>
     <p><a href="${pageContext.request.contextPath}/bbs.do" > �����ϱ�</a></p>
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
							<li>&copy; �ϴ����'S </li ><li>E -Mail : gch00335@naver.com </li><li>PH : 010-4090-9045 </li><li>git-hub: <a href="https://github.com/gch00335/JAVA">gch00335</a></li>
						</ul>
					</footer>

</body>

</html>