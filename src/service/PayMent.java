package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Forward;
import dao.ChargeCoinDao;

public class PayMent {//이건 chargeCoin에 따로 기술 요 url은 payment 창으로 이동만함 
	HttpServletRequest request; 
	HttpServletResponse response;
	public PayMent(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
	public Forward chargeCoin() { //close 할것
		Forward fw= new Forward();
		HttpSession session=request.getSession();
		int coin=Integer.parseInt(request.getParameter("coin")); 
		String id=(String)session.getAttribute("id");
		ChargeCoinDao cDao=new ChargeCoinDao();
		boolean result=cDao.ChargeCoin(id,coin);
		if (result) {
			//코인이 실시간으로 안보일경우 여기서 코인 담아가서 뿌려줘야함
			fw.setPath("main.jsp");
			fw.setRedirect(false);
		}else {
			fw.setPath("");
		}
		return fw;
	}
	
}
