package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Forward;
import dao.ChargeCoinDao;
import dao.ChargeCoinInsertDao;

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
		cDao.close();
		if (result) {
			ChargeCoinInsertDao ciDao=new ChargeCoinInsertDao();
			boolean insertResult=ciDao.insert(id,coin);
			if(insertResult) {
				System.out.println("충전내역 INSERT성공");
				fw.setPath("/main");
				fw.setRedirect(false);
			}
		}else {
			System.out.println("충전내역 INSERT실패");
			fw.setPath("payMent.jsp");
			fw.setRedirect(false);
		}
		return fw;
	}
}
