package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Forward;

public class NovelInsert {
	HttpServletRequest request;
	HttpServletResponse response;
	public NovelInsert(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
	public Forward insert() {
		HttpSession session= request.getSession();
		String id =(String) session.getAttribute("id");
		String title=request.getParameter("title");
		String contents=request.getParameter("contents");
		String grade=request.getParameter("grade");
		String genre=request.getParameter("genre");
		String kind= request.getParameter("kind");
		System.out.println("아이디"+id);
		System.out.println("타이틀"+title);
		System.out.println("소개"+contents);
		System.out.println("등급"+grade);
		System.out.println("장르"+genre);
		System.out.println("유료 무료 관리"+kind);
		return null;
	}

}
