package bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Novel {
	String title;
	String intro;
	String grade;
	String genre;
	String pay_n_free;
	String id;
	int novel_num;
	
	public int getNovel_num() {
		return novel_num;
	}
	public void setNovel_num(int novel_num) {
		this.novel_num = novel_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPay_n_free() {
		return pay_n_free;
	}
	public void setPay_n_free(String pay_n_free) {
		this.pay_n_free = pay_n_free;
	}
	
}
