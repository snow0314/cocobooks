package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.FaideWebFictionBean;
import bean.Forward;
import dao.FaideWebFictionDao;
import dao.FreeWebFictionDao;

public class FreeWebFiction {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public FreeWebFiction(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public Forward move() {
		Forward fw= new Forward();
		HttpSession session= request.getSession();
		String id=(String) session.getAttribute("id");
		System.out.println(id);
		if(id==null) {
			request.setAttribute("login", "로그인후 이용해주세요");
			fw.setPath("main.jsp");
			fw.setRedirect(false);
			return fw;
		}
		List<FaideWebFictionBean> fwfList=null;
		
		FreeWebFictionDao fDao=new FreeWebFictionDao();
		fwfList=fDao.freeWebFictionList();
		if(fwfList!=null&&fwfList.size()!=0) {
			System.out.println(fwfList);
			request.setAttribute("list",makehtml(fwfList));
			fw.setPath("freeWebFiction.jsp");
			fw.setRedirect(false);
		}
		else {
			fw.setPath("/main");
			fw.setRedirect(false);
		}
		return fw;
	}

	private String makehtml(List<FaideWebFictionBean> fwfList) { //작품 목록 리스트 HTML
		StringBuilder sb= new StringBuilder();
		sb.append("<tr>");
		sb.append("<td>작품 번호</td>");
		sb.append("<td>작가</td>");
		sb.append("<td>작품 제목</td>");
		sb.append("<td>작품 소개</td>");
		sb.append("<td>등급</td>");
		sb.append("<td>장르</td>");
		sb.append("<td>총 추천수</td>");
		sb.append("</tr>");
		for(int i=0 ;i<fwfList.size();i++) {
			sb.append("<tr>");
			sb.append("<td>"+fwfList.get(i).getNovel_num()+"</td>");
			sb.append("<td>"+fwfList.get(i).getUser_id()+"</td>");
			sb.append("<td><a href='noveldetail?novelNum="+fwfList.get(i).getNovel_num()+"'>"+fwfList.get(i).getTitle()+"</a></td>");
			sb.append("<td>"+fwfList.get(i).getIntro()+"</td>");
			sb.append("<td>"+fwfList.get(i).getGrade()+"</td>");
			sb.append("<td>"+fwfList.get(i).getGenre()+"</td>");
			sb.append("<td>"+fwfList.get(i).getLike()+"</td>");
			sb.append("</tr>");
			
		
		}
		return sb.toString();
	}

	}

