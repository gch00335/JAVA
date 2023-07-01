<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="javax.servlet.http.HttpSession" %>    
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<style>
.menu-item a {
  color: #008040; /* ������� ���� */
  text-decoration: none; /* ��ũ ȿ�� ���� */
  font-weight: bold;
  text-align: center; /* ��� ���� */
  margin-top: 10px; /* ��ũ�� �̹��� ������ ���� �߰� */
}
.no-link {
  color: black; /* ���������� ���� */
  text-decoration: none; /* ��ũ ȿ�� ���� */
  display: flex;
  align-items: center;
  justify-content: center;
}
 /* �߰� ��Ÿ�� �ڵ� */
.logo {
  position: absolute;
  top: 20px;
  left: 20px;
  width: 300px; /* �̹��� �ʺ� ���� (������ ������ ����) */
  height: 50; /* �̹��� ���� �ڵ� ���� */
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
	
%>

	 <div class="top-container">
  <div class="left-side">
  
    <img src="�ϴ���Ϸΰ�.png" alt="�ΰ�" class="logo">
    <h1>NINI_BANK</h1>
   <h3>���¹�ŷ�ý���</h3>
    <div class="button-group">
      <% if(userID == null) { %>
        <a href="${pageContext.request.contextPath}/join.do" class="button">ȸ�� ����</a>
        <a href="${pageContext.request.contextPath}/login.do" class="button">�α���</a>
  					 <% } else if (userID != null) { %>
                    <p><%= userID %> �����ڴ� ȯ���մϴ�</p>
                    <a href="${pageContext.request.contextPath}/logout.do" class="button">�α׾ƿ�</a>
              
                <% } %>
    </div>
    
    
  </div>
  <div class="right-side">
    <a href="${pageContext.request.contextPath}/bbs.do" class="button no-link">Q&A�Խ���</a>
   
  </div>
</div>

  <div class="middle-container">
    <div class="menu-button">
      <div class="menu-item">
        <img src="��ǰ.png" alt="��ǰ ������"> <a href="${pageContext.request.contextPath}/productManagement.do">��ǰ����</a>
        
        <p>���°���</p>
      </div>
      <div class="menu-item">
        <img src="Ÿ����.png" alt="Ÿ���� ������"><a href="${pageContext.request.contextPath}/transfer.do">Ÿ���� ���� ����</a>
        <p>������ü</p>
      </div>
      <div class="menu-item">
        <img src="ȸ��.png" alt="ȸ�� ������"><a href="${pageContext.request.contextPath}/ManageUserlist.do">ȸ�� ����</a>
      <p>�ŷ�������ȸ</p>
    </div>
  </div>
</div>

<div class="help-image">
  <img src="����.png" alt="���� ������" width="140" height="98">
  <div class="help-menu">
    <p><a href="${pageContext.request.contextPath}/managerload.do" >ã�ƿ��ô� ��</a></p>
    <p><a href="${pageContext.request.contextPath}/managerbbs.do" > �����ϱ�</a></p>
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