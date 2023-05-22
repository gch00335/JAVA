package ex4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class QueryServlet
 */
@WebServlet("/QueryServlet2")
public class QueryServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		    response.setContentType("text/html;charset=EUC-KR");
		    
		    PrintWriter out = response.getWriter();
		   
		    // 입력받은 숫자
		    int num1 = Integer.parseInt(request.getParameter("num1"));
		    int num2 = Integer.parseInt(request.getParameter("num2"));
		    
		    // 선택한 연산자 가져오기
		    String operator = request.getParameter("operator");
		    
		 // 연산 결과 계산
		    int result = 0;
		    String operatorName = "";
		    switch (operator) {
		        case "add":
		            result = num1 + num2;
		            operatorName = "+";
		            break;
		        case "subtract":
		            result = num1 - num2;
		            operatorName = "-";
		            break;
		        case "multiply":
		            result = num1 * num2;
		            operatorName = "X";
		            break;
		        case "divide":
		            result = num1 / num2;
		            operatorName = "/";
		            break;
		    }
		    
		    HttpSession session = request.getSession();
	        String calculation = num1 + " " + operatorName + " " + num2 + " = " + result;

	        // 세션에 계산 기록 저장
	        session.setAttribute("calculation", calculation);

	     // 세션에서 계산 기록 가져오기
	        String history = (String) session.getAttribute("history");
		    
		    
		    

	        out.println("<h1>계산기록</h1>");
	        if (history != null) {
	            out.println(history); // 이전 계산 표시
	        }
	        out.println("<p>" + calculation + "</p>");

	        // 계산 기록 업데이트
	        if (history != null) {
	            history += "<br>" + calculation; // 새로운 계산 추가
	        } else {
	            history = calculation;  // 새로운 기록 시작
	        }
	        session.setAttribute("history", history);

		    
		
		    out.println("<form method='post' action='QueryServlet2'>"); // POST
			
		    // 결과 출력
		    out.println("<h1>계산결과</h1>");
		    out.println("<p>첫번째 숫자: " + num1 + "</p>");
		    out.println("<p>두번째 숫자" + num2 + "</p>");
		    out.println("<p>연산자: " + operatorName + "</p>");
		    out.println("<p>결과: " + result + "</p>");
		    
		  
		   out.println("</form>");
		   
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼에서 POST로 요청이 오면 
		// request값에서 name 하고 value를 추출해내는 것 
				String num1 = request.getParameter("num1");
				String num2 = request.getParameter("num2");
				
				 HttpSession session = request.getSession();
			        session.setAttribute("num1", num1);
			        session.setAttribute("num2", num2);

				
			     // 서블릿을 doGet을 리다이렉션 하는 것 ..?  이게 없어도 되는건가?
			//	response.sendRedirect("QueryServlet2");
	}

}
