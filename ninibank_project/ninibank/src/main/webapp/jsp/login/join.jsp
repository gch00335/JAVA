<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="EUC-KR">
  <title>NINI_BANK</title>
  <!-- jQuery 라이브러리 -->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <!-- jQuery UI 스타일시트 -->
  <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <!-- jQuery UI 라이브러리 -->
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
   <!-- 다음 우편번호 API 스크립트 -->
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
      src: url('https://example.com/path-to/WooridaumB.woff2') format('woff2'); /* 폰트 파일의 실제 URL로 변경 */
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
      margin-bottom: 20px; /* 추가된 부분 */
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
    <h3 style="text-align: center;">회원가입화면</h3>
    <div class="form-group">
      <input type="text" class="form-control" placeholder="아이디" name="ID" maxlength="20">
    </div>
    <div class="form-group">
      <input type="password" class="form-control" placeholder="비밀번호" name="PASSWORD" maxlength="20">
    </div>
    <div class="form-group">
      <input type="text" class="form-control" placeholder="이름" name="name" maxlength="20">
    </div>
    <div class="form-group">
      <input type="email" class="form-control" placeholder="이메일" name="email" maxlength="20">
      <div id="email-error" style="color: red; display: none;">올바른 이메일 형식으로 입력해주세요.</div>
    </div>
    <div class="form-group">
      <input type="text" class="form-control" placeholder="전화번호" name="phone" maxlength="50">
    </div>
    <div class="form-group">
      <div style="display: flex;">
        <input type="text" class="form-control" placeholder="우편번호 조회" name="post" id="post" maxlength="50">
        <input type="button" class="btn btn-primary2 form-control" value="조회" onclick="openDaumPostcode()">
      </div>
    </div>
    <div class="form-group">
      <div style="display: flex;">
        <input type="text" class="form-control" placeholder="주소" name="addr" id="addr" readonly>
        <input type="text" class="form-control" placeholder="상세주소" name="DETAILADDRESS" maxlength="100">
      </div>
    </div>
    <div class="form-group">
      <input type="text" class="form-control" placeholder="생일" name="Birth" id="birth" readonly>
    </div>
    <input type="submit" class="btn btn-primary form-control" value="회원가입">
    <input type="button" class="btn btn-primary2" value="카카오톡 회원가입" onclick="location.href='${pageContext.request.contextPath}/kakaojoin.do'">
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
	      // 우편번호와 주소 정보를 가져온 후 처리할 로직 작성
	      document.getElementById('post').value = data.zonecode; // 우편번호 필드에 우편번호 값 채우기
	      document.getElementById('addr').value = data.address; // 주소 필드에 주소 값 채우기
	    }
	  }).open();
	}
</script>
</body>
</html>