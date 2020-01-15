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
		}
		return fw;
	}

	private String makeHtml(List<NovelList> freeList) {
		StringBuilder sb= new StringBuilder();
		sb.append("<tr>");
		for(int i=0;i<freeList.size();i++) {
			System.out.println(freeList.get(i).getTitle());
			
		}
		
		
		sb.append("</tr>");
		return sb.toString();
	}

}
