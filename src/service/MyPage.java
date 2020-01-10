package service;

import bean.Forward;

public class MyPage {

	public Forward move() {
		Forward fw= new Forward();
		fw.setPath("myPage.jsp");
		fw.setRedirect(false);
		return fw;
	}

}
