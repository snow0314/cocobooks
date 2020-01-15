package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Forward;
import bean.NovelList;
import dao.BestListDao;

public class BestPayWebNovel {

	HttpServletRequest request;
	HttpServletResponse response;
	public BestPayWebNovel(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
	public Forward freeWeblist() {
		Forward fw= new Forward();
		BestListDao bDao= new BestListDao();
		List<NovelList> payList=bDao.payList();
		if(payList!=null&&payList.size()!=0) {
			request.setAttribute("list", makeHtml(payList));
			fw.setPath("bestPayNovel.jsp");
			fw.setRedirect(false);
		}
		return fw;
	}
	private String makeHtml(List<NovelList> payList) {
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<payList.size();i++) {
			sb.append("<tr>");
			sb.append("<td>"+payList.get(i).getNum()+"</td>");
			sb.append("<td><a href='noveldetail?novelNum="+payList.get(i).getNum()+"'>"+payList.get(i).getTitle()+"</a></td>");
			sb.append("<td>"+payList.get(i).getId()+"</td>");
			sb.append("<td>"+payList.get(i).getTotalView()+"</td>");
			sb.append("</tr>");
		}
		return sb.toString();
	}
}
