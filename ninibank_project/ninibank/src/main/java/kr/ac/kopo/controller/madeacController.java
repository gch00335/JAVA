package kr.ac.kopo.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.bank.Bank;
import kr.ac.kopo.bank.BankDAO;

public class madeacController implements Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("EUC-KR");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String acc_num = request.getParameter("acc_num");
		String id = request.getParameter("id");
		String bankcode = request.getParameter("bankcode");
		String acpw = request.getParameter("acpw");
		String acmadedate = request.getParameter("acmadedate");
		String productID =request.getParameter("productID");
		String balance = request.getParameter("balance");
		
		Bank vo = new Bank();
		vo.setAcc_num(acc_num);
		vo.setId(id);
		vo.setBankcode(bankcode);
		vo.setAcpw(acpw);
		vo.setAcmadedate(acmadedate);
		vo.setProductID(productID);
		vo.setBalance(balance);

		
		BankDAO dao = new BankDAO();
		dao.insertaccount(vo);
		
		return "/jsp/bank/account.jsp";
	}

}
