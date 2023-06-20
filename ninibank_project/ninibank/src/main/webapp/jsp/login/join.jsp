<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="EUC-KR">
  <title>NINI_BANK</title>
  <!-- jQuery ���̺귯�� -->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <!-- jQuery UI ��Ÿ�Ͻ�Ʈ -->
  <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <!-- jQuery UI ���̺귯�� -->
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
   <!-- ���� �����ȣ API ��ũ��Ʈ -->
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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

    /* Styling for the login form */
    .container {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .login-form {
      width: 500px;
      padding: 20px;
      border: 1px solid #ddd;
      border-radius: 5px;
      background-color: #fff;
      font-family: 'WooridaumB', sans-serif;
    }

    .login-form h3 {
      text-align: center;
      margin-bottom: 20px;
      font-size: 24px;
      color: #000;
    }

    .form-group {
      margin-bottom: 20px;
    }

    .form-control {
      width: 100%;
      height: 40px;
      padding: 6px 12px;
      font-size: 14px;
      color: #555;
      border: 1px solid #ddd;
      border-radius: 4px;
      outline: none;
    }
     .form-control2 {
       width: 70%;;
      height: 40px;
      padding: 6px 12px;
      font-size: 14px;
      color: #555;
      border: 1px solid #ddd;
      border-radius: 4px;
      outline: none;
    }
    .form-control:focus {
      border-color: #008040;
    }

    .btn-primary {
      width: 100%;
      height: 40px;
      background-color: #008040;
      border: none;
      border-radius: 4px;
      color: #fff;
      font-size: 14px;
      font-weight: bold;
      cursor: pointer;
      padding-top: 10px;
      margin-bottom: 20px; /* �߰��� �κ� */
    }

    .btn-primary:hover {
      background-color: #ececec;
    }

    .btn-primary2 {
      width: 100%;
      height: 40px;
      background-color: #ffff00;
      border: none;
      border-radius: 4px;
      color: #000000;
      font-size: 14px;
      font-weight: bold;
      cursor: pointer;
      padding-top: 10px;
      padding-bottom: 10px;
    }

    .btn-primary2:hover {
      background-color:#ececec;
    }
  </style>
</head>
<body>
<div class="container">
  <div class="login-form">
     
   <div class="jumbotron" style="padding-top:20px;">
  <form method="post" action="${pageContext.request.contextPath}/joinprocess.do">
    <h3 style="text-align: center;">ȸ������ȭ��</h3>
    <div class="form-group">
      <input type="text" class="form-control" placeholder="���̵�" name="ID" maxlength="20">
    </div>
    <div class="form-group">
      <input type="password" class="form-control" placeholder="��й�ȣ" name="PASSWORD" maxlength="20">
    </div>
    <div class="form-group">
      <input type="text" class="form-control" placeholder="�̸�" name="name" maxlength="20">
    </div>
    <div class="form-group">
      <input type="email" class="form-control" placeholder="�̸���" name="email" maxlength="20">
      <div id="email-error" style="color: red; display: none;">�ùٸ� �̸��� �������� �Է����ּ���.</div>
    </div>
    <div class="form-group">
      <input type="text" class="form-control" placeholder="��ȭ��ȣ" name="phone" maxlength="50">
    </div>
    <div class="form-group">
      <div style="display: flex;">
        <input type="text" class="form-control" placeholder="�����ȣ ��ȸ" name="post" id="post" maxlength="50">
        <input type="button" class="btn btn-primary2 form-control" value="��ȸ" onclick="openDaumPostcode()">
      </div>
    </div>
    <div class="form-group">
      <div style="display: flex;">
        <input type="text" class="form-control" placeholder="�ּ�" name="addr" id="addr" readonly>
        <input type="text" class="form-control" placeholder="���ּ�" name="DETAILADDRESS" maxlength="100">
      </div>
    </div>
    <div class="form-group">
      <input type="text" class="form-control" placeholder="����" name="Birth" id="birth" readonly>
    </div>
    <input type="submit" class="btn btn-primary form-control" value="ȸ������">
    <input type="button" class="btn btn-primary2" value="īī���� ȸ������" onclick="location.href='${pageContext.request.contextPath}/kakaojoin.do'">
  </form>
</div>
<script>
  $(function() {
    $("#birth").datepicker({
      dateFormat: "yy-mm-dd",
      changeMonth: true,
      changeYear: true,
      yearRange: "1900:2023"
    });
  });

  function openDaumPostcode() {
	  new daum.Postcode({
	    oncomplete: function(data) {
	      // �����ȣ�� �ּ� ������ ������ �� ó���� ���� �ۼ�
	      document.getElementById('post').value = data.zonecode; // �����ȣ �ʵ忡 �����ȣ �� ä���
	      document.getElementById('addr').value = data.address; // �ּ� �ʵ忡 �ּ� �� ä���
	    }
	  }).open();
	}
</script>
</body>
</html>