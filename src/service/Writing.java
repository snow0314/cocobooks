package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Forward;
import bean.Member;
import dao.CheckDao;

public class Writing {
	HttpServletRequest request;
	HttpServletResponse response;

	public Writing(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public Forward check() {
		Forward fw = new Forward();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		CheckDao cDao = new CheckDao();
		List<String> list = cDao.categoryCheck();
		Member mb = cDao.check(id);
		if (mb.getKind().equals("일반")) {
			request.setAttribute("category", makeHtml(list));
			request.setAttribute("info", "무료");
			fw.setPath("novelPush.jsp");
			fw.setRedirect(false);
		} else if (mb.getKind().equals("유료")) {
			request.setAttribute("category", makeHtml(list));
			request.setAttribute("info", "유료");
			fw.setPath("novelPush.jsp");
			fw.setRedirect(false);
		} else {
			request.setAttribute("category", makeHtml(list));
			request.setAttribute("info", "관리");
			fw.setPath("novelPush.jsp");
			fw.setRedirect(false);
		}
		cDao.close();
		return fw;
	}

	private String makeHtml(List<String> list) {
		StringBuilder sb = new StringBuilder();
		sb.append("<select name='genre' class='gradeTxt'>");
		for (int i = 0; i < list.size(); i++) {
			sb.append("<option value='"+list.get(i)+"'>"+list.get(i)+"</option>");
		}
		sb.append("</select>");
		return sb.toString();
	}

}
