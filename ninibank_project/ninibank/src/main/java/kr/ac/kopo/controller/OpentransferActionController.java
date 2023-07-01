package kr.ac.kopo.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.bank.BankDAO;
import kr.ac.kopo.transactionHistory.TransactionHistory;
import kr.ac.kopo.user.User;

public class OpentransferActionController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		 try {
		        request.setCharacterEncoding("UTF-8");
		    } catch (UnsupportedEncodingException e) {
		    }
		
		
		 String bankName = request.getParameter("bank");
		    String bankCode = "";

		    if (bankName.equals("NINI_bank")) {
		        bankCode = "333";
		    } else if (bankName.equals("NA_BANK")) {
		        bankCode = "999";
		    } else if (bankName.equals("YJ_BANK")) {
		        bankCode = "777";
		    }

		    String bankName2 = request.getParameter("bank2");
		    String bankCode2 = "";

		    if (bankName2.equals("NINI_bank")) {
		        bankCode2 = "333";
		    } else if (bankName.equals("NA_BANK")) {
		        bankCode = "999";
		    } else if (bankName.equals("YJ_BANK")) {
		        bankCode2 = "777";
		    }

		 
			
			String fromAccount = request.getParameter("fromAccount");
		      String bank_code = request.getParameter("bank_code");
		      String toAccount = request.getParameter("toAccount");
		      Long trans_amount = Long.parseLong(request.getParameter("amount"));
		      String fromName = request.getParameter("senderName");
		      String toName = request.getParameter("recipientName");
		      
		      HttpSession session = request.getSession();
		        User user = (User) session.getAttribute("user");
		        
		        TransactionHistory transD = new TransactionHistory();
		        transD.setBankCode(bank_code);
		        transD.setTransactionId(toAccount);
		        transD.setTransactionDate(new Date());
		        transD.setTransactionType("D");
		        transD.setAmount(trans_amount);
		        transD.setAccountNumber(fromAccount);
		        transD.setSenderName(fromName);
		        transD.setRecipientName(toName);
		        transD.setBankCode(bankCode2);
		        
		        TransactionHistory transW = new TransactionHistory();
		        transW.setBankCode("");
		        transW.setSenderName(fromName);
		        transW.setRecipientName(toName);
		        transW.setTransactionDate(new Date());
		        transW.setTransactionType("W");
		        transW.setAmount(trans_amount);
		        transW.setTransactionId(fromAccount);
		        transW.setAccountNumber(toAccount);
		        transW.setBankCode(bankCode);
		        
		        
		        int result = new BankDAO().Transaction2(transD, transW);
		        
		    String msg = "";
		    if (result == 1) {
		        msg = "계좌 이체 성공";
		        request.setAttribute("msg", msg);
		        request.setAttribute("url", "account.do");
		        return "/jsp/bank/account.jsp";
		    } else {
		        msg = "계좌 이체에 실패했습니다. 관리자에게 문의해 주세요.";
		        request.setAttribute("msg", msg);
		        request.setAttribute("url", "account.do");
		    }
		    return "/jsp/openbank/account.jsp";
		}
}