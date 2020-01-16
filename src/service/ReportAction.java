package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Report;
import dao.ReportActionDao;

public class ReportAction {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public ReportAction(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public String reportAdd() {
		HttpSession session= request.getSession();
		String[] info=request.getParameterValues("reportCol");
		//0:신고받은 아이디, 1:글번호, 2:카테고리, 3:내용
	
		Report rt=new Report();
		rt.setName((String)session.getAttribute("id"));
		rt.setId(info[0]);
		rt.setStory_num(Integer.parseInt(info[1]));
		rt.setCategory(info[2]);
		rt.setDetail(info[3]);
		
		ReportActionDao rDao=new ReportActionDao();
		boolean result=rDao.reportCheck(rt);
		if(result) {
			return "이미 신고한 글입니다.";
		}else {
			result=rDao.reportAdd(rt);
			if(result) {
				return "신고에 성공했습니다.";
			}else {
				return "신고에 실패했습니다.";
			}
		}
		
	}

}
