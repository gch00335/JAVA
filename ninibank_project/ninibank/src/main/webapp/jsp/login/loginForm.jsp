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
    width: 300px;
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
    background-color: #ececec;
  }
</style>
<meta charset="EUC-KR">
<title>NINI_BANK</title>
</head>
<body>
<div class="container">
  <div class="login-form">
    <h3>로그인 화면</h3>
	<form action="${ pageContext.request.contextPath }/loginprocess.do">
	 <div class="form-group">
        <input type="text" class="form-control" placeholder="아이디" name="ID" maxlength="20">
      </div>
      <div class="form-group">
        <input type="password" class="form-control" placeholder="비밀번호" name="PASSWORD" maxlength="20">
      </div>
      <input type="submit" class="btn btn-primary" value="로그인">
	</form>
	<form action="${pageContext.request.contextPath}/kakaologin.do" method="GET">
  <input type="submit" class="btn btn-primary2" value="카카오톡 로그인">
</form>
</body>


</html>

