package service;

import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import bean.FaideWebFictionBean;
import bean.Member;
import dao.searchDao;

public class PaidNovelSearch {
	HttpServletRequest request;
	HttpServletResponse response;

	public PaidNovelSearch(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public String search() {
		String json = null;
		String[] searchValue = request.getParameterValues("data1");
		System.out.println(searchValue[0]);
		System.out.println(searchValue[1]);
		searchDao sDao = new searchDao();
		List<FaideWebFictionBean> searchData = sDao.search(searchValue);
		sDao.close();
		if (searchData != null && searchData.size() != 0) {
			Gson gson = new Gson();
			Type shapeType = new TypeToken<List<FaideWebFictionBean>>() {
			}.getType();
			json = gson.toJson(searchData, shapeType);
			System.out.println(json);
			return json;
		} else {
			return json;
		}
	}

}
