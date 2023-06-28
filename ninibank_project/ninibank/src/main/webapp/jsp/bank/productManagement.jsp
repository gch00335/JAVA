<%@page import="kr.ac.kopo.product.Product"%>
<%@page import="kr.ac.kopo.bank.BankDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.List" %>
<%@ page import="kr.ac.kopo.bank.BankDAO" %>
<%
    // BankDAO �ν��Ͻ� ����
    BankDAO bankDAO = new BankDAO();
    
    // ��ǰ ��� ��ȸ
    List<Product> accountProducts = bankDAO.getAllAccountProducts();
%>
<meta charset="EUC-KR">
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
  src: url('https://example.com/path-to/WooridaumB.woff2') format('woff2'); /* ��Ʈ ������ ���� URL�� ���� */
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
  background-color:  #ffffff;
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
.col-auto {
  position: absolute;
  top: 350px;
  left: 450px;
  margin-top: 10px; /* �ʿ��� ��� ���� ���� */
}

.container2{
 position: absolute;
  top: 350px;
  left: 450px;
  width: 1000px; /* Adjust the width as desired */
  margin-top: 10px; /* �ʿ��� ��� ���� ���� */
}
</style>
    <title>��ǰ ����</title>
</head>
<body>
<%   

	String userID = null;
	if (session.getAttribute("ID") != null){
		userID = (String) session.getAttribute("ID");
	}	    // īī���� �α��� Ȯ��

 	
	
%>


  <% if (userID == null) { %>
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
  <% } else { %>
   <div class="top-container">
  <div class="left-side">
  <a href="/bank/index.jsp">
  <img src="�ϴ���Ϸΰ�.png" alt="�ΰ�" class="logo">
</a>
   
 <h3> ���°��� </h3><br>
    <div class="button-group">
      <h4><span class="main-page"> MY�޴� </span></h4>
		<h4><span class="sub-page"> > ���°��� </span></h4>
   
    </div>
  </div>
  <div class="right-side">
  <div class="button-group">
     <a href="${pageContext.request.contextPath}/bbs.do" class="button">Q&A�Խ���</button>
    <button class="button"> MYPAGE </button>
     <a href="${pageContext.request.contextPath}/logout.do" class="button">�α׾ƿ�</a></button>
 			 <div class="dropdown">
  				  <button class="button"> MY���� </button>
    <ul class="dropdown-menu">
   		<li><a href="${pageContext.request.contextPath}/account.do">���°���</a></li>
        <li><a href="logoutAction.jsp">���¹�ŷ����</a></li>
        <li><a href="mypage.jsp">�ŷ�������ȸ</a></li>
        <li><a href="logoutAction.jsp">������ü</a></li>
    </ul>
    </li>
       </div>
  </div>
</div>
  <% } %>
</ul>



  
  
  
  
  	<div class="customer-service">
  <h2>MY ����</h2><br><br>
  <p style="margin-left: 100px;"><a href="${pageContext.request.contextPath}/account.do">���°���</a></p>
  <p><a href="${pageContext.request.contextPath}/load.do">���¹�ŷ����</a></p>
  <p><a href="${pageContext.request.contextPath}/detalle.do">�ŷ�������ȸ</p>
  <p><a href="${pageContext.request.contextPath}/transfer.do">������ü</a></p>
</div>
 


  <div class="container2">
    <h1>��ǰ ����</h1>
    
    <table border="1">
        <tr>
            <th>��ǰ ID</th>
            <th>��ǰ��</th>
            <th>������</th>
            <th>�ּ��ܾ�</th>
        </tr>
        <% for (Product accountProduct : accountProducts) { %>
        <tr>
            <td><%= accountProduct.getProductID() %></td>
            <td><%= accountProduct.getProductName() %></td>
            <td><%= accountProduct.getInterestRate() %></td>
            <td><%= accountProduct.getMinimumBalance() %></td>
        </tr>
        <% } %>
    </table>
    
    <br>
    <a href="addProduct.jsp">��ǰ �߰�</a>
    <br>
    <a href="deleteProduct.jsp">��ǰ ����</a>
</body>
</html>