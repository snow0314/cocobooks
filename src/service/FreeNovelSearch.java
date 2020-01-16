package service;

import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import bean.FaideWebFictionBean;
import dao.FreesearchDao;

public class FreeNovelSearch {
	HttpServletRequest request;
	HttpServletResponse response;
	public FreeNovelSearch(HttpServletRequest request, HttpServletResponse response) {
		this.request=request;
		this.response=response;
	}
	public String search() {
		String json = null;
		String[] searchValue = request.getParameterValues("data1");
		System.out.println(searchValue[0]);
		System.out.println(searchValue[1]);
		FreesearchDao fDao = new FreesearchDao();
		List<FaideWebFictionBean> searchData = fDao.search(searchValue);
		fDao.close();
		if (searchData != null && searchData.size() != 0) {
			Gson gson = new Gson();
			Type shapeType = new TypeToken<List<FaideWebFictionBean>>() {}.getType();
			json = gson.toJson(searchData, shapeType);
			System.out.println("무료 검색 리스트"+json);
			return json;
		} else {
			return json;
		}
	}

}
