package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Forward;
import bean.NovelList;
import dao.BestListDao;

public class BestFreeWebNovel {
	
	HttpServletRequest request;
	HttpServletResponse response;
	public BestFreeWebNovel(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public Forward freeWeblist() {
		Forward fw= new Forward();
		BestListDao bDao= new BestListDao();
		List<NovelList> freeList=bDao.freeList();
		if(freeList!=null&&freeList.size()!=0) {
			request.setAttribute("list", makeHtml(freeList));
			fw.setPath("bestFreeNovel.jsp");
			fw.setRedirect(false);
		}
		return fw;
	}

	private String makeHtml(List<NovelList> freeList) {
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<freeList.size();i++) {
			sb.append("<tr>");
			sb.append("<td>"+freeList.get(i).getNum()+"</td>");
			sb.append("<td><a href='noveldetail?novelNum="+freeList.get(i).getNum()+"'>"+freeList.get(i).getTitle()+"</a></td>");
			sb.append("<td>"+freeList.get(i).getId()+"</td>");
			sb.append("<td>"+freeList.get(i).getTotalView()+"</td>");
			sb.append("</tr>");
		}
		return sb.toString();
	}

}
