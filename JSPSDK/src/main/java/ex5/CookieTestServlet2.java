package ex5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CokeeServlet2
 */
@WebServlet("/CokeeServlet2")
public class CookieTestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieTestServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//입력, 출력 인코딩 디코딩 문자셋 설정
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=EUC-KR");
		
		// 출력 HTML 파일 만들기 ,  out인스턴스 생성
		PrintWriter out = response.getWriter();
		
		
		// 브라우저로부터 쿠키 가져오기		
		Cookie[] cookies = request.getCookies();
		
		// 시작이 될때 쿠키가 있는지 없는지 확인하고 
		if(cookies != null) {
			// 쿠키가 있으면 값을 확인해라라는 뜻
			for(Cookie cookie : cookies) {
				//출력
				out.println("cookie :"+cookie.getName()+":"+cookie.getValue()+"<br/>");
				
			}
		}
		// name과 value 읿력받는 HTML 폼 생성
		out.println("<form method='post' action='CokeeServlet2'>"); // POST타입으로 제출 
		out.println("name<input type='text' name='name'/>");
		out.println("value<input type='text' name='value'/>");
		out.println("<input type='submit'/>");
		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼에서 POST로 요청이 오면 
		// request값에서 name 하고 value를 추출해내는 것 
		String name = request.getParameter("name");
		String value = request.getParameter("value");
		 
		// 추출해낸 것을 쿠키로 저장 
				Cookie c = new Cookie(name, value);
		response.addCookie(c);
		
		// 서블릿을 doGet을 리다이렉션 하는 것 
		response.sendRedirect("CokeeServlet2");
	}

}
