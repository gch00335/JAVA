package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
// 응답할려는 JSP를만들어줘야함

	
// 원래 모든 응답과 요청은 dispatcherservlet 에서 실행했으나 너무 길었기때문에 컨트롤러로 분해시킨거임
// 그렇기에 요청과 응답에 대한 결과를 알아야함 *requset, *response
	
//로그인의 .do 가 들어오면 로그인과 관련되어있는 uri는 컨트롤러에 있는  핸드메핑이 수행할거야 이런거임..!
//그래서 인터페이스를 넣어준거임

//즉, 컨트롤러가 중요하고 일을 수행할대 어떤 컨트롤러가 수행되는지가 매우 중요함
//그렇기에 그정보를 기억하는 것이 필요함 -> ***배열 / 리스트 를 쓴다 하지만 이건 같은타입일 경우에만 가능
// 우리는 요청과 응답을 다 저장해야하기 때문에 **MAP이 필요한 것임!!!!!!!!!!!!!!!!!!!! (이걸 안쓰면 배열을 두가지를 이용해야 함)
// 그럼 이 MAP은 어디에 저장될까? ---> 바로 handleMApping 클래스에 있어야함
	String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
