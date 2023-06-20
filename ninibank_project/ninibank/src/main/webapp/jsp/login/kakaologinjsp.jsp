<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<!-- 카카오 스크립트 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type='text/javascript'>
	Kakao.init("de96ea9907105d48c718141df51ad937");

	Kakao.Auth.login({
		success: function(authObj) {
			console.log(authObj);
			var token = authObj.access_token;

			Kakao.API.request({
				url: '/v2/user/me',
				success: function(res) {
					console.log(res);
					
					
					var kakaoID = res.properties.nickname;
				
					console.log(kakaoID);
					
					  $.ajax({
				          url: "${pageContext.request.contextPath}/kakaojoin.do",
				          type: 'get',
				          data: {
				            kakaoID: kakaoID
				            
				          },
				          
				          success: function(response) {
				            console.log('세션에 카카오 ID 저장 완료');
				            location.href = 'index.jsp';
				            // 세션 저장이 완료되었을 때 index.jsp로 이동
				          },
				          error: function(xhr, status, error) {
				            console.log('세션에 카카오 ID 저장 실패');
				            // 실패 시에도 index.jsp로 이동
				          
				          }
				        });
					
					var html =  '<br>' + kakaoID;
					
					$('body').append(html);
				}
			});
		}
	});

		     // 카카오 로그인 성공 시 세션에 값을 저장
/* 		     $.ajax({
		          url: "/jsp/login/saveKakaoID.jsp",
		          type: 'POST',
		          data: {
		            kakaoID: kakaoID
		          },
		          
		          success: function(response) {
		            console.log('세션에 카카오 ID 저장 완료');
		            
		            // 세션 저장이 완료되었을 때 index.jsp로 이동
		            location.href = 'index.jsp';
		          },
		          error: function(xhr, status, error) {
		            console.log('세션에 카카오 ID 저장 실패');
		            // 실패 시에도 index.jsp로 이동
		            location.href = 'index.jsp';
		          
		          }
		        });
		      }
		    });
		  },
		  fail: function(err) {
		    alert(JSON.stringify(err));
		    // 로그인 실패 시에도 index.jsp로 이동
		    location.href = 'index.jsp';
		  }
		}); */


</script>

</body>
</html>