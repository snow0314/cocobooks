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
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<td>순위</td>");
		sb.append("<td>작품 번호</td>");
		sb.append("<td>작품 제목</td>");
		sb.append("<td>작가 </td>");
		sb.append("<td>총 조회수</td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td>");
		sb.append("<img src='image/g1.png'>");	
		sb.append("</td>");
		sb.append("<td>"+freeList.get(0).getNum()+"</td>");
		sb.append("<td><a href='noveldetail?novelNum="+freeList.get(0).getNum()+"'>"+freeList.get(0).getTitle()+"</a></td>");
		sb.append("<td>"+freeList.get(0).getId()+"</td>");
		sb.append("<td>"+freeList.get(0).getTotalView()+"</td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td>");
		sb.append("<img src='image/s2.png'>");
		sb.append("</td>");
		sb.append("<td>"+freeList.get(1).getNum()+"</td>");
		sb.append("<td><a href='noveldetail?novelNum="+freeList.get(1).getNum()+"'>"+freeList.get(1).getTitle()+"</a></td>");
		sb.append("<td>"+freeList.get(1).getId()+"</td>");
		sb.append("<td>"+freeList.get(1).getTotalView()+"</td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td>");
		sb.append("<img src='image/b3.png'>");	
		sb.append("</td>");
		sb.append("<td>"+freeList.get(2).getNum()+"</td>");
		sb.append("<td><a href='noveldetail?novelNum="+freeList.get(2).getNum()+"'>"+freeList.get(2).getTitle()+"</a></td>");
		sb.append("<td>"+freeList.get(2).getId()+"</td>");
		sb.append("<td>"+freeList.get(2).getTotalView()+"</td>");
		sb.append("</tr>");
		for(int i=3;i<freeList.size();i++) {
			sb.append("<tr>");
			sb.append("<td>"+(i+1)+"</td>");
			sb.append("<td>"+freeList.get(i).getNum()+"</td>");
			sb.append("<td><a href='noveldetail?novelNum="+freeList.get(i).getNum()+"'>"+freeList.get(i).getTitle()+"</a></td>");
			sb.append("<td>"+freeList.get(i).getId()+"</td>");
			sb.append("<td>"+freeList.get(i).getTotalView()+"</td>");
			sb.append("</tr>");
			if(i==9) {
				break;
			}
		}
		sb.append("<table>");
		return sb.toString();
	}

}
