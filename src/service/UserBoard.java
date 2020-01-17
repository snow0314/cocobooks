package service;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Forward;
import dao.UserBoardDao;


public class UserBoard {
	
	HttpServletRequest request;
	HttpServletResponse response;
	
	public UserBoard() {
	}

	public UserBoard(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public Forward userWrite() {
		Forward fw= new Forward();
		fw.setPath("userboard.jsp");
		fw.setRedirect(true);
	   return fw;

	}
	
	public Forward userView() {
		Forward fw= new Forward();
		UserBoardDao dao= new UserBoardDao(); 
		List<bean.UserBoard> list=new ArrayList<bean.UserBoard>();
		list=dao.userview();
		request.setAttribute("boardlist",makehtml(list));
		fw.setPath("userboard.jsp");
		fw.setRedirect(false);
		return fw;
	}

	private Object makehtml(List<bean.UserBoard> list) {
		StringBuilder sb= new StringBuilder();
		sb.append("<table class='table table-hover'>");
		sb.append("<tr>");
		sb.append("<td>글 번호</td>");
		sb.append("<td>글쓴이</td>");
		sb.append("<td>제목</td>");
		sb.append("<td>날짜</td>");
		sb.append("<td>조회수</td>");
		sb.append("</tr>");
		for(int i=0 ;i<list.size();i++) {
			sb.append("<tr>");
			sb.append("<td>"+list.get(i).getUB_NUM()+"</td>");
			sb.append("<td>"+list.get(i).getUB_ID()+"</td>");
			sb.append("<td>"+list.get(i).getUB_TITLE()+"</td>");
			sb.append("<td>"+list.get(i).getUB_DATE()+"</td>");
			sb.append("<td>"+list.get(i).getUB_VIEW()+"</td>");
			sb.append("</tr>");
		
			
	}
		sb.append("</table>");

		return sb.toString();
		
			
	}

}

