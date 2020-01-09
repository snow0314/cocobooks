package service;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import dao.GenreDao;

public class Genre {

	
	public String genreShow() {
		GenreDao gDao=new GenreDao();
		List<String> list=new ArrayList<String>();
		list= gDao.genreShow();
		Gson gson=new Gson();
		
		return gson.toJson(list);
	}

}
