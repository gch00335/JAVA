package controller.board;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.board.BoardDAO;
import biz.board.BoardVO;
import biz.user.UserDAO;
import biz.user.UserVO;
import controller.Controller;

public class InsertBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse respnse) {
		 String title = request.getParameter("title");
		 String writer = request.getParameter("writer");
		 String content = request.getParameter("content");
		// Date regDate = request.getParameter("RegDate");
		 
		 BoardVO vo = new BoardVO();
		 vo.setTitle(title);
		 vo.setWriter(writer);
		 vo.setContent(content);
		 //vo.setRegDate(regDate);
		 
		 BoardDAO dao = new  BoardDAO();
		 dao.insertBoard(vo);
		 
		 return "board.html";
		 
		
	}

	 
}

