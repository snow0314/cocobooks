package bean;

import oracle.sql.DATE;

public class UserBoard {
	private int UB_NUM;
	private String UB_ID;
	private String UB_TITLE;
	private String UB_CONTENTS;
	private DATE UB_DATE;
	private int UB_VIEW;
	public int getUB_NUM() {
		return UB_NUM;
	}
	public void setUB_NUM(int uB_NUM) {
		UB_NUM = uB_NUM;
	}
	public String getUB_ID() {
		return UB_ID;
	}
	public void setUB_ID(String uB_ID) {
		UB_ID = uB_ID;
	}
	public String getUB_TITLE() {
		return UB_TITLE;
	}
	public void setUB_TITLE(String uB_TITLE) {
		UB_TITLE = uB_TITLE;
	}
	public String getUB_CONTENTS() {
		return UB_CONTENTS;
	}
	public void setUB_CONTENTS(String uB_CONTENTS) {
		UB_CONTENTS = uB_CONTENTS;
	}
	public DATE getUB_DATE() {
		return UB_DATE;
	}
	public void setUB_DATE(DATE uB_DATE) {
		UB_DATE = uB_DATE;
	}
	public int getUB_VIEW() {
		return UB_VIEW;
	}
	public void setUB_VIEW(int uB_VIEW) {
		UB_VIEW = uB_VIEW;
	}
	
	
}
