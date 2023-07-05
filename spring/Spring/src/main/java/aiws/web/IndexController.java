package aiws.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kr.ac.kopo.bbs.Bbs;
import kr.ac.kopo.bbs.BbsDAO;

public class IndexController implements Controller {


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BbsDAO boardDAO = new BbsDAO();
		List<Bbs> boardList = boardDAO.getBoardList();

		System.out.println(boardList);
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardList", boardList);
		mv.setViewName("index");
		
		return mv;
	}

}