package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Forward;


public class Admin {
	HttpServletRequest request;
	HttpServletResponse response;

	public Admin(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public Forward adminCheck() {
		Forward fw = new Forward();

		fw.setPath("admin.jsp");
		fw.setRedirect(false);

		return fw;
	}

}
