package bean;

public class Preference {
	String id;
	int novel_Num;
	String novel_title;
	
	public String getNovel_title() {
		return novel_title;
	}
	public void setNovel_title(String novel_title) {
		this.novel_title = novel_title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNovel_Num() {
		return novel_Num;
	}
	public void setNovel_Num(int novel_Num) {
		this.novel_Num = novel_Num;
	}
	
}
