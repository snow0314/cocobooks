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
		int coin=pDao.coinCheck(id); //해당 아이디의 코인수를 가져온다
		boolean result=false;
		
		if(coin>(purchase.length+1)*100) {
			result=pDao.buynovel(id,purchase);
			pDao.coinDown(id,coin-((purchase.length+1)*100));
		}else {
			return "코인이 부족합니다.";
		}
		
	
		if(result) {
			return "구매 성공";
		}else {
			return "구매 실패";
		}
		
	}

}
