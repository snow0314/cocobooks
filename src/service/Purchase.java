package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PurchaseDao;

public class Purchase {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public Purchase(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public String buynovel() {
		PurchaseDao pDao=new PurchaseDao();
		String[] purchase=request.getParameterValues("purchase");
		HttpSession session= request.getSession();
		String id=(String)session.getAttribute("id");
		
		boolean result=pDao.buynovel(id,purchase);
		
		if(result) {
			return "구매 성공";
		}else {
			return "구매 실패";
		}
		
	}

}
