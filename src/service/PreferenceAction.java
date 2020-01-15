package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PreferenceActionDao;

public class PreferenceAction {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public PreferenceAction(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public String preferenceAdd() {
		HttpSession session= request.getSession();
		PreferenceActionDao paDao=new PreferenceActionDao();
		String id=(String)session.getAttribute("id");
		int num=Integer.parseInt(request.getParameter("Novel_num"));
		
		boolean result=paDao.preferenceCheck(id,num);
		if(result) {
			result=paDao.preferenceAdd(id,num);
		}

		if(result) {
			return "등록 성공했습니다.";
		}else {
			return "이미 등록된 작품입니다.";
		}
		
	}
	


}
