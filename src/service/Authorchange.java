package service;


import bean.Forward;

public class Authorchange {


	public Forward move() {
		Forward fw= new Forward();
		fw.setPath("authorChange.jsp");
		fw.setRedirect(false);
		return fw;
	}

}
