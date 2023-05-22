

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1st
 */
@WebServlet("/Servlet1st")
public class Servlet1st extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1st() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   PrintWriter out = response.getWriter();
		      out.println("<h1> I am 1st Servlet</h1>");
		      
//		      response.sendRedirect("Servlet2nd"); // http://localhost:8080/example1/Servlet2nd
		      RequestDispatcher rd = request.getRequestDispatcher("Servlet2nd");
		      rd.forward(request, response);  // http://localhost:8080/example1/Servlet1st
// 포워드는 1,2 둘다 안나오고 2만 나오는게 맞음..! 근데 계속 에러인줄알고 ㅠㅠ 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
