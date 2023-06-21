package kr.ac.kopo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.bbs.BbsDAO;

public class WriteactionController implements Controller {

	@Override
	 public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("euc-kr");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String url = "";
		
        HttpSession session = request.getSession();
        String userID = null;
        boolean isKakaoLoggedIn = false;
        String kakaoID = (String) session.getAttribute("kakaoID");

        if (session.getAttribute("ID") != null) {
            userID = (String) session.getAttribute("ID");
        }

        if (kakaoID != null) {
            isKakaoLoggedIn = true;
            userID = (String) session.getAttribute("kakaoID");
        }

        System.out.println(userID);

       
  
        if (userID == null && !isKakaoLoggedIn) {
            try {
                PrintWriter script = response.getWriter();
                script.println("<script>");
                script.println("alert('로그인을 하세요')");
                script.println("location.href = '/jsp/login/loginForm.jsp'");
                script.println("</script>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
           
        	String bbsTitle = request.getParameter("bbsTitle");
            String bbsContent = request.getParameter("bbsContent");
            
            
            System.out.println(bbsTitle);
            System.out.println(bbsContent);

            if (bbsTitle == null || bbsContent == null) {
                try {
                    PrintWriter script = response.getWriter();
                    script.println("<script>");
                    script.println("alert('입력이 안 된 사항이 있습니다.')");
                    script.println("history.back()");
                    script.println("</script>");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                BbsDAO bbsDAO = new BbsDAO();
                int result = bbsDAO.write(bbsTitle, userID, bbsContent);
                System.out.println(result);
                if (result == -1) {
                    try {
                        PrintWriter script = response.getWriter();
                        script.println("<script>");
                        script.println("alert('글쓰기에 실패했습니다.')");
                        script.println("history.back()");
                        script.println("</script>");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                        url = "/jsp/bbs/bbs.jsp";
                } 
            }
        }

        return url; // 적절한 뷰 페이지를 리턴하도록 수정해야 합니다.
    }

}