package ex2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestTest
 */
@WebServlet("/RequestTest")
public class RequestTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getMethod();
		String query=request.getQueryString();
		String uri=request.getRequestURI();
		String URL=request.getRequestURL().toString();
		
		PrintWriter out =response.getWriter();
		out.println("<h1>Request Test</h1>");
		out.println("method=" + method +"<br/>");
		out.println("query =" + query + "<br/>");
		out.println("uri=" + uri + "<br/>");
		out.println("url="+ URL +"<br/>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
