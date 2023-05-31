package ex1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletest
 */
@WebServlet("/servletest")
public class servletest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   request.setCharacterEncoding("EUC-KR");
		      response.setContentType("text/html;charset=EUC-KR");
		      PrintWriter out = response.getWriter();
		      
		      out.print("<html>");
		      out.print("<head>");
		      out.print("<title>Servlet Test</title>");
		      out.print("</head>");
		      out.print("<body>");
		      out.print("<h1>Servlet Hello!</h1>");
		      out.print("</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
