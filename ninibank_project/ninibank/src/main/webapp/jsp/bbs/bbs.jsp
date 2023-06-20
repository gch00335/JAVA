<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.io.PrintWriter"%>
<%@ page import="kr.ac.kopo.bbs.Bbs"%>
<%@ page import="kr.ac.kopo.bbs.BbsDAO"%>
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

.button-group {
  display: flex;
  justify-content: space-between; /* ����: ��ư�� ������ ���� */

   margin-bottom: 10px; /* ���� ������ ���� ���� */
}
.button {
  width: 100px;
  height: 40px;
  margin-top: 10px;
  background-color:  #ffffff;
  border: none;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
   margin-right: 10px;
     font-family: 'WooridaumB', sans-serif; 
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
  border: none;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
   font-weight: bold;
  font-family: 'WooridaumB', sans-serif; 
  
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
 /* CSS ��Ÿ�� */


/* �߰� ��Ÿ�� �ڵ� */
.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-menu {
  display: none;
  position: absolute;
  top: 100%;
  left: 0; /* ����: ���� ���ķ� ���� */
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

.dropdown-menu {
  top: calc(25vh + 10px); /* ����: 25vh �Ʒ��� �̵� */
}


<style type="text/css">
a, a:hover {
	color: #000000;
	test-dacoration: none;
}
</style>
  <meta charset="UTF-8" />
  <title>NINI_BBS</title>
 
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
    } 
    int pageNumber = 1;
	if (request.getParameter("pageNumber") != null) {
		pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
	}
%>
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
    <button class="button">Q&A�Խ���</button>
  </div>
</div>

<ul class="nav navbar-nav navbar-right">


  <% if (userID == null && isKakaoLoggedIn == false ) { %>
    <div class="dropdown">
 <a href="#" class="dropdown-toggle" role="button" aria-haspopup="true" aria-expanded="false">
    �����ϱ�<span class="caret"></span>
      </a>
      <ul class="dropdown-menu">
        <li><a href="login.jsp">�α���</a></li>
        <li><a href="join.jsp">ȸ������</a></li>
        <li><a href="manager.jsp">�����ڸ��</a></li>
      </ul>
    </li>
  <% } else if (isKakaoLoggedIn) { %>
    <li>
      <a href="#">
        <%= kakaoID %> �� <!-- �α��ε� ���̵� ǥ�� -->
      </a>
    </li>
    <li class="dropdown">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
        ȸ������<span class="caret"></span>
      </a>
      <ul class="dropdown-menu">
        <li><a href="mypage.jsp">����������</a></li>
        <li><a href="logoutAction.jsp">�α׾ƿ�</a></li>
      </ul>
    </li>
  <% } else { %>
    <li>
      <a href="#">
        <%= userID %> �� <!-- �α��ε� ���̵� ǥ�� -->
      </a>
    </li>
    <li class="dropdown">
      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
        ȸ������<span class="caret"></span>
      </a>
      <ul class="dropdown-menu">
        <li><a href="mypage.jsp">����������</a></li>
        <li><a href="logoutAction.jsp">�α׾ƿ�</a></li>
      </ul>
    </li>
  <% } %>
</ul>



	<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #E6E6E6">
				<thead>
					<tr>
						<th style="background-color: #BDBDBD; text-align: center;">��ȣ</th>
						<th style="background-color: #BDBDBD; text-align: center;">����</th>
						<th style="background-color: #BDBDBD; text-align: center;">�ۼ���</th>
						<th style="background-color: #BDBDBD; text-align: center;">�ۼ���</th>
					</tr>
				</thead>
				<tbody>
					<%
					BbsDAO bbsDAO = new BbsDAO();
					ArrayList<Bbs> list = bbsDAO.getList(pageNumber);
					for (int i = 0; i < list.size(); i++) {
					%>

					<tr>
						<td><%=list.get(i).getBbsID()%></td>
						<td><a href="view.jsp?bbsID=<%=list.get(i).getBbsID()%>"><%=list.get(i).getBbsTitle().replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "gt;")
		.replaceAll("\n", "<br>")%></a></td>
						<td><%=list.get(i).getUserID()%></td>
						<td><%=list.get(i).getBbsDate().substring(0, 11) + list.get(i).getBbsDate().substring(11, 13) + "��"
		+ list.get(i).getBbsDate().substring(14, 16) + "��"%></td>

					</tr>
					<%
					}
					%>
				</tbody>
			</table>
			<%
			if (pageNumber != 1) {
			%>
			<a href="bbs.jsp?pageNumber=<%=pageNumber - 1%>"
				class="btn btn-success btn-arraw-left">����</a>
			<%
			}
			if (bbsDAO.nextPage(pageNumber + 1)) {
			%>
			<a href="bbs.jsp?pageNumber=<%=pageNumber + 1%>"
				class="btn btn-success btn-arraw-left">����</a>
			<%
			}
			%>
			<a href="write.jsp" class="btn btn-primary pull-right">�۾���</a>
		</div>
	</div>















<div class="help-image">
  <img src="����.png" alt="���� ������" width="140" height="98">
  <div class="help-menu">
    <p><a href="${pageContext.request.contextPath}/load.do" >ã�ƿ��ô� ��</a></p>
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
							<li>&copy; �ϴ����'S </li ><li>E -Mail : gch00335@naver.com </li><li>PH : 010-4090-9045 </li><li>git-hub: <a href="https://github.com/gch00335/JAVA">gch00335</a></li>
						</ul>
					</footer>

</body>

</html>