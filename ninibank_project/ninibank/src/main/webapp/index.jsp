<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="javax.servlet.http.HttpSession" %>    
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<style>
 /* �߰� ��Ÿ�� �ڵ� */
.logo {
  position: absolute;
  top: 20px;
  left: 20px;
  width: 300px; /* �̹��� �ʺ� ���� (������ ������ ����) */
  height: 50; /* �̹��� ���� �ڵ� ���� */
}
</style>
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
	}	    // īī���� �α��� Ȯ��
	boolean isKakaoLoggedIn = false;
	String kakaoID = (String) session.getAttribute("kakaoID");
    if (kakaoID != null) {
        isKakaoLoggedIn = true;
    } 
%>

	 <div class="top-container">
  <div class="left-side">
  
    <img src="�ϴ���Ϸΰ�.png" alt="�ΰ�" class="logo">
    <h1>NINI_BANK</h1>
   <h3>���¹�ŷ�ý���</h3>
    <div class="button-group">
      <% if(userID == null && isKakaoLoggedIn == false) { %>
        <a href="${pageContext.request.contextPath}/join.do" class="button">ȸ�� ����</a>
        <a href="${pageContext.request.contextPath}/login.do" class="button">�α���</a>
  					 <% } else if (userID != null) { %>
                    <p><%= userID %> �� ȯ���մϴ�</p>
                    <a href="${pageContext.request.contextPath}/logout.do" class="button">�α׾ƿ�</a>
                <% } else if (isKakaoLoggedIn) { %>
                    <p><%= kakaoID %> �� ȯ���մϴ�</p>
                    <a href="${pageContext.request.contextPath}/logout.do" class="button">�α׾ƿ�</a>
                <% } %>
    </div>
    
    
  </div>
  <div class="right-side">
    <button class="button">Q&A�Խ���</button>
    <li>
        <a href="#">
            <%= kakaoID %> �� <!-- �α��ε� ���̵� ǥ�� -->
        </a>
    </li>
  </div>
</div>

  <div class="middle-container">
    <div class="menu-button">
      <div class="menu-item">
        <img src="���°���.png" alt="���°��� ������">���°���
        <p>���°���</p>
      </div>
      <div class="menu-item">
        <img src="������ü.png" alt="������ü ������">������ü
        <p>������ü</p>
      </div>
      <div class="menu-item">
        <img src="�ŷ�������ȸ.png" alt="�ŷ�������ȸ ������">�ŷ�������ȸ
      <p>�ŷ�������ȸ</p>
    </div>
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
  <%-- 
	<a href="${ pageContext.request.contextPath}/login.do">�α���</a>
	<a href="${ pageContext.request.contextPath}/logout.do" >�α׾ƿ�</a> --%>
</section>

	<!-- Footer -->
					<footer id="footer">
						
						
						<ul class="copyright">
							<li>&copy; �ϴ����'S </li ><li>E -Mail : gch00335@naver.com </li><li>PH : 010-4090-9045 </li><li>git-hub: <a href="https://github.com/gch00335/JAVA">gch00335</a></li>
						</ul>
					</footer>

			
</body>
</html>