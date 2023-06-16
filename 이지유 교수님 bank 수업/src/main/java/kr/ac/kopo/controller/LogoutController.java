package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutController implements Controller {

   @Override
   public  String handleRequest(HttpServletRequest request, HttpServletResponse response) {

     System.out.println("LogoutController handleRequest() 호출..");
      
	  return "/jsp/login/logout.jsp"; 
   //bank 뒤에 있는 슬러시 / 임
   }
   
}