<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<style>
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
	width: 100%; /* ����: ���� ���̸� 100%�� ���� */
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 3px;
	box-sizing: border-box; /* ����: ���� ũ�⸦ �ڽ� �𵨿� ���� */
	margin-top: 20px; /* �߰�: �Է�â ������ ������ ���� */
	margin-bottom: 10px; /* �߰�: �Է�â ������ ������ ���� */
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
	font-family: Arial, sans-serif; /* ��Ʈ ���� */
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
</style>

  <meta charset="EUC-KR">
    <title>��ǰ ����</title>
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
  
	<div class="container">
		<div class="row">
			<div class="col-md-6 mx-auto">
				<div class="input-form-background">
					<h4 class="mb-33">���»���</h4>
					<form class="validation-form" method="post"
						action="${pageContext.request.contextPath}/madeac.do">

						<div class="mb-3">
						
							<label for="idname">���»�ǰ</label>
						
							  <form action="createAccountProcess.jsp" method="post">
       					
       						 <label for="productID">����:</label>
        					 <select id="productID" name="productID" class="form-control">
         				  	 <%-- ��ǰ ����� ��ȸ�Ͽ� �ɼ����� ǥ�� --%>
          	 	 <%	
         		// DB ���� ����
          	 	 String url = "jdbc:oracle:thin:@localhost:1521:xe";
          		  String username = "hr";
           		 String password = "hr";
           		 
                // DB ����
                Connection conn = null;
                PreparedStatement pstmt = null;
                ResultSet rs = null;
                try {
                    // JDBC ����̹� �ε�
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    
                    // DB ����
                    conn = DriverManager.getConnection(url, username, password);
                    
                    // SQL ���� ����
                    String sql = "SELECT * FROM account_products";
                    pstmt = conn.prepareStatement(sql);
                    rs = pstmt.executeQuery();
                    
                    // ��ǰ ����� �ɼ����� ǥ��
                    while (rs.next()) {
                        int productID = rs.getInt("productID");
                        String productName = rs.getString("productName");
                        out.println("<option value='" + productName + "'>" + productName + "</option>");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // ���ҽ� ����
                    if (rs != null) {
                        try {
                            rs.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    if (pstmt != null) {
                        try {
                            pstmt.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    if (conn != null) {
                        try {
                            conn.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            %>
        </select><br>
        <br><br>
						<div class="mb-3">
							<label for="name">�Ա� �ݾ�</label> <input type="text"
								class="form-control" id="balance" name="balance" placeholder="�Ա� �ݾ�"
								required>
							<div class="invalid-feedback">ù ���� ���� �� 10000�� �̻���� �Աݰ����մϴ�.</div>
						</div>
						
					</div>	
					<div class="mb-3">
							<label for="idname">���¹�ȣ</label>
							 <input type="text"
								class="form-control" id = "acc_num"
								name="acc_num" placeholder="���¹�ȣ�� �����ϼ���" value="" required> <a
								class="invalid-feedback">���¹�ȣ�� �������ּ���.</a>
							<button type="button" onclick="generateAccountNumber()"
								class="btn btn-primary generate-button">���¹�ȣ ����</button>
						</div>

						<div class="row">
							<div class="col-md-6 mb-3">
								<label for="pw">����� ���̵�</label> 
								<input type="text"
									class="form-control" id="id" name="id" value="<%= userID %>"
									readonly>
								<div class="invalid-feedback"></div>
							</div>
						</div>

						<div class="col-md-6 mb-3">
							<label for="pw">�����ڵ�</label> <input type="text"
								class="form-control" id="bankcode" name="bankcode"
								placeholder="" value=""> <a class="invalid-feedback">�����ڵ带
								�������ּ���.</a>
							<button type="button" onclick="getbankcodeNumber()"
								class="btn btn-primary generate-button">�����ڵ� ����</button>
						</div>
						<div class="mb-3">
							<label for="name">���� ��й�ȣ</label> <input type="text"
								class="form-control" id="acpw" name="acpw" placeholder="���� 4�ڸ�"
								required>
							<div class="invalid-feedback">���� ��й�ȣ 4�ڸ��� �Է����ּ���.</div>
						</div>
						
						
						
						
						<div class="mb-3">
  						<label for="name">���°�����</label>
  						<input type="date" class="form-control" id="acmadedate" name="acmadedate" value="<%= java.time.LocalDate.now() %>" required  readonly>
						</div>
						<hr class="mb-4">
						<div class="custom-control custom-checkbox">
							<input type="checkbox" class="custom-control-input"
								id="agreement" required> <label
								class="custom-control-label" for="agreement">�������� ���� ��
								�̿뿡 �����մϴ�.</label>
						</div>
						<br> <br>
						<div class="mb-4"></div>
						<button class="btn btn-primary btn-lg" type="submit"
							style="display: block; margin: 0 auto; width: 100%; font-size: 20px;">����
							����</button>
					</form>
					<br> <br> <br> <br> <br> <br> <br>
					<br> <br> <br>
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	function generateAccountNumber() {
		var accountNumber = "";
		var digits = "0123456789";

		for (var i = 0; i < 13; i++) {
			accountNumber += digits.charAt(Math.floor(Math.random()
					* digits.length));
		}

		document.getElementById("acc_num").value = accountNumber;
	}
	
	function getbankcodeNumber() {
		var bankcode = "";
		var digits = "0123456789ABCDEF";

		for (var i = 0; i < 8; i++) {
			bankcode += digits
					.charAt(Math.floor(Math.random() * digits.length));
		}

		document.getElementById("bankcode").value = bankcode;
	}
	
	function showCompletionMessage() {
		alert("���� ������ �Ϸ�Ǿ����ϴ�!");
	}

	// �� ���� �ÿ� ���� ���� �Ϸ� �˸�â�� ��쵵�� ����
	document.querySelector('.validation-form').addEventListener('submit', showCompletionMessage);
</script>
</html>