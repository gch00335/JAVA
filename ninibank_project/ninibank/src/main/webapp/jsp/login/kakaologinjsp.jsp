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
<!-- īī�� ��ũ��Ʈ -->
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
				            console.log('���ǿ� īī�� ID ���� �Ϸ�');
				            location.href = 'index.jsp';
				            // ���� ������ �Ϸ�Ǿ��� �� index.jsp�� �̵�
				          },
				          error: function(xhr, status, error) {
				            console.log('���ǿ� īī�� ID ���� ����');
				            // ���� �ÿ��� index.jsp�� �̵�
				          
				          }
				        });
					
					var html =  '<br>' + kakaoID;
					
					$('body').append(html);
				}
			});
		}
	});

		     // īī�� �α��� ���� �� ���ǿ� ���� ����
/* 		     $.ajax({
		          url: "/jsp/login/saveKakaoID.jsp",
		          type: 'POST',
		          data: {
		            kakaoID: kakaoID
		          },
		          
		          success: function(response) {
		            console.log('���ǿ� īī�� ID ���� �Ϸ�');
		            
		            // ���� ������ �Ϸ�Ǿ��� �� index.jsp�� �̵�
		            location.href = 'index.jsp';
		          },
		          error: function(xhr, status, error) {
		            console.log('���ǿ� īī�� ID ���� ����');
		            // ���� �ÿ��� index.jsp�� �̵�
		            location.href = 'index.jsp';
		          
		          }
		        });
		      }
		    });
		  },
		  fail: function(err) {
		    alert(JSON.stringify(err));
		    // �α��� ���� �ÿ��� index.jsp�� �̵�
		    location.href = 'index.jsp';
		  }
		}); */


</script>

</body>
</html>