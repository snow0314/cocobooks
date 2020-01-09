package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Forward;
import dao.ChargeCoinDao;

public class ChargeCoin {
	HttpServletRequest request; 
	HttpServletResponse response;
	public ChargeCoin(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
	public Forward chargeCoin() { //close 할것
		Forward fw= new Forward();
		HttpSession session=request.getSession();
		int coin=Integer.parseInt(request.getParameter("radio")); 
		String id=(String)session.getAttribute("id");
		System.out.println("아이디는"+id);
		System.out.println("선택 코인"+coin);
		ChargeCoinDao cDao=new ChargeCoinDao();
		boolean result=cDao.ChargeCoin(id,coin);
		if (result) {
			fw.setPath("/main");
			fw.setRedirect(false);
		}else {
			fw.setPath("payMent.jsp");
			fw.setRedirect(false);
		}
		return fw;
	}
}
