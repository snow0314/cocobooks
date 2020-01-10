package service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.GenreDao;

public class Genre {
	HttpServletRequest request;
	HttpServletResponse response;
	
	public Genre(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}

	public Genre() {
		// TODO Auto-generated constructor stub
	}

	public String genreShow() {
		GenreDao gDao=new GenreDao();
		List<String> list=new ArrayList<String>();
		list= gDao.genreShow();
		Gson gson=new Gson();
		
		return gson.toJson(list);
	}

	public String genreDelete() {
		GenreDao gDao=new GenreDao();
		int result=gDao.genereDelete(request.getParameter("genreName"));
		
		if(result==1) {
			return "장르 삭제 성공";
		}else {
			return "장르 삭제 실패";
		}
	}

	public String genreAdd() {
		GenreDao gDao=new GenreDao();
		int result=gDao.genreAdd(request.getParameter("genreName"));
		
		if(result==1) {
			return "장르 추가 성공";
		}else {
			return "장르 추가 실패";
		}
		
	}

}
