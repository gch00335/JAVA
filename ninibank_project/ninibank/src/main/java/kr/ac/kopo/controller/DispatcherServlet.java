package kr.ac.kopo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DispatcherServlet extends HttpServlet{

	private HandlerMapping mappings;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		String propLoc = config.getInitParameter("propLoc");
		System.out.println(propLoc);
		
		mappings = new HandlerMapping(propLoc);
		
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// CORS 정책 설정
//        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");

		
		String uri= request.getRequestURI();
		
		System.out.println("uri : "+ uri);
		uri = uri.substring(request.getContextPath().length());
		
		
		Controller ctrl = mappings.getController(uri);
		String callPage = ctrl.handleRequest(request, response);
		
		
		
		
		
		if(callPage.startsWith("redirect:" )) {
			
			response.sendRedirect(callPage.substring("redirect:".length()));
			// 리다이렉트 슬래시 bank 가 날라오니까 리다이렉트를 제외해주는 거임 
			
		} else {
		//리퀘스트디스패치네????뭐라구요??영어어려워요 ㅠㅠ
		RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
		// 포워드가 떠넘기는거니까 내가 해야할일을 주는데 이것을 리퀘스트에게..!!
		// 즉, 요청과 응답을 위해서는 무조권 리퀘스트 리폰서가 있어야 함 
		dispatcher.forward(request, response);
		
		
		//System.out.println("jsp : " + callPage);
		
			
		// 하지만 매핑은 innit에 있기때문에 멤버변수로 받아줘야함
		// 묵시적 형변화을 해서 컨트롤러가 날아오는 것
		// 저 날아온거에 알맞는 컨트롤러에서 실행이 되고 그 다음은 핸들링케스트에서 실행 
		
		}
	}
}