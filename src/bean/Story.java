package bean;

import java.sql.Date;

public class Story {
	private int SR_NUM;
	private int SR_NOBLE_NUM;
	private String SR_ID;
	private String SR_TITLE;
	private String SR_CONTENTS;
	private int SR_PRICE;
	private Date SR_DATE;
	private int SR_VIEW_NUM;
	
	public int getSR_NUM() {
		return SR_NUM;
	}
	public void setSR_NUM(int sR_NUM) {
		SR_NUM = sR_NUM;
	}
	public int getSR_NOBLE_NUM() {
		return SR_NOBLE_NUM;
	}
	public void setSR_NOBLE_NUM(int sR_NOBLE_NUM) {
		SR_NOBLE_NUM = sR_NOBLE_NUM;
	}
	public String getSR_ID() {
		return SR_ID;
	}
	public void setSR_ID(String sR_ID) {
		SR_ID = sR_ID;
	}
	public String getSR_TITLE() {
		return SR_TITLE;
	}
	public void setSR_TITLE(String sR_TITLE) {
		SR_TITLE = sR_TITLE;
	}
	public String getSR_CONTENTS() {
		return SR_CONTENTS;
	}
	public void setSR_CONTENTS(String sR_CONTENTS) {
		SR_CONTENTS = sR_CONTENTS;
	}
	public int getSR_PRICE() {
		return SR_PRICE;
	}
	public void setSR_PRICE(int sR_PRICE) {
		SR_PRICE = sR_PRICE;
	}
	public Date getSR_DATE() {
		return SR_DATE;
	}
	public void setSR_DATE(Date sR_DATE) {
		SR_DATE = sR_DATE;
	}
	public int getSR_VIEW_NUM() {
		return SR_VIEW_NUM;
	}
	public void setSR_VIEW_NUM(int sR_VIEW_NUM) {
		SR_VIEW_NUM = sR_VIEW_NUM;
	}
}
