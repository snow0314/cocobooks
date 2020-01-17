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
		sb.append("<td>"+payList.get(0).getNum()+"</td>");
		sb.append("<td><a href='noveldetail?novelNum="+payList.get(0).getNum()+"'>"+payList.get(0).getTitle()+"</a></td>");
		sb.append("<td>"+payList.get(0).getId()+"</td>");
		sb.append("<td>"+payList.get(0).getTotalView()+"</td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td>");
		sb.append("<img src='image/s2.png'>");
		sb.append("</td>");
		sb.append("<td>"+payList.get(1).getNum()+"</td>");
		sb.append("<td><a href='noveldetail?novelNum="+payList.get(1).getNum()+"'>"+payList.get(1).getTitle()+"</a></td>");
		sb.append("<td>"+payList.get(1).getId()+"</td>");
		sb.append("<td>"+payList.get(1).getTotalView()+"</td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td>");
		sb.append("<img src='image/b3.png'>");	
		sb.append("</td>");
		sb.append("<td>"+payList.get(2).getNum()+"</td>");
		sb.append("<td><a href='noveldetail?novelNum="+payList.get(2).getNum()+"'>"+payList.get(2).getTitle()+"</a></td>");
		sb.append("<td>"+payList.get(2).getId()+"</td>");
		sb.append("<td>"+payList.get(2).getTotalView()+"</td>");
		sb.append("</tr>");
		for(int i=3;i<payList.size();i++) {
			sb.append("<tr>");
			sb.append("<td>"+(i+1)+"</td>");
			sb.append("<td>"+payList.get(i).getNum()+"</td>");
			sb.append("<td><a href='noveldetail?novelNum="+payList.get(i).getNum()+"'>"+payList.get(i).getTitle()+"</a></td>");
			sb.append("<td>"+payList.get(i).getId()+"</td>");
			sb.append("<td>"+payList.get(i).getTotalView()+"</td>");
			sb.append("</tr>");
			if(i==9) {
				break;
			}
		}
		sb.append("<table>");
		return sb.toString();
	}
}
