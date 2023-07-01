package kr.ac.kopo.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OpentransferController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
		return "/jsp/openbank/opentransfer.jsp";
	}
	

}
