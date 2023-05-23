package ex6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Homework0522
 */
@WebServlet("/Homework0522")
public class Homework0522 extends HttpServlet {
	private static final String FILE_PATH = "C:/Users/User/eclipse-workspace/example1/src/main/java/ex6/IDPW.txt"; // ID와 비밀번호가 저장된 텍스트 파일 경로


    /**
     * @see HttpServlet#HttpServlet()
     */
    public Homework0522() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  // 로그인 페이지 표시 또는 홈 페이지로 리다이렉트 등의 처리
	    response.sendRedirect("/example1/0523HomeWork/Login.jsp");
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
        response.setContentType("text/html;charset=EUC-KR");

        String id = request.getParameter("ID");
        String password = request.getParameter("Password");

        if (checkIDPW(id, password)) {
            // 로그인 성공
              RequestDispatcher dispatcher = request.getRequestDispatcher("/example1/0523HomeWork2/Main.jsp");
              dispatcher.forward(request, response);
        } else {
            // 로그인 실패
       
              RequestDispatcher dispatcher = request.getRequestDispatcher("/example1/0523HomeWork2/Error.jsp");
              dispatcher.forward(request, response);
        }
    }

	    

	    private boolean checkIDPW(String id, String password) throws IOException {
	    	String FILE_PATH = "C:\\Users\\User\\eclipse-workspace\\example1\\src\\main\\java\\ex6\\IDPW.txt";
	    	//BufferedReader 객체를 생성하여 파일을 읽어오기. FileReader를 사용하여 파일 경로(FILE_PATH)를 지정
	        BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
	        String line;
	        //reader.readLine()을 호출하여 파일에서 한 줄씩 읽어와서 반환된 문자열은 line 변수에 저장
	        //while 루프를 사용하여 파일의 모든 줄을 반복적으로 처리. 반복 과정에서 line이 null이 아닌 동안 계속 반복
	        
	        while ((line = reader.readLine()) != null) {
	        	//각 줄을 쉼표(,)로 분리하여 parts 배열에 저장
	            String[] parts = line.split(",");
	            String storedID = parts[0];
	            String storedPassword = parts[1];
	            
	            //추출한 ID(storedID)와 비밀번호(storedPassword)가 입력한 ID와 비밀번호와 일치하는지 비교
	            if (storedID.equals(id) && storedPassword.equals(password)) {
	                reader.close();
	                return true; // 로그인 성공
	            }
	        }
	        reader.close();
	        return false; // 로그인 실패
	    }
	}